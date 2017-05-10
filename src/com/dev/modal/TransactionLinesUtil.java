package com.dev.modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Transaction_Line;

public class TransactionLinesUtil
{
	Database_Connectivity conn;

	public TransactionLinesUtil()
	{
		try
		{
			conn = new Database_Connectivity();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public int addNewLine(Transaction_Line tl) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "INSERT INTO Transaction_Line (TransactionId, ItemId, Quantity, Discount, RetailPrice) "
				+ "VALUES (" + tl.getTransactionId() + ", " + tl.getItemId() + ", " + tl.getQuantity() + ", "
				+ tl.getDiscount() + ", " + tl.getRetailPrice() + ")";

		int result = statement.executeUpdate(sql);
		conn.getConn().close();

		if (result > 0)
			return getLatestCount();
		else
			return 0;
	}

	public int getLatestCount() throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "SELECT TransactionLineId from Transaction_Line ORDER BY TransactionLineId DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst())
		{
			System.out.println("No Data");
			return 0;
		}

		rs.next();
		return rs.getInt("TransactionLineId");
	}
}
