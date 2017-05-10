package com.dev.vc;

import java.sql.Date;

public class Stock
{

	private int itemId;
	private int currentStock;
	private int createdBy;
	private Date createDate;
	private int organizationId;

	public int getItemId()
	{
		return itemId;
	}

	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}

	public int getCurrentStock()
	{
		return currentStock;
	}

	public void setCurrentStock(int currentStock)
	{
		this.currentStock = currentStock;
	}

	public int getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(int createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public int getOrganizationId()
	{
		return organizationId;
	}

	public void setOrganizationId(int organizationId)
	{
		this.organizationId = organizationId;
	}
}
