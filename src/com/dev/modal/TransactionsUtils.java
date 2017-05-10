package com.dev.modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Transaction;

public class TransactionsUtils
{
	Database_Connectivity conn;

	public TransactionsUtils()
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

	public int addNewTransaction(Transaction transaction) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "INSERT INTO Transaction (OperatorId, TotalAmount, TotalQuantity, TotalDiscount, OrganizationId) "
				+ "VALUES ("
				+ transaction.getOperatorId()
				+ ", "
				+ transaction.getTotalAmount()
				+ ", "
				+ transaction.getTotalquantity()
				+ ", "
				+ transaction.getTotalDiscount()
				+ ", "
				+ transaction.getOrganizationId() + ")";

		int result = statement.executeUpdate(sql);
		conn.getConn().close();

		if (result > 0)
			return getLatestCount();
		else
			return 0;
	}

	public void updateTransaction(Transaction transaction) throws SQLException
	{
		String sql = "UPDATE Transaction set TotalAmount = ?, TotalDiscount = ?, TotalQuantity = ? WHERE TransactionId = ?";
		PreparedStatement statement = conn.getConn().prepareStatement(sql);

		statement.setDouble(1, transaction.getTotalAmount());
		statement.setDouble(2, transaction.getTotalDiscount());
		statement.setInt(3, transaction.getTotalquantity());
		statement.setInt(4, transaction.getTransactionId());

		statement.executeUpdate();
		conn.getConn().close();
	}

	public int getLatestCount() throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "SELECT TransactionId from Transaction ORDER BY TransactionId DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst())
		{
			System.out.println("No Data");
			return 0;
		}

		rs.next();
		return rs.getInt("TransactionId");
	}
}
