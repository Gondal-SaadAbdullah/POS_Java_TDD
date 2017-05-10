package com.dev.controller;

import java.sql.SQLException;

import com.dev.modal.OperatorUtil;
import com.dev.vc.Operator;

public class OperatorsControl
{
	private int operatorLogin;
	private String password;
	public int LOGGED_IN_OPERATOR_ID;
	
	public OperatorsControl()
	{
		operatorLogin = 12123;
		password = "123";
		
		LOGGED_IN_OPERATOR_ID = getOperatorId();
	}
	
	public int getOperatorId()
	{
		Operator opVc = new Operator();
		opVc.setOperatorLogin(operatorLogin);
		opVc.setPassword(password);
		
		OperatorUtil op = new OperatorUtil();
		try
		{
			return op.getOperatorId(opVc);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
