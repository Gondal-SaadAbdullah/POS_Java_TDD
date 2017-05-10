package com.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.TransactionItems;
import com.dev.controller.TransactionsManagement;

public class Integration_Transaction_Tests
{

	TransactionItems items;
	Collection<TransactionItems> itemsToSell;
	
	@Before
	public void setUp() throws Exception
	{
		itemsToSell = new ArrayList<TransactionItems>();
		items = new TransactionItems();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testValidItemIdZeroDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();
		items.setItemId(5);
		items.setQuantity(9);
		itemsToSell.add(items);
		assertEquals(13500, trans.validateStocksToSell(itemsToSell));		
	}
	
	@Test
	public void testNegativeItemId()
	{
		TransactionsManagement trans = new TransactionsManagement();
		items.setItemId(-20);
		items.setQuantity(25);
		itemsToSell.add(items);
		assertEquals(0, trans.validateStocksToSell(itemsToSell));
		fail("Invalid item ID");
	}
	
	@Test
	public void testZeroItemId()
	{
		TransactionsManagement trans = new TransactionsManagement();
		items.setItemId(0);
		items.setQuantity(80);
		itemsToSell.add(items);
		assertEquals(0, trans.validateStocksToSell(itemsToSell));
		fail("Invalid item ID");
	}

	@Test
	public void testUnknownItemId()
	{
		TransactionsManagement trans = new TransactionsManagement();
		items.setItemId(400);
		items.setQuantity(360);
		itemsToSell.add(items);
		assertEquals(0, trans.validateStocksToSell(itemsToSell));
		fail("Item ID do not exist");
	}
	
	@Test
	public void testCharItemId()
	{
		TransactionsManagement trans = new TransactionsManagement();
		//Compiler does not allow this statement
		//items.setItemId("to");
		items.setQuantity(80);
		itemsToSell.add(items);
		assertEquals(0, trans.validateStocksToSell(itemsToSell));
		fail("Invalid item ID");
	}
	
	@Test
	public void testValidItemIdTwentyDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();
		items.setItemId(5);
		items.setQuantity(900);
		itemsToSell.add(items);
		assertEquals(1080000, trans.validateStocksToSell(itemsToSell));		
	}
}
