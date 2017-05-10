package com.dev.vc;

import java.sql.Date;

public class Stock_Details
{
	private int stockDetailsId;
	private int StockId;
	private int quantity;
	private double OriginalPrice;
	private double RetailPrice;
	private Date StartDate;
	private boolean active;

	public int getStockDetailsId()
	{
		return stockDetailsId;
	}

	public void setStockDetailsId(int stockDetailsId)
	{
		this.stockDetailsId = stockDetailsId;
	}

	public int getStockId()
	{
		return StockId;
	}

	public void setStockId(int stockId)
	{
		StockId = stockId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getOriginalPrice()
	{
		return OriginalPrice;
	}

	public void setOriginalPrice(double originalPrice)
	{
		OriginalPrice = originalPrice;
	}

	public double getRetailPrice()
	{
		return RetailPrice;
	}

	public void setRetailPrice(double retailPrice)
	{
		RetailPrice = retailPrice;
	}

	public Date getStartDate()
	{
		return StartDate;
	}

	public void setStartDate(Date startDate)
	{
		StartDate = startDate;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

}
