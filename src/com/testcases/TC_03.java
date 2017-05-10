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

public class TC_03
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
	public void testStocksEntry()
	{
		StocksManagment stocks = new StocksManagment();
		assertEquals("Stocks not added", 1, stocks.insertStock(1, 1000, 150, 200));
		assertEquals("Stocks not added", 1, stocks.insertStock(2, 5000, 100, 110));
		assertEquals("Stocks not added", 1, stocks.insertStock(3, 800, 200, 250));
		assertEquals("Stocks not added", 1, stocks.insertStock(4, 8500, 100, 150));
		assertEquals("Stocks not added", 1, stocks.insertStock(5, 900, 20, 25));
	}

	@Test
	public void testCheckout()
	{
		TransactionItems item = new TransactionItems();
		item.setItemId(1);
		item.setQuantity(20);
		itemsToValidate.add(item);

		item = new TransactionItems();
		item.setItemId(2);
		item.setQuantity(50);
		itemsToValidate.add(item);

		item = new TransactionItems();
		item.setItemId(3);
		item.setQuantity(20);
		itemsToValidate.add(item);

		item = new TransactionItems();
		item.setItemId(4);
		item.setQuantity(70);
		itemsToValidate.add(item);

		item = new TransactionItems();
		item.setItemId(5);
		item.setQuantity(50);
		itemsToValidate.add(item);

		TransactionsManagement trans = new TransactionsManagement();
		int result = trans.validateStocksToSell(itemsToValidate);
		assertEquals("Some items did not have valid stocks available", 5, result);
	}

}
