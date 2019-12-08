package org.planning.test.jdbc;
import java.sql.*;

public class QueryTest {
	  public static void main(String[] args) throws ClassNotFoundException,
      SQLException {

	  // Get Connection
	  Connection connection = MySQLConnUtils.getMySQLConnection();
	
	  // Create statement
	  Statement statement = connection.createStatement();
	
	  String sql = "Select Emp_Id, Emp_No, Emp_Name from Employee";
	
	  // Execute SQL statement returns a ResultSet object.
	  ResultSet rs = statement.executeQuery(sql);
	
	  // Fetch on the ResultSet        
	  // Move the cursor to the next record.
	  while (rs.next()) {
	      int empId = rs.getInt(1);
	      String empNo = rs.getString(2);
	      String empName = rs.getString("Emp_Name");
	      System.out.println("--------------------");
	      System.out.println("EmpId:" + empId);
	      System.out.println("EmpNo:" + empNo);
	      System.out.println("EmpName:" + empName);
	  }
	
	  // Close connection.
	  connection.close();
}
}
