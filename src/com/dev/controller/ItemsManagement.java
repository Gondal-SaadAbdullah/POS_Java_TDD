package com.dev.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import com.dev.modal.ItemsUtil;
import com.dev.vc.Items;

public class ItemsManagement
{
	public ItemsManagement()
	{
		
	}
	
	public int addNewItem(String itemName)
	{
		Items item = new Items();
		item.setName(itemName);
		item.setCreatedBy(new OperatorsControl().LOGGED_IN_OPERATOR_ID);
		Date date = new Date();
		item.setCreateDate(new java.sql.Date(date.getTime()));
		
		// temporarily set to 1, need to get it according to user sign in details
		item.setOrganizationId(1);
		
		ItemsUtil itUtil = new ItemsUtil();
		try
		{
			int result = itUtil.addNewItem(item);
			return result;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateItem(Items item) throws SQLException
	{
		ItemsUtil itUtil = new ItemsUtil();
		return itUtil.updateItem(item);
	}
	
	public int deleteItem(int itemId) throws SQLException
	{
		ItemsUtil itUtil = new ItemsUtil();
		return itUtil.deleteItem(itemId);
	}
}
