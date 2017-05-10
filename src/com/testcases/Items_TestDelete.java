package com.testcases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.ItemsManagement;
import com.dev.modal.ItemsUtil;
import com.dev.vc.Items;

public class Items_TestDelete
{
	Items item = null;

	@Before
	public void setUp() throws Exception
	{
		ItemsUtil itemUtil = new ItemsUtil();

		item = itemUtil.getItemByItemId(10);
		item.setItemId(item.getItemId());
		item.setName(item.getName());
		item.setCreatedBy(item.getCreatedBy());
		item.setCreateDate(item.getCreateDate());
		item.setOrganizationId(item.getOrganizationId());
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testItemsDelete() throws SQLException
	{
		ItemsManagement items = new ItemsManagement();
		assertEquals("Item deleted successfully", 1, items.deleteItem(item.getItemId()));
	}

}
