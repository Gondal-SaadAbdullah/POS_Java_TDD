package com.dev.modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Items;

public class ItemsUtil
{
	Database_Connectivity conn;

	public ItemsUtil()
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

	public int addNewItem(Items item) throws SQLException, ParseException
	{
		Statement statement = conn.getConn().createStatement();

//		Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(item.getCreateDate().toString());
//		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		String sql = "INSERT INTO Items (Name, OrganizationId, CreatedBy) " + "VALUES ('"
				+ item.getName() + "' , " + item.getOrganizationId() + ", " + item.getCreatedBy() + ")";
		
		//System.out.println(">> " + sql);
		
		int result = statement.executeUpdate(sql);
		conn.getConn().close();
		return result;
	}

	public int deleteItem(int itemId) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "DELETE FROM Items WHERE ItemId = " + itemId + ";";

		int res = statement.executeUpdate(sql);
		conn.getConn().close();
		return res;
	}

	public Items getItemByItemId(int itemId) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();
		String sql = "SELECT * from Items WHERE ItemId = " + itemId;
		ResultSet rs = statement.executeQuery(sql);

		rs.next();
		Items item = new Items();
		item.setItemId(rs.getInt("ItemId"));
		item.setName(rs.getString("Name"));
		item.setCreatedBy(rs.getInt("CreatedBy"));
		item.setCreateDate(rs.getDate("CreateDate"));
		item.setOrganizationId(rs.getInt("OrganizationId"));
		return item;
	}
	
	public int updateItem(Items item) throws SQLException
	{
		String sql = "UPDATE Items set Name = ?, CreatedBy = ?";
		PreparedStatement statement = conn.getConn().prepareStatement(sql);

		statement.setString(1, item.getName());
		statement.setInt(2, item.getCreatedBy());

		int result = statement.executeUpdate();
		conn.getConn().close();
		return result;
	}

//	public int getLatestCount() throws SQLException
//	{
//		Statement statement = conn.getConn().createStatement();
//		String sql = "SELECT Items from Items ORDER BY Items DESC LIMIT 1";
//		ResultSet rs = statement.executeQuery(sql);
//		if (!rs.isBeforeFirst())
//		{
//			System.out.println("No Data");
//			return 0;
//		}
//
//		rs.next();
//		return rs.getInt("Items");
//	}
}
