package com.dev.vc;

import java.sql.Date;

public class Transaction
{
	private int transactionId;
	private int operatorId;
	private double totalAmount;
	private int totalquantity;
	private double totalDiscount;
	private int organizationId;
	private Date createDate;

	public int getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}

	public int getOperatorId()
	{
		return operatorId;
	}

	public void setOperatorId(int operatorId)
	{
		this.operatorId = operatorId;
	}

	public double getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public int getTotalquantity()
	{
		return totalquantity;
	}

	public void setTotalquantity(int totalquantity)
	{
		this.totalquantity = totalquantity;
	}

	public double getTotalDiscount()
	{
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount)
	{
		this.totalDiscount = totalDiscount;
	}

	public int getOrganizationId()
	{
		return organizationId;
	}

	public void setOrganizationId(int organizationId)
	{
		this.organizationId = organizationId;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

}
