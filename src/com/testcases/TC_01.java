package com.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.ItemsManagement;
import com.dev.controller.TransactionItems;
import com.dev.controller.TransactionsManagement;

public class TC_01
{
	Collection<TransactionItems> itemsToValidate;

	@Before
	public void setUp() throws Exception
	{
		itemsToValidate = new ArrayList<TransactionItems>();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testItemsAdd()
	{
		ItemsManagement items = new ItemsManagement();
		assertEquals("Item added", 1, items.addNewItem("Mouse"));
		assertEquals("Item added", 1, items.addNewItem("Keyboard"));
		assertEquals("Item added", 1, items.addNewItem("Monitor"));
		assertEquals("Item added", 1, items.addNewItem("CPU"));
		assertEquals("Item added", 1, items.addNewItem("HDMI"));
	}

	@Test
	public void testCheckout()
	{
		TransactionsManagement trans = new TransactionsManagement();
		int result = trans.validateStocksToSell(itemsToValidate);
		assertEquals("No Stocks available for any items", 0, result);
	}

}
