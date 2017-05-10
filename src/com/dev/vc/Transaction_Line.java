package com.dev.vc;

public class Transaction_Line
{
	private int transactionLineId;
	private int transactionId;
	private int itemId;
	private int quantity;
	private double discount;
	private double retailPrice;

	public int getTransactionLineId()
	{
		return transactionLineId;
	}

	public void setTransactionLineId(int transactionLineId)
	{
		this.transactionLineId = transactionLineId;
	}

	public int getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}

	public int getItemId()
	{
		return itemId;
	}

	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getDiscount()
	{
		return discount;
	}

	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	public double getRetailPrice()
	{
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice)
	{
		this.retailPrice = retailPrice;
	}
}
