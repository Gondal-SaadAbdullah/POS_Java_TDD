package com.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.ItemsManagement;
import com.dev.controller.StocksManagment;
import com.dev.controller.TransactionItems;
import com.dev.controller.TransactionsManagement;

public class TC_05
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
		assertEquals("Item added", 1, items.addNewItem("Kugelschreiber"));
	}

	@Test
	public void testStocksEntry()
	{
		StocksManagment stocks = new StocksManagment();
		assertEquals("Stocks not added", 1, stocks.insertStock(16, 50, 10, 12));
	}
	
	@Test
	public void testCheckout()
	{
		TransactionItems item = new TransactionItems();
		item.setItemId(16);
		item.setQuantity(100);
		itemsToValidate.add(item);

		TransactionsManagement trans = new TransactionsManagement();
		int result = trans.validateStocksToSell(itemsToValidate);
		assertEquals("No items selected to validate", -97, result);
	}
}
