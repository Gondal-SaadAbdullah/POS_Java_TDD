package com.dev.vc;

public class Operator
{
	private int operatorId;
	private int operatorLogin;
	private String password;
	private String name;
	private int organizationId;

	
	public int getOperatorId()
	{
		return operatorId;
	}

	public void setOperatorId(int operatorId)
	{
		this.operatorId = operatorId;
	}

	public int getOperatorLogin()
	{
		return operatorLogin;
	}

	public void setOperatorLogin(int operatorLogin)
	{
		this.operatorLogin = operatorLogin;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
