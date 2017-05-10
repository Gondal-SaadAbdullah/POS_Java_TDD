package com.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.TransactionItems;
import com.dev.controller.TransactionsManagement;

public class CheckOutCustomer_Tests
{
	TransactionItems items;
	Collection<TransactionItems> itemsToSell;

	@Before
	public void setUp() throws Exception
	{
		itemsToSell = new ArrayList<TransactionItems>();
		items = new TransactionItems();
		items.setItemId(5);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testZeroDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(9);
		itemsToSell.add(items);
		assertEquals(13500, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testTwoDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(25);
		itemsToSell.add(items);
		assertEquals(36750, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testFiveDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(80);
		itemsToSell.add(items);
		assertEquals(114000, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testTenDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(360);
		itemsToSell.add(items);
		assertEquals(486000, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testTwentyDiscount()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(900);
		itemsToSell.add(items);
		assertEquals(1080000, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testZeroQuantity()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(0);
		itemsToSell.add(items);
		assertEquals(0, trans.checkOutCustomer(itemsToSell));
	}

	@Test
	public void testNegativeQuantity()
	{
		TransactionsManagement trans = new TransactionsManagement();

		items.setQuantity(-97);
		itemsToSell.add(items);
		trans.checkOutCustomer(itemsToSell);
		fail("Invalid Item ID");
	}

	@Test
	public void testCharQuantity()
	{
		TransactionsManagement trans = new TransactionsManagement();

		// Compiler does not allow this statement
		// items.setQuantity("h");
		itemsToSell.add(items);
		trans.checkOutCustomer(itemsToSell);
		fail("Invalid Item ID");
	}
}
