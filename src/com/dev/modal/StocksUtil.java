package com.dev.modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Stock;

public class StocksUtil
{
	Database_Connectivity conn;

	public StocksUtil()
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

	public void addNewStock(Stock stock) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "INSERT INTO Stock (ItemId, CurrentStock, CreatedBy, OrganizationId) "
				+ "VALUES (" + stock.getItemId() + ", " + stock.getCurrentStock() + ", "
				+ stock.getCreatedBy() + ", " + stock.getOrganizationId()
				+ ")";

		statement.executeUpdate(sql);
		conn.getConn().close();
	}

	public void deleteStock(int stockId) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "DELETE FROM Stock WHERE StockId = " + stockId + ";";

		statement.executeUpdate(sql);
		conn.getConn().close();
	}

	/**
	 * 
	 * @param itemId
	 * @return StockId
	 * @throws SQLException
	 */
	public int getStockIdByItemId(int itemId)
	{
		try
		{
			Statement statement = conn.getConn().createStatement();
			String sql = "SELECT * from Stock WHERE ItemId = " + itemId;
			ResultSet rs;

			rs = statement.executeQuery(sql);
			rs.next();
			;
			return rs.getInt("StockId");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getStockQuantityByItemId(int itemId)
	{
		try
		{
			Statement statement = conn.getConn().createStatement();
			String sql = "SELECT * from Stock WHERE ItemId = " + itemId;
			ResultSet rs;

			rs = statement.executeQuery(sql);
			rs.next();
			;
			return rs.getInt("CurrentStock");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public void updateStockQuantityByStockId(int stockId, int stockQuantity) throws SQLException
	{
		String sql = "UPDATE Stock set CurrentStock = ? WHERE StockId = ?";
		PreparedStatement statement = conn.getConn().prepareStatement(sql);

		statement.setDouble(1, stockQuantity);
		statement.setDouble(2, stockId);		

		statement.executeUpdate();
		conn.getConn().close();
	}

	public int getLatestCount() throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "SELECT StockId from Stock ORDER BY StockId DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst())
		{
			System.out.println("No Data");
			return 0;
		}

		rs.next();
		return rs.getInt("StockId");
	}
}
