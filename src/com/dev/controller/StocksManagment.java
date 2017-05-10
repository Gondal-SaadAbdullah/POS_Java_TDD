package com.dev.controller;

import java.sql.SQLException;

import com.dev.modal.Stock_DetailsUtil;
import com.dev.modal.StocksUtil;
import com.dev.vc.Stock;
import com.dev.vc.Stock_Details;

public class StocksManagment
{

	public StocksManagment()
	{

	}

	
	/**
	 * @param itemId
	 * @param originalPrice
	 * @purpose checks if a stock exists already, if not then add it. Otherwise
	 *          simply adds a new row in Stock_Details against that item (or
	 *          StockId)
	 */
	public int insertStock(int itemId, int quantity, double originalPrice, double retailPrice)
	{
		StocksUtil stutil = new StocksUtil();
		//Date date = new Date();
		try
		{
			int stockId = stutil.getStockIdByItemId(itemId);

			// check to see if this item exists in stocks or not
			if (stockId == 0)
			{
				Stock stock = new Stock();
				stock.setItemId(itemId);
				stock.setCurrentStock(quantity);
				stock.setCreatedBy(new OperatorsControl().LOGGED_IN_OPERATOR_ID);
				//stock.setCreateDate(new java.sql.Date(date.getTime()));
				stock.setOrganizationId(1);

				stutil.addNewStock(stock);
			}

			Stock_Details stDetails = new Stock_Details();
			stDetails.setStockId(stockId);
			stDetails.setQuantity(quantity);
			stDetails.setOriginalPrice(originalPrice);
			stDetails.setRetailPrice(retailPrice);
			stDetails.setActive(true);

			Stock_DetailsUtil stDetailsUtil = new Stock_DetailsUtil();
			stDetailsUtil.addNewStockDetail(stDetails);
			
			stutil.updateStockQuantityByStockId(stockId, stDetailsUtil.getStockQuantity(stockId));
			
			return 1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void deleteStockById()
	{

	}
}
