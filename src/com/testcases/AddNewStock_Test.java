package com.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.StocksManagment;

public class AddNewStock_Test
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		StocksManagment sm = new StocksManagment();
		assertEquals(1, sm.insertStock(2, 150, 10, 12));		
	}

}
