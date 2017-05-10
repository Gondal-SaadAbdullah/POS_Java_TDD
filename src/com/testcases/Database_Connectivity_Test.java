package com.testcases;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev.controller.Database_Connectivity;

public class Database_Connectivity_Test
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
	public void testConnection()
	{
		try
		{
			Database_Connectivity conn = new Database_Connectivity();
			conn.getConn();
			System.out.println("Connection Recieved");
			conn.getConn().close();
		}
		catch (SQLException e)
		{
			fail("Error in database connectivity\n" + e.toString());
		}
	}
}