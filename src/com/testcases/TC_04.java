package com.testcases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.TransactionItems;
import com.dev.controller.TransactionsManagement;

public class TC_04
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
	public void testCheckout()
	{
		TransactionsManagement trans = new TransactionsManagement();
		int result = trans.validateStocksToSell(itemsToValidate);
		assertEquals("No items selected to validate", 0, result);
	}

}
