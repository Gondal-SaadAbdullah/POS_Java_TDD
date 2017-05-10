package com.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.ItemsManagement;

public class Items_TestAdd
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
	public void testItemsAdd()
	{		
		ItemsManagement items = new ItemsManagement();
		assertEquals("Item added", 1, items.addNewItem("Mouse"));
	}
	
}
