package com.dev.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.dev.modal.Stock_DetailsUtil;
import com.dev.modal.StocksUtil;
import com.dev.modal.TransactionLinesUtil;
import com.dev.modal.TransactionsUtils;
import com.dev.vc.Transaction;
import com.dev.vc.Transaction_Line;

public class TransactionsManagement
{

	public TransactionsManagement()
	{
	}

	public int validateStocksToSell(Collection<TransactionItems> itemsToValidate)
	{
		Collection<TransactionItems> itemsToSell = new ArrayList<TransactionItems>();
		StocksUtil stocksUtil = new StocksUtil();
		System.out.println(itemsToValidate.size());

		if (itemsToValidate != null && itemsToValidate.size() > 0)
		{
			for (TransactionItems transactionItems : itemsToValidate)
			{
				int currentStock = stocksUtil.getStockQuantityByItemId(transactionItems.getItemId());
				if (currentStock > 0)
				{
					if (currentStock >= transactionItems.getQuantity())
					{
						itemsToSell.add(transactionItems);
					}
					else
					{
						System.err.println("Stock is less that the quantity: " + transactionItems.getItemId());
						return -97;
					}
				}
				else
				{
					System.err.println("No item exists with item ID: " + transactionItems.getItemId());
				}
			}
			checkOutCustomer(itemsToSell);
			return itemsToSell.size();
		}
		else
		{
			System.err.println("No items presented to check out");
			return 0;
		}
	}

	/**
	 * check out a customer and manage Transaction and Transaction_Line
	 */
	public int checkOutCustomer(Collection<TransactionItems> itemsToSell)
	{
		if (itemsToSell != null && itemsToSell.size() > 0)
		{
			Transaction transaction = new Transaction();
			transaction.setOperatorId(new OperatorsControl().LOGGED_IN_OPERATOR_ID);
			transaction.setOrganizationId(1);

			// Date date = new Date();
			// transaction.setCreateDate(new java.sql.Date(date.getTime()));

			TransactionsUtils tu = new TransactionsUtils();
			Stock_DetailsUtil sdUtils = new Stock_DetailsUtil();
			try
			{
				int transactionId = tu.addNewTransaction(transaction);

				if (transactionId > 0)
				{
					TransactionLinesUtil tlutil = new TransactionLinesUtil();
					Transaction_Line tLine;
					int quantityTotal = 0;
					double discountTotal = 0, retailPriceTotal = 0;
					for (TransactionItems transactionItems : itemsToSell)
					{
						tLine = new Transaction_Line();
						tLine.setTransactionId(transactionId);
						tLine.setItemId(transactionItems.getItemId());
						tLine.setQuantity(transactionItems.getQuantity());
						
						if(transactionItems.getQuantity() > 0 && transactionItems.getQuantity() <= 15)
						{
							tLine.setDiscount(0);
						}
						else if(transactionItems.getQuantity() > 15 && transactionItems.getQuantity() <= 50)
						{
							tLine.setDiscount(2);
						}
						else if(transactionItems.getQuantity() > 50 && transactionItems.getQuantity() < 100)
						{
							tLine.setDiscount(5);
						}
						else if(transactionItems.getQuantity() >= 100 && transactionItems.getQuantity() <= 500)
						{
							tLine.setDiscount(10);
						}
						else if(transactionItems.getQuantity() > 500)
						{
							tLine.setDiscount(20);
						}
						
						tLine.setRetailPrice(transactionItems.getRetailPrice() - ((transactionItems.getRetailPrice() * tLine.getDiscount())/100));
						tlutil.addNewLine(tLine);

						quantityTotal += transactionItems.getQuantity();
						discountTotal += transactionItems.getDiscount();
						retailPriceTotal += transactionItems.getRetailPrice();

						// remove from stock_details according to the quantity
						// sold
						sdUtils.removeSoldStocks(transactionItems.getItemId(), transactionItems.getQuantity());
					}

					// updating total quantity, discount and retail price in
					// Transactions table
					transaction.setTransactionId(transactionId);
					transaction.setTotalAmount(retailPriceTotal);
					transaction.setTotalDiscount(discountTotal);
					transaction.setTotalquantity(quantityTotal);
					tu.updateTransaction(transaction);
					return 1;
				}
				else
				{
					System.err.println("Transaction not added successfully");
					return 0;
				}

			}
			catch (SQLException e)
			{
				e.printStackTrace();
				return 0;
			}
		}
		return 1;
	}
}
