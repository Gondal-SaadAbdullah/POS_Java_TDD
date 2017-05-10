package com.dev.modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Stock_Details;

public class Stock_DetailsUtil
{
	Database_Connectivity conn;

	public Stock_DetailsUtil()
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

	public int addNewStockDetail(Stock_Details stDetail) throws SQLException
	{
		// Statement statement = conn.getConn().createStatement();

		String sql = "INSERT INTO Stock_Details (StockId, Quantity, OriginalPrice, RetailPrice, Active) "
				+ "VALUES (?, ?, ?, ?, True)";

		PreparedStatement statement = conn.getConn().prepareStatement(sql);
		statement.setInt(1, stDetail.getStockId());
		statement.setInt(2, stDetail.getQuantity());
		statement.setDouble(3, stDetail.getOriginalPrice());
		statement.setDouble(4, stDetail.getRetailPrice());

		int result = statement.executeUpdate();
		// conn.getConn().close();
		return result;
	}

	public void deleteStockDetail(int stockDetailId) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "DELETE FROM Stock_Details WHERE StockDetailsId = " + stockDetailId + ";";

		statement.executeUpdate(sql);
		conn.getConn().close();
	}

	public int getStockQuantity(int stockId)
	{
		Statement statement;
		try
		{
			statement = conn.getConn().createStatement();
			String sql = "SELECT * from Stock_Details WHERE StockId = " + stockId + " AND ACTIVE IS TRUE";
			ResultSet rs = statement.executeQuery(sql);

			int totalQty = 0;
			while (rs.next())
			{
				totalQty += rs.getInt("Quantity");
			}
			conn.getConn().close();
			return totalQty;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}

	}

	public void removeSoldStocks(int itemId, int quantity)
	{
		// Get related stockId from Stock table, where itemId
		StocksUtil stutil = new StocksUtil();
		int stockId = stutil.getStockIdByItemId(itemId);
		int stockCleared = quantity;
		Collection<Stock_Details> stDetails = getStockDetailsByStockId(stockId);

		if (stDetails != null && stDetails.size() > 0)
		{
			for (Stock_Details stItems : stDetails)
			{
				if (stItems.getQuantity() >= stockCleared)
				{
					String sql = "UPDATE Stock_Details set Quantity = Quantity - ?, Active = ? WHERE StockDetailsId = ?";
					PreparedStatement statement;
					try
					{
						statement = conn.getConn().prepareStatement(sql);
						statement.setInt(1, stockCleared);

						if (stItems.getQuantity() == stockCleared)
							statement.setBoolean(2, false);

						statement.setInt(3, stItems.getStockDetailsId());
						statement.executeUpdate();
						stockCleared = 0;
						break;
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}					
				}
				else if(stItems.getQuantity() < stockCleared)
				{
					String sql = "UPDATE Stock_Details set Quantity = Quantity - ? WHERE StockDetailsId = ?";
					PreparedStatement statement;
					try
					{
						statement = conn.getConn().prepareStatement(sql);
						statement.setInt(1, stItems.getQuantity());						
						statement.setInt(3, stItems.getStockDetailsId());
						statement.executeUpdate();
						
						stockCleared = stockCleared - stItems.getQuantity();
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}					
				}
			}
		}
		else
		{
			System.err.println("No stocks found against stock id: " + stockId);
		}
	}

	/**
	 * 
	 * @param stockId
	 * @return
	 * @purpose get stock details in ascending order against a stockId
	 */
	public Collection<Stock_Details> getStockDetailsByStockId(int stockId)
	{
		Collection<Stock_Details> stDetails = new ArrayList<Stock_Details>();
		Stock_Details item = new Stock_Details();
		Statement statement;
		try
		{
			statement = conn.getConn().createStatement();
			String sql = "SELECT * from Stock_Details WHERE StockId = " + stockId;
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				item = new Stock_Details();
				item.setStockDetailsId(rs.getInt("StockDetailsId"));
				item.setStockId(rs.getInt("StockId"));
				item.setQuantity(rs.getInt("Quantity"));
				item.setOriginalPrice(rs.getDouble("OriginalPrice"));
				item.setRetailPrice(rs.getDouble("RetailPrice"));
				item.setStartDate(rs.getDate("StartDate"));
				item.setActive(rs.getBoolean("Active"));
				
				stDetails.add(item);
			}
			
		}
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
		
		return stDetails;
	}

	public int getLatestCount() throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "SELECT StockDetailsId from Stock_Details ORDER BY StockDetailsId DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst())
		{
			System.out.println("No Data");
			return 0;
		}

		rs.next();
		return rs.getInt("StockDetailsId");
	}
}
