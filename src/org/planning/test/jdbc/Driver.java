package org.planning.test.jdbc;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//connection to db
			Connection myConn = MySQLConnUtils.getMySQLConnection();
			
			//statement
			Statement myStmt = myConn.createStatement();
//			String sql = "Insert into EMPLOYEE ( fname, mname, lname, dob, ssn, c_level, c_branch, c_status, c_salary, c_man, c_proj, contact, email)"+"values ('FIRST', 'Middle', 'Last', '1990-09-16', 12341235, 10, 'B_M', 'S_E', '75000.00', 11111111, 10000001, 1516834567, 'saheilsaini_22@outlook.com')";
//			String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary) "
//	                + " values (2, 20000, 10000) ";
//			int rowCount = myStmt.executeUpdate(sql);    
//			System.out.println("Row Count affected = " + rowCount);

			//sql query
			ResultSet myRs = myStmt.executeQuery("select * from EMPLOYEE");
			
			//resultset
			while(myRs.next()) {
				String fname = myRs.getString("fname");
				String mname = myRs.getString("mname");
				String lname = myRs.getString("lname");
				String dob = myRs.getString("dob");
				String ssn = myRs.getString("ssn");
				String c_level = myRs.getString("c_level");
				String c_branch = myRs.getString("c_branch");
				String c_status = myRs.getString("c_status");
				String c_salary = myRs.getString("c_salary");
				String c_man = myRs.getString("c_man");
				String c_proj = myRs.getString("c_proj");
				String contact = myRs.getString("contact");
				String email = myRs.getString("email");
				System.out.println("fname"+fname+"\nmname " + mname + "\nlname " + lname  );
//				System.out.println(myRs.getString("fname")+","+ myRs.getString("EMP_NAME"));
			}
			
			}
		catch (Exception exc) {
			exc.printStackTrace();
		}

}
}
