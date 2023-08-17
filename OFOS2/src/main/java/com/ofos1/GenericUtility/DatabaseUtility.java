package com.ofos1.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;






public class DatabaseUtility {
	Connection con = null;
	

	public void connectToDB() throws SQLException 
	{ 
	    Driver driver=new Driver();
	    DriverManager.registerDriver(driver);
	    con=DriverManager.getConnection(IpathConstants.dbUrl, IpathConstants.dbUsername, IpathConstants.dbPassword);
	}
	/**
	 * 
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int columnNo,String ExpData) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag=true) {
			System.out.println("-----data is verified");
			return ExpData;
		}
		else {
			System.out.println("-------data is not present");
			return "";
		}
	}
	public void closeDB() throws SQLException {
		con.close();
	}

}
