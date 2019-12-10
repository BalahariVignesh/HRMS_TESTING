package org.planning.test.jdbc;

import java.sql.*;
import java.sql.PreparedStatement;

public class TestDao implements DAO {

String lnameref;
boolean login;
int rs;
	public void insertTest(Employee e) {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hr_database","root","root");
				String sqltest1 = "update EMPLOYEE SET FNAME =?, MNAME=? where LNAME=?";	
				java.sql.PreparedStatement ps = con.prepareStatement(sqltest1);
				ps.setString(1,e.getFNAME());
				ps.setString(2,e.getMNAME());
				ps.setString(3,"Last");
				int r = ps.executeUpdate();
				System.out.println("Rows updated = "+r);
				}
			catch(Exception ex) {
				}
		
		}
	
	//fetchEmployeePersonalDetails is called by PersonalInfoController   
	public Employee fetchEmployeePersonalDetails(Employee e) {
				Employee elocal = new Employee();
				try {
					System.out.println("Inside fetch function");
					Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hr_database","root","root");
					//Removed DOB from the insert query as DOB typecasting is pending
					String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
					//String sqltest = "INSERT INTO EMPLOYEE (Fname, Mname, Lname, DOB, SSN, C_LEVEL, C_BRANCH, C_STATUS, C_SALARY, RATING, C_MAN, C_PROJ, COUNTRY, CITY, ZIP, CONTACT, EMAIL) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed empid is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()) {
						System.out.println("Printing fetched from inside the function Firstname from DB "+rs.getString("FNAME"));
						elocal.setFNAME(rs.getString("FNAME"));
						System.out.println("FNAME is "+rs.getString("FNAME"));
						elocal.setMNAME(rs.getString("MNAME"));
						System.out.println("MNAME is "+rs.getString("MNAME"));
						elocal.setLNAME(rs.getString("LNAME"));
						System.out.println("LNAME is "+rs.getString("LNAME"));
						elocal.setDOB(Date.valueOf(rs.getString("DOB")));
						System.out.println("DOB is "+rs.getString("DOB"));
						elocal.set_sno(Integer.parseInt(rs.getString("SSN")));
						System.out.println("ssn is "+rs.getString("SSN"));
						elocal.setMAR(rs.getString("MAR"));
						System.out.println("MAR is "+rs.getString("MAR"));
						}
					rs.close();
					Con.close();
					}
				catch(Exception ex) {
					System.out.println(ex); 
					}
				return elocal;
			}
	//login function is called by Login Controller
		public Employee login(Employee e)throws SQLException, ClassNotFoundException {
				Employee elocal = new Employee();
				//boolean login = true; 
				try {
				   System.out.println("Inside LOGIN function");
				   Connection Con = MySQLConnUtils.getMySQLConnection();
				   String sql = "SELECT * FROM logon WHERE EMP_ID=?";
				   PreparedStatement ps = Con.prepareStatement(sql);
				   System.out.println("Passed login NAME is "+e.getEMP_ID());
				   System.out.println("Passed password is "+e.getPWD());
				   ps.setString(1, String.valueOf(e.getEMP_ID()));
				   //ps.setString(2, e.getPWD());
				   ResultSet rs= ps.executeQuery();
				   while(rs.next()){
					   elocal.setPWD(rs.getString("PSW"));
					   
					   System.out.println("Password from db is "+elocal.getPWD());
					   if(elocal.getPWD().matches(e.getPWD())) {
						   elocal.setLogin(true);
						   elocal.setEMP_ID(e.getEMP_ID());
						   elocal.setACC_type(rs.getString("ACC_ID"));//Role of the employee is set only if the password matches with the given password.
					   }
					   else
					   {
						   elocal.setLogin(false);
					   }
					   System.out.println("Printing from inside the function given pwd is"+elocal.getPWD()+"\nPassword from DB is"+rs.getString("PSW"));
					   
				   	}
				   rs.close();
				   Con.close();
				   }
				   
				catch(SQLException ex) {
				  System.out.println(ex); 
			   		}
				return elocal;
				}
		//contactinfo is called by ContactInfoController
		public Employee contactinfo(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside contactinfo function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					
					String sql = "select Contact,con_typ from Contact where emp_id=?";
					
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
						if(rs.getString("con_typ").matches("C_P"))
						{
							elocal.setCONTACT(Integer.parseInt(rs.getString("CONTACT")));
							System.out.println("Personal no is"+elocal.getCONTACT());
						}
						else if(rs.getString("con_typ").matches("C_E"))
						{
							elocal.setECONTACT(Integer.parseInt(rs.getString("CONTACT")));
							System.out.println("Emergency no is"+elocal.getECONTACT());
						}
						else if (rs.getString("con_typ").matches("C_O"))
						{
							elocal.setOCONTACT(Integer.parseInt(rs.getString("CONTACT")));
							System.out.println("Office no is"+elocal.getOCONTACT());
						}
						
						
//						elocal.setCONTACT(Integer.parseInt(rs.getString("CONTACT")));
//						//elocal.setPWD(rs.getString("PSW"));
//						System.out.println("Personal Contact from DB is "+elocal.getCONTACT());
					}
					String sql2 = "Select EMAIL, EMAIL_TYP from EMAIL WHERE EMP_ID = ? ";
					ps = Con.prepareStatement(sql2);
					System.out.println("Running query 2 for fetching email id ,Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					rs= ps.executeQuery();
					while(rs.next()){
						if(rs.getString("EMAIL_TYP").matches("C_P"))
						{
							elocal.setPERSONAL_EMAIL(rs.getString("EMAIL"));
							System.out.println("Personal EMAIL is"+elocal.getPERSONAL_EMAIL());
						}
						else if(rs.getString("EMAIL_TYP").matches("C_O"))
						{
							elocal.setOFFICIAL_EMAIL(rs.getString("EMAIL"));
							System.out.println("OFFICIAL EMAIL is"+elocal.getOFFICIAL_EMAIL());
						}}
					
					rs.close();
					Con.close();
					}
				catch(SQLException ex) {
					  	System.out.println(ex); 
				   		}
					return elocal;
		}
		public int contactedit(Employee e)throws SQLException, ClassNotFoundException{
			;
			//Employee elocal = new Employee();
			try {
				System.out.println("Inside contactedit function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				String sql = "UPDATE EMPLOYEE SET MNAME = ? , LNAME = ? , MAR = ? WHERE EMP_ID = ?";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(4, String.valueOf(e.getEMP_ID()));
				ps.setString(1,e.getMNAME());
				ps.setString(2,e.getLNAME());
				ps.setString(3,e.getMAR());
				rs= ps.executeUpdate();
				if(rs>0){
					System.out.println("Successfully updated\n"+rs+"Rows Affected");
				}
				//rs.close();
				Con.close();
				}
			catch(SQLException ex) {
				  	System.out.println(ex); 
			   		}
				return rs;
	}
		//function for getting office address info
		public Employee officeaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside officeaddressinfo function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				String sql = "Select TYPETABLE.VAL AS 'ADDRESS TYPE', max(ADD_MAP.S_DATE) as 'START DATE', ADDRESS.ADDR, ADDRESS.STREET, ADDRESS.CITY, ADDRESS.COUNTRY, ADDRESS.ZIP from ADD_MAP LEFT OUTER JOIN ADDRESS ON ADD_MAP.ADD_ID = ADDRESS.ADD_ID LEFT OUTER JOIN TYPETABLE ON ADDRESS.ADD_TYP = TYPETABLE.TYPE_ID WHERE EMP_ID = ? AND add_typ = 'AD_O' ";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(1, String.valueOf(e.getEMP_ID()));
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					elocal.setOFFICIAL_ADDR(rs.getString("ADDR"));
					System.out.println("ADDR is "+elocal.getOFFICIAL_ADDR());
					elocal.setOFFICIAL_STREET(rs.getString("STREET"));
					System.out.println("STREET is "+elocal.getOFFICIAL_STREET());
					elocal.setOFFICIAL_CITY(rs.getString("CITY"));
					System.out.println("CITY is "+elocal.getOFFICIAL_CITY());
					elocal.setOFFICIAL_COUNTRY(rs.getString("COUNTRY"));
					System.out.println("Country is "+elocal.getOFFICIAL_COUNTRY());
					elocal.setOFFICIAL_ZIP(Integer.parseInt(rs.getString("ZIP")));
					System.out.println("ZIP is "+elocal.getOFFICIAL_ZIP());
				}
				rs.close();
				Con.close();
				}
			catch(SQLException ex) {
				  	System.out.println(ex); 
			   		}
				return elocal;
	}
		//function for permanent addressinfo
		public Employee permanentaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside permanentaddressinfo function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				String sql = "Select TYPETABLE.VAL AS 'ADDRESS TYPE', max(ADD_MAP.S_DATE) as 'START DATE', ADDRESS.ADDR, ADDRESS.STREET, ADDRESS.CITY, ADDRESS.COUNTRY, ADDRESS.ZIP from ADD_MAP LEFT OUTER JOIN ADDRESS ON ADD_MAP.ADD_ID = ADDRESS.ADD_ID LEFT OUTER JOIN TYPETABLE ON ADDRESS.ADD_TYP = TYPETABLE.TYPE_ID WHERE EMP_ID = ? AND add_typ = 'AD_P'";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(1, String.valueOf(e.getEMP_ID()));
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					elocal.setPERMANENT_ADDR(rs.getString("ADDR"));
					System.out.println("ADDR is "+elocal.getPERMANENT_ADDR());
					elocal.setPERMANENT_STREET(rs.getString("STREET"));
					System.out.println("STREET is "+elocal.getPERMANENT_STREET());
					elocal.setPERMANENT_CITY(rs.getString("CITY"));
					System.out.println("CITY is "+elocal.getPERMANENT_CITY());
					elocal.setPERMANENT_COUNTRY(rs.getString("COUNTRY"));
					System.out.println("Country is "+elocal.getPERMANENT_COUNTRY());
					elocal.setPERMANENT_ZIP(Integer.parseInt(rs.getString("ZIP")));
					System.out.println("ZIP is "+elocal.getPERMANENT_ZIP());
					}
				rs.close();
				Con.close();
				}
			catch(SQLException ex) {
				  	System.out.println(ex); 
			   		}
				return elocal;
	}
		//function for present address info
		public Employee presentaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside presentaddressinfo function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				String sql = "Select TYPETABLE.VAL AS 'ADDRESS TYPE', max(ADD_MAP.S_DATE) as 'START DATE', ADDRESS.ADDR, ADDRESS.STREET, ADDRESS.CITY, ADDRESS.COUNTRY, ADDRESS.ZIP from ADD_MAP LEFT OUTER JOIN ADDRESS ON ADD_MAP.ADD_ID = ADDRESS.ADD_ID LEFT OUTER JOIN TYPETABLE ON ADDRESS.ADD_TYP = TYPETABLE.TYPE_ID WHERE EMP_ID = ? AND add_typ = 'AD_C'";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(1, String.valueOf(e.getEMP_ID()));
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					elocal.setPRESENT_ADDR(rs.getString("ADDR"));
					System.out.println("ADDR is "+elocal.getPRESENT_ADDR());
					elocal.setPRESENT_STREET(rs.getString("STREET"));
					System.out.println("STREET is "+elocal.getPRESENT_STREET());
					elocal.setPRESENT_CITY(rs.getString("CITY"));
					System.out.println("CITY is "+elocal.getPRESENT_CITY());
					elocal.setPRESENT_COUNTRY(rs.getString("COUNTRY"));
					System.out.println("Country is "+elocal.getPRESENT_COUNTRY());
					elocal.setPRESENT_ZIP(Integer.parseInt(rs.getString("ZIP")));
					System.out.println("ZIP is "+elocal.getPRESENT_ZIP());
					}
				rs.close();
				Con.close();
				}
			catch(SQLException ex) {
				  	System.out.println(ex); 
			   		}
				return elocal;
	}
		//function for fetching office info status,level,proj manager...
		//not yet completed
				public Employee officeinfo(Employee e)throws SQLException, ClassNotFoundException{
					Employee elocal = new Employee();
					try {
						System.out.println("Inside officeinfo function");
						Connection Con = MySQLConnUtils.getMySQLConnection();
						String sql = "Select TYPETABLE.VAL AS 'ADDRESS TYPE', max(ADD_MAP.S_DATE) as 'START DATE', ADDRESS.ADDR, ADDRESS.STREET, ADDRESS.CITY, ADDRESS.COUNTRY, ADDRESS.ZIP from ADD_MAP LEFT OUTER JOIN ADDRESS ON ADD_MAP.ADD_ID = ADDRESS.ADD_ID LEFT OUTER JOIN TYPETABLE ON ADDRESS.ADD_TYP = TYPETABLE.TYPE_ID WHERE EMP_ID = ? AND add_typ = 'AD_C'";
						PreparedStatement ps = Con.prepareStatement(sql);
						System.out.println("Passed login NAME is "+e.getEMP_ID());
						ps.setString(1, String.valueOf(e.getEMP_ID()));
						ResultSet rs= ps.executeQuery();
						while(rs.next()){
							elocal.setPRESENT_ADDR(rs.getString("ADDR"));
							System.out.println("ADDR is "+elocal.getPRESENT_ADDR());
							elocal.setPRESENT_STREET(rs.getString("STREET"));
							System.out.println("STREET is "+elocal.getPRESENT_STREET());
							elocal.setPRESENT_CITY(rs.getString("CITY"));
							System.out.println("CITY is "+elocal.getPRESENT_CITY());
							elocal.setPRESENT_COUNTRY(rs.getString("COUNTRY"));
							System.out.println("Country is "+elocal.getPRESENT_COUNTRY());
							elocal.setPRESENT_ZIP(Integer.parseInt(rs.getString("ZIP")));
							System.out.println("ZIP is "+elocal.getPRESENT_ZIP());
							}
						rs.close();
						Con.close();
						}
					catch(SQLException ex) {
						  	System.out.println(ex); 
					   		}
						return elocal;
			}
			//To edit the personal, emergency and office contact number.
			public int editemail(Employee e)throws SQLException, ClassNotFoundException{
				try {
					System.out.println("Inside editemail function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String sql = "UPDATE EMAIL SET EMAIL = ? WHERE EMP_ID =? and EMAIL_TYP = 'C_P'";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					System.out.println("flag1");
					ps.setString(1,e.getPERSONAL_EMAIL());
					System.out.println("flag2");
					ps.setString(2,String.valueOf(e.getEMP_ID()));
					System.out.println("flag3");
					
					rs= ps.executeUpdate();
					Con.close();
					}
					catch(SQLException ex) {
					  	System.out.println(ex); 
					  		}
					return rs;
			}
			public int editcontactnumber(Employee e)throws SQLException, ClassNotFoundException{
				try {
					System.out.println("Inside editcontactnumber function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String personal_number_update = "UPDATE CONTACT SET CONTACT = ? WHERE EMP_ID = ? and CON_TYP = 'C_P'";
					String emergency_number_update = "UPDATE CONTACT SET CONTACT = ? WHERE EMP_ID = ? and CON_TYP = 'C_E'";
					PreparedStatement ps1 = Con.prepareStatement(personal_number_update);
					PreparedStatement ps2 = Con.prepareStatement(emergency_number_update);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					
					
					System.out.println("flag2");
					System.out.println("flag3");
					if(e.getECONTACT() != 0 && e.getCONTACT() != 0) {// both numbers have to be updated
						//update both personal and emergency number
						System.out.println("Passed personal number is "+e.getCONTACT());
						ps1.setString(1, String.valueOf(e.getCONTACT()));
						ps1.setString(2, String.valueOf(e.getEMP_ID()));
						System.out.println("Passed personal number is "+e.getCONTACT());
						rs=ps1.executeUpdate();
						System.out.println("Passed emergency number is "+e.getECONTACT());
						ps2.setString(1, String.valueOf(e.getECONTACT()));
						ps2.setString(2, String.valueOf(e.getEMP_ID()));
						rs = ps2.executeUpdate();
						return rs;
					}
					else if (e.getECONTACT() != 0) {//if personal contact field is empty and emergency has content
						//update emergency number only
						System.out.println("Passed emergency number is "+e.getECONTACT());
						ps2.setString(1, String.valueOf(e.getECONTACT()));
						ps2.setString(2, String.valueOf(e.getEMP_ID()));
						rs = ps2.executeUpdate();
						return rs;
					}
					else if(e.getCONTACT() != 0) {
						//if emergency field is empty and personal field has content
						//update personal number only
						System.out.println("Passed personal number is "+e.getCONTACT());
						System.out.println("flag1");
						ps1.setString(1, String.valueOf(e.getCONTACT()));
						System.out.println("flag2");
						ps1.setString(2, String.valueOf(e.getEMP_ID()));
						System.out.println("flag3");
						rs=ps1.executeUpdate();
						return rs;
					}
					else if(e.getECONTACT() == 0 && e.getCONTACT() == 0) {
						System.out.println("Both are empty");
						//code to show alert both fields are empty
					}
					
					Con.close();
					}
					catch(SQLException ex) {
					  	System.out.println(ex); 
					  		}
					return rs;
			}
}

