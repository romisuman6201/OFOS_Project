package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSqldatabase {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result = 0;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OFOS2", "root", "root");
			// create statement
			Statement state = con.createStatement();
			String query = "insert into Order_List values(1,'IDLI',350);";
			// execute query
			result=state.executeUpdate(query);
//			while (result.next()) {
//				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getShort(3));
//			}
		} catch (Exception e) {

		} finally {
			if(result>0) {
				System.out.println("data updated successfully");
			}else {
				System.out.println("data not inserted");
			}
			con.close();
		}

		{

		}
	}

}
