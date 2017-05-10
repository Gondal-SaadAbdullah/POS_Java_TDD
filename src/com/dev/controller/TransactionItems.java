package com.dev.controller;

public class TransactionItems
{

	private int itemId;
	private int quantity;
	private int discount;
	private int retailPrice;
	private boolean activeStatus;

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

	public int getDiscount()
	{
		return discount;
	}

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	public int getRetailPrice()
	{
		return retailPrice;
	}

	public void setRetailPrice(int retailPrice)
	{
		this.retailPrice = retailPrice;
	}

	public boolean isActiveStatus()
	{
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus)
	{
		this.activeStatus = activeStatus;
	}

}
