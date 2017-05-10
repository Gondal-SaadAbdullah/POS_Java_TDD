package com.dev.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connectivity
{
	private final Connection conn;

	public Database_Connectivity() throws SQLException
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/pos_tdd?user=root&password=root");
		}
		catch (SQLException ex)
		{
			System.err.println(ex.getStackTrace());
			throw ex;
		}
	}

	public Connection getConn()
	{
		return conn;
	}

	//
	// public int getOperatorId(Database_Connectivity con) throws SQLException
	// {
	// Statement statement = con.getConn().createStatement();
	//
	// // Need to filter by OrganizationId as well. But omitting it right now
	// // since I have to work with only one organization at this point
	// String sql = "SELECT * from Operator WHERE OperatorId = " + 1;
	//
	// ResultSet rs = statement.executeQuery(sql);
	// if (!rs.isBeforeFirst())
	// {
	// System.out.println("No Data");
	// return 0;
	// }
	//
	// rs.next();
	// return rs.getInt("OperatorId");
	// }

}
