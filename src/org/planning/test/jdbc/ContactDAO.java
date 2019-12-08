package org.planning.test.jdbc;

import java.sql.*;
import java.sql.PreparedStatement;
public class ContactDAO implements DAO {
   private Employee createEmployee(ResultSet rs) {
      Employee e = new Employee();
      try {
    	  e.setEMP_ID(rs.getInt(1));
    	  e.setFNAME(rs.getString(2));
    	  e.setMNAME(rs.getString(3));
    	  e.setLNAME(rs.getString(4));
    	  e.setDOB(rs.getDate(5));
    	  e.set_sno(rs.getInt(6));
    	  e.setC_LEVEL(rs.getInt(7));
    	  e.setC_Branch(rs.getString(8));
    	  e.setC_STATUS(rs.getString(9));
    	  e.setC_SALARY(rs.getFloat(10));
    	  e.setRATING(rs.getInt(11));
    	  e.setC_MAN(rs.getInt(12));
    	  e.setC_PROJ(rs.getInt(13));
    	//  e.setCOUNTRY(rs.getString(14));
    	 // e.setCITY(rs.getString(15));
//    	  e.setZIP(rs.getInt());
//    	  e.setCONTACT(rs.getInt());
//    	  e.setEMAIL(rs.getString());
//         p.setId(rs.getInt("id"));
//         p.setName(rs.getString("name"));
//         p.setNickName(rs.getString("nick_name"));
//         p.setAddress(rs.getString("address"));
//         p.setHomePhone(rs.getString("home_phone"));
//         p.setWorkPhone(rs.getString("work_phone"));
//         p.setCellPhone(rs.getString("cell_phone"));
//         p.setEmail(rs.getString("email"));
//         p.setBirthDate(rs.getDate("birthday"));
//         p.setWebSite(rs.getString("web_site"));
//         p.setProfession(rs.getString("profession"));
      } 
      catch (SQLException ex) {
      }
      return e;
   }

   public void insertEmployee(Employee e) {
	   
	   //create connection with db to insert the employee data values
	   try {
		   Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hr_database","root","root");
		   //Removed DOB from the insert query as DOB typecasting is pending
		   String sqltest = "INSERT INTO EMPLOYEE (Fname, Mname, Lname, DOB, SSN, C_LEVEL, C_BRANCH, C_STATUS, C_SALARY, RATING, C_MAN, C_PROJ, COUNTRY, CITY, ZIP, CONTACT, EMAIL) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps = Con.prepareStatement(sqltest);
		   ps.setString(1,e.getFNAME());
		   ps.setString(2,e.getMNAME());
		   ps.setString(3, e.getLNAME());
		   ps.setDate(4,e.getDOB());
		   ps.setLong(5, e.get_sno());
		   ps.setLong(7, e.getC_LEVEL());
		   ps.setString(8,e.getC_Branch());
		   ps.setString(9,e.getC_STATUS());
		   ps.setFloat(10,e.getC_SALARY());
		   ps.setInt(11,e.getRATING());
		   ps.setInt(12,e.getC_MAN());
		   ps.setInt(13, e.getC_PROJ());
		 //  ps.setString(14, e.getCITY());
		   //ps.setString(15, e.getCOUNTRY());
		   ps.setInt(16, e.getCONTACT());
		  // ps.setInt(17, e.getZIP());
		   int rowsAffected = ps.executeUpdate();
		   
		   System.out.println(rowsAffected+"Rows affected");
		   ps.close();
		   Con.close();
	   }
	   catch(Exception ex) {
		   
	   }}
   //fetchEmployeePersonalDetails is a test function to get personal details of emplyee from mysql and display their details.
   //as of now lnameref is a used as a login parameter to be passed along with this function to fetch the appropriate employee details
   
	   public void fetchEmployeePersonalDetails(Employee e) {
		   try {
			   Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hr_database","root","root");
			   //Removed DOB from the insert query as DOB typecasting is pending
			   String sql = "SELECT * FROM EMPLOYEE WHERE LNAME=?";
			   String sqltest = "INSERT INTO EMPLOYEE (Fname, Mname, Lname, DOB, SSN, C_LEVEL, C_BRANCH, C_STATUS, C_SALARY, RATING, C_MAN, C_PROJ, COUNTRY, CITY, ZIP, CONTACT, EMAIL) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			   PreparedStatement ps = Con.prepareStatement(sql);
			   ps.setString(1, "lnameref");
			   ResultSet rs= ps.executeQuery();
			   
		   		}
		   catch(Exception ex) {
			   
		   }
	   
   }
}