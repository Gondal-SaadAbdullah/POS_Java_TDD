package com.dev.modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.controller.Database_Connectivity;
import com.dev.vc.Operator;

public class OperatorUtil
{
	Database_Connectivity conn;

	public OperatorUtil()
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

	public int getOperatorId(Operator op) throws SQLException
	{
		Statement statement = conn.getConn().createStatement();

		// Need to filter by OrganizationId as well. But omitting it right now
		// since I have to work with only one organization at this point
		String sql = "SELECT * from Operator WHERE OperatorLogin = " + op.getOperatorLogin()
				+ " AND Password = '" + op.getPassword() + "'";
//		System.out.println("Get Operator Query :: " + sql);

		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst())
		{
			System.out.println("No Data");
			return 0;
		}

		rs.next();
		return rs.getInt("OperatorId");
	}
}
