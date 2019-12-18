package org.planning.test.jdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestDao implements DAO {

String lnameref;
boolean login;
//

//for assets
String[] asset_name = new String[10];
int[] asset_id;

int rs;
int rs1;
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
				String sql = "SELECT EMP_ID, (SELECT VAL FROM TYPETABLE WHERE TYPE_ID = ADD_TYP),ADDR,STREET,CITY,COUNTRY,ZIP FROM ADDRESS WHERE EMP_ID = ? AND ADD_TYP = 'AD_O'";
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
				String sql = "SELECT EMP_ID, (SELECT VAL FROM TYPETABLE WHERE TYPE_ID = ADD_TYP),ADDR,STREET,CITY,COUNTRY,ZIP FROM ADDRESS WHERE EMP_ID = ? AND add_typ = 'AD_P'";
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
		//function for editing permanent address info
		public int editpermanentaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside editpermanentaddressinfo function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				Connection Con2 = MySQLConnUtils.getMySQLConnection();
				String sql = "Select emp_id from address WHERE EMP_ID = ? AND ADD_TYP = 'AD_P'";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(1, String.valueOf(e.getEMP_ID()));
				ResultSet rs= ps.executeQuery();
				if(rs.next()){
					String sql2 = "UPDATE ADDRESS SET ADDR = ?, STREET = ?, CITY = ?, COUNTRY = ?, ZIP = ? WHERE EMP_ID = ? AND ADD_TYP = 'AD_P'";
					System.out.println("Address already exists so updating");
					PreparedStatement ps1 = Con2.prepareStatement(sql2);
					ps1.setString(1,e.getPERMANENT_ADDR());
					ps1.setString(2,e.getPERMANENT_STREET());
					ps1.setString(3,e.getPERMANENT_CITY());
					ps1.setString(4,e.getPERMANENT_COUNTRY());
					ps1.setString(5,String.valueOf(e.getPERMANENT_ZIP()));
					ps1.setString(6, String.valueOf(e.getEMP_ID()));
					rs1 = ps1.executeUpdate();
					return rs1;
					}
				else
					{
					String sql3 = "INSERT INTO address(EMP_ID, ADD_TYP,ADDR,STREET,CITY,COUNTRY,ZIP) VALUES (?, ?, ?, ?, ?, ?, ?) ";
					System.out.println("Address does not exist so inserting");
					PreparedStatement ps1 = Con.prepareStatement(sql3);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					ps1.setString(2,"AD_P");
					System.out.println("Printing from inside the testdao"+elocal.getPERMANENT_ADDR());
					ps1.setString(3,e.getPERMANENT_ADDR());
					ps1.setString(4,e.getPERMANENT_STREET());
					ps1.setString(5,e.getPERMANENT_CITY());
					ps1.setString(6,e.getPERMANENT_COUNTRY());
					ps1.setString(7,String.valueOf(e.getPERMANENT_ZIP()));
					rs1 = ps1.executeUpdate();
					return rs1;
					}
				//rs.close();
				//Con.close();
				}
			catch(SQLException ex) {
			  	System.out.println(ex); 
			   		}
				return rs;
		}
		//function for present address info
		public Employee presentaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside presentaddressinfo function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				String sql = "SELECT EMP_ID, (SELECT VAL FROM TYPETABLE WHERE TYPE_ID = ADD_TYP),ADDR,STREET,CITY,COUNTRY,ZIP FROM ADDRESS WHERE EMP_ID = ? AND ADD_TYP ='AD_C'";
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
		//function for editing PRESENT address info
		public int editpresentaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
			Employee elocal = new Employee();
			try {
				System.out.println("Inside edit present address info function");
				Connection Con = MySQLConnUtils.getMySQLConnection();
				Connection Con2 = MySQLConnUtils.getMySQLConnection();
				String sql = "Select emp_id from address WHERE EMP_ID = ? AND ADD_TYP = 'AD_C'";
				PreparedStatement ps = Con.prepareStatement(sql);
				System.out.println("Passed login NAME is "+e.getEMP_ID());
				ps.setString(1, String.valueOf(e.getEMP_ID()));
				ResultSet rs= ps.executeQuery();
				if(rs.next()){
					String sql2 = "UPDATE ADDRESS SET ADDR = ?, STREET = ?, CITY = ?, COUNTRY = ?, ZIP = ? WHERE EMP_ID = ? AND ADD_TYP = 'AD_C'";
					System.out.println("Address already exists so updating");
					PreparedStatement ps1 = Con2.prepareStatement(sql2);
					ps1.setString(1,e.getPRESENT_ADDR());	
					ps1.setString(2,e.getPRESENT_STREET());
					ps1.setString(3,e.getPRESENT_CITY());
					ps1.setString(4,e.getPRESENT_COUNTRY());
					ps1.setString(5,String.valueOf(e.getPRESENT_ZIP()));
					ps1.setString(6, String.valueOf(e.getEMP_ID()));
					rs1 = ps1.executeUpdate();
					return rs1;
					}
				else
					{
					String sql3 = "INSERT INTO address(EMP_ID, ADD_TYP,ADDR,STREET,CITY,COUNTRY,ZIP) VALUES (?, ?, ?, ?, ?, ?, ?) ";
					System.out.println("Address does not exist so inserting");
					PreparedStatement ps1 = Con.prepareStatement(sql3);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					ps1.setString(2,"AD_C");
					System.out.println("Printing from inside the testdao"+elocal.getPERMANENT_ADDR());
					ps1.setString(3,e.getPRESENT_ADDR());
					ps1.setString(4,e.getPRESENT_STREET());
					ps1.setString(5,e.getPRESENT_CITY());
					ps1.setString(6,e.getPRESENT_COUNTRY());
					ps1.setString(7,String.valueOf(e.getPRESENT_ZIP()));
					rs1 = ps1.executeUpdate();
					return rs1;
					}
				//rs.close();
				//Con.close();
				}
			catch(SQLException ex) {
			  	System.out.println(ex); 
			   		}
				return rs;
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
			// function to fetch the leave balance called by leaveinfocontroller
			public Employee fetchLeaveBalance(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside fetchLeaveBalance function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String sql = "SELECT VAC_BAL, SICK_BAL FROM LEAVE_BAL WHERE EMP_ID = ?";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
						elocal.setS_LEAVE(Float.parseFloat(rs.getString("SICK_BAL")));
						System.out.println("Sick Bal is "+elocal.getS_LEAVE());
						elocal.setC_LEAVE(Float.parseFloat(rs.getString("VAC_BAL")));
						System.out.println("Vacation Bal is "+elocal.getC_LEAVE());
						}
					rs.close();
					Con.close();
					}
				catch(SQLException ex) {
					  	System.out.println(ex); 
				   		}
					return elocal;
		}
			// function to fetch the leave balance called by payrollinfocontroller
			public Employee fetchPayRollInfo(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside fetchLeaveBalance function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String sql = "SELECT SALARY, BONUS FROM PAYROLL WHERE EMP_ID = ?";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
						elocal.setC_SALARY(Float.parseFloat(rs.getString("SALARY")));
						System.out.println("SALARY is "+elocal.getC_SALARY());
						elocal.setBONUS(Float.parseFloat(rs.getString("BONUS")));
						System.out.println("Bonus is "+elocal.getBONUS());
						}
					rs.close();
					Con.close();
					}
				catch(SQLException ex) {
					  	System.out.println(ex); 
				   		}
					return elocal;
		}
			// function to fetch the asset details and seat number balance called by AssetInfoController
			public Employee fetchAssetInfo(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside fetchAssetInfo function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String sql = "SELECT SEAT_NO FROM SEAT WHERE EMP_ID = ?";
					String sql2 = "SELECT TYPETABLE.VAL AS 'ASSET TYPE',ASSET.ASSET_ID FROM ASSET LEFT OUTER JOIN TYPETABLE ON ASSET.ASSET_TYP = TYPETABLE.TYPE_ID WHERE EMP_ID = ?";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
						elocal.setSEAT_NUMBER(Integer.parseInt(rs.getString("SEAT_NO")));

						System.out.println("Seatnumber is "+elocal.getSEAT_NUMBER());
								
						}
					rs.close();
					PreparedStatement ps2 = Con.prepareStatement(sql2);
					ps2.setString(1, String.valueOf(e.getEMP_ID()));
					rs= ps2.executeQuery();
					int i=0;
					while(rs.next()){
							asset_name[i]=rs.getString("ASSET TYPE");
							asset_id[i] = Integer.parseInt(rs.getString("ASSET_ID"));
							System.out.println("Asset type is "+rs.getString("ASSET TYPE"));
							System.out.println("Asset type is "+rs.getString("ASSET_ID"));
							i++;
						}
						elocal.setTOTAL_ASSETS(i);
						elocal.setASSET_TYPE(asset_name);
						elocal.setASSET_NUMBER(asset_id);
					
					//rs.close();
					//Con.close();
					}
					catch(SQLException ex) {
					  	System.out.println(ex); 
				   	}
					return elocal;
			}
			// function to fetch the office details and seat number balance called by officeinfocontroller
			public Employee fetchOfficeInfo(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside fetchOfficeInfo function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					String sql = "Select EMPL.C_LEVEL, BRANCHES.VAL AS 'BRANCH', TYPETABLE.VAL AS 'STATUS',  concat( (SELECT FNAME FROM EMPLOYEE WHERE EMP_ID = EMPL.C_MAN), (SELECT MNAME FROM EMPLOYEE WHERE EMP_ID = EMPL.C_MAN), (SELECT LNAME FROM EMPLOYEE WHERE EMP_ID = EMPL.C_MAN) ) as 'MANAGER', ( SELECT PROJ_DES FROM PROJECT WHERE PROJ_ID = EMPL.C_PROJ) AS 'PROJECT' from EMPLOYEE EMPL LEFT OUTER JOIN BRANCHES ON EMPL.C_BRANCH = BRANCHES.TYPE_ID LEFT OUTER JOIN TYPETABLE ON EMPL.C_STATUS = TYPETABLE.TYPE_ID WHERE EMP_ID = ?";
					PreparedStatement ps = Con.prepareStatement(sql);
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					ps.setString(1, String.valueOf(e.getEMP_ID()));
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
						elocal.setC_LEVEL(Integer.parseInt(rs.getString("C_LEVEL")));				
						elocal.setC_Branch(rs.getString("BRANCH"));						
						elocal.setC_STATUS(rs.getString("STATUS"));		
						elocal.setMANAGER(rs.getString("MANAGER"));
						elocal.setPROJECT_NAME(rs.getString("PROJECT"));
						}
					rs.close();
					}
					catch(SQLException ex) {
					  	System.out.println(ex); 
				   		}
					return elocal;
			}
			
//			//testing list functionality to display as table
//			public ObservableList<Employee> getContactsForName(String name) {
//			      String sql = "Select * from Employee where name like '%" +
//			         name + "%'";
//			      ObservableList<Employee> list = new ObservableList<>();
//			      try {
//			    	  Connection Con = MySQLConnUtils.getMySQLConnection();
//			    	  Statement stmt = Con.createStatement();
//			    	  ResultSet rs = stmt.executeQuery(sql);
//			    	  while (rs.next()) {
//			            ObservableList<Employee> emplist = createEmployee(rs);
//			            return emplist;
//			    	  }
//			         rs.close();
//			         Con.close();
//			      } catch (ClassNotFoundException | SQLException ex) {
//			      }
//			      //return list;
//			   }
//			
//			//testing list functionality
//			public ObservableList<Employee> createEmployee(ResultSet rs) {
//				ObservableList<Employee> emplist = FXCollections.observableArrayList();
//		      
//		      try {
//		    	   
//		    	  while(rs.next()) {
//		    		  Employee e = new Employee();
//			    	  e.setEMP_ID(rs.getInt("EMP_ID"));
//			    	  e.setFNAME(rs.getString("FNAME"));
//			    	  e.setMNAME(rs.getString("MNAME"));
//			    	  e.setLNAME(rs.getString("LNAME"));
//			    	  e.setC_Branch(rs.getString("C_BRANCH"));
//			    	  e.setC_STATUS(rs.getString("C_STATUS"));
//			    	  e.setC_PROJ(Integer.parseInt(rs.getString("C_PROJ")));
//			    	  emplist.add(e);
//		    	  
//		    	 
//		    	  }
//		       
//		      	} catch (SQLException ex) {
//		      }
//		      return emplist;
//		      
//		   }
//			public ObservableList<Employee> getAllEmployees() {
//			      String sql = "Select * from Employee";
//			      ObservableList<Employee> emplist = new ObservableList<>();
//			      try {
//			    	  Connection Con = MySQLConnUtils.getMySQLConnection();
//			    	  Statement stmt = Con.createStatement();
//			    	  ResultSet rs = stmt.executeQuery(sql);
//			    	  while (rs.next()) {
//			        	 Employee e = createEmployee(rs);
//			        	 emplist.add(e);
//			         }
//			         rs.close();
//			      //   con.close();
//			      } catch (ClassNotFoundException | SQLException ex) {
//			      }
//			      return list;
//			   }
			
			//Testing new function to view the list of employees
			public ObservableList<Employee> getEmpList() throws ClassNotFoundException, SQLException{
				String sql = "Select * from Employee";
				ObservableList<Employee> emplist = FXCollections.observableArrayList();
				Connection Con = MySQLConnUtils.getMySQLConnection();
		    	Statement stmt = Con.createStatement();
		    	ResultSet rs = stmt.executeQuery(sql);
		    	while(rs.next()) {
		    		Employee e = new Employee();
			    	e.setEMP_ID(rs.getInt("EMP_ID"));
			    	e.setFNAME(rs.getString("FNAME"));
			    	e.setMNAME(rs.getString("MNAME"));
			    	e.setLNAME(rs.getString("LNAME"));
			    	e.setC_Branch(rs.getString("C_BRANCH"));
			    	e.setC_STATUS(rs.getString("C_STATUS"));
			    	e.setC_PROJ(Integer.parseInt(rs.getString("C_PROJ")));
			    	emplist.add(e);
		    		
		    	}
		    	return emplist;
				
			}
			public ObservableList<Employee> getEmpListSearchFname(String name) throws ClassNotFoundException, SQLException{
				String sql ="Select * from Employee where FNAME like '%" + name + "%'";
				ObservableList<Employee> emplist = FXCollections.observableArrayList();
				Connection Con = MySQLConnUtils.getMySQLConnection();
		    	Statement stmt = Con.createStatement();
		    	ResultSet rs = stmt.executeQuery(sql);
		    	while(rs.next()) {
		    		Employee e = new Employee();
			    	e.setEMP_ID(rs.getInt("EMP_ID"));
			    	e.setFNAME(rs.getString("FNAME"));
			    	e.setMNAME(rs.getString("MNAME"));
			    	e.setLNAME(rs.getString("LNAME"));
			    	e.setC_Branch(rs.getString("C_BRANCH"));
			    	e.setC_STATUS(rs.getString("C_STATUS"));
			    	e.setC_PROJ(Integer.parseInt(rs.getString("C_PROJ")));
			    	emplist.add(e);
		    		
		    	}
		    	return emplist;
				
			}
			
			//insert employee function number 1
			public Employee insertEmployee(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
					try {
						System.out.println("Inside insert employee function");
						Connection Con = MySQLConnUtils.getMySQLConnection();
						String sql = "INSERT INTO EMPLOYEE (Fname, Mname, Lname, DOB, GENDER, SSN, MAR, C_SALARY) VALUE (?,?,?,?, ?,?,?,?)";
						PreparedStatement ps = Con.prepareStatement(sql);
						System.out.println("Passed login NAME is "+e.getEMP_ID());
						ps.setString(1, e.getFNAME());
						ps.setString(2, e.getMNAME());
						ps.setString(3, e.getLNAME());
						ps.setString(4, String.valueOf(e.getDOB()));
						ps.setString(5, e.getGENDER());
						ps.setString(6, String.valueOf(e.get_sno()));
						ps.setString(7, e.getMAR());
						ps.setString(8, String.valueOf(e.getC_SALARY()));
						int sno = e.get_sno();
						System.out.println("Printing from testdao"+sno);
						elocal.setPass_ssn(sno);
						rs= ps.executeUpdate();
						elocal.setRs(rs);
						Con.close();
						}
						catch(SQLException ex) {
						  	System.out.println(ex); 
						  		}
						return elocal;
				}
			//insert employee function number 1
			public int insertEmployee2(Employee e)throws SQLException, ClassNotFoundException{
					try {
						System.out.println("Inside insert employee 2 function");
						Connection Con = MySQLConnUtils.getMySQLConnection();
						String sql = "INSERT INTO EMPLOYEE (Fname, Mname, Lname, DOB, GENDER, SSN, MAR, C_SALARY) VALUE (?,?,?,?, ?,?,?,?)";
						PreparedStatement ps = Con.prepareStatement(sql);
						System.out.println("Passed login NAME is "+e.getEMP_ID());
						ps.setString(1, e.getFNAME());
						ps.setString(2, e.getMNAME());
						ps.setString(3, e.getLNAME());
						ps.setString(4, String.valueOf(e.getDOB()));
						ps.setString(5, e.getGENDER());
						ps.setString(6, String.valueOf(e.get_sno()));
						ps.setString(7, e.getMAR());
						ps.setString(8, String.valueOf(e.getC_SALARY()));
						rs= ps.executeUpdate();
						Con.close();
						}
						catch(SQLException ex) {
						  	System.out.println(ex); 
						  		}
						return rs;
				}
			
			//insert employee function number 1
			public int fetchempid(int sno)throws SQLException, ClassNotFoundException{
					try {
						System.out.println("Inside fetchempid function");
						Connection Con = MySQLConnUtils.getMySQLConnection();
						String sql = "select * from employee where ssn =?";
						PreparedStatement ps = Con.prepareStatement(sql);
						System.out.println("Passed ssn is"+sno);
						ps.setInt(1, sno);
						//ps.setString(1, String.valueOf(sno));
						ResultSet rset = ps.executeQuery();
						while(rset.next()) {
							rs=Integer.parseInt(rset.getString("EMP_ID"));
							System.out.println("Retrieved empid is "+rs);
						}
						Con.close();
						}
						catch(SQLException ex) {
						  	System.out.println(ex); 
						  		}
						return rs;
				}
			//function for editing office address info
			public int editofficeaddressinfo(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE address info function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "INSERT INTO address(EMP_ID, ADD_TYP,ADDR,STREET,CITY,COUNTRY,ZIP) VALUES (?,?,?,?,?,?,?)";
					System.out.println("Inserting office address");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					ps1.setString(2,"AD_O");
					ps1.setString(3,e.getOFFICIAL_ADDR());
					//System.out.println("Printing from inside the testdao"+elocal.getOFFICIAL_ADDR());
					ps1.setString(4,e.getOFFICIAL_STREET());
					ps1.setString(5,e.getOFFICIAL_CITY());
					ps1.setString(6,e.getOFFICIAL_COUNTRY());
					ps1.setString(7,String.valueOf(e.getOFFICIAL_ZIP()));
					rs1 = ps1.executeUpdate();
					return rs1;
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
			//function for editing office contact address info
			public int editofficecontact(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE contact edit function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "INSERT INTO CONTACT(CONTACT,EMP_ID,CON_TYP) VALUE ( ?,?,?)";
					System.out.println("Inserting office contact");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setInt(1,e.getOCONTACT());
					ps1.setString(2, String.valueOf(e.getEMP_ID()));
					ps1.setString(3,"C_O");
					rs1 = ps1.executeUpdate();
					return rs1;
					
					//rs.close();
					//Con.close();
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
			//function for editing office email address info
			public int editofficeemail(Employee e)throws SQLException, ClassNotFoundException{
				//Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE email edit function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "Insert  into email (EMAIL,EMP_ID,EMAIL_TYP) VALUE (?,?,?) ";
					System.out.println("Inserting office contact");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setString(1,e.getOFFICIAL_EMAIL());
					ps1.setString(2, String.valueOf(e.getEMP_ID()));
					ps1.setString(3,"C_O");
					rs1 = ps1.executeUpdate();
					return rs1;
					
					//rs.close();
					//Con.close();
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
			//function for editing hr log level address info
			public int hrlog(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE hr log edit function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "insert into HR_LOG (EMP_ID , LEV, BRANCH, STAT,SALARY, CHANGE_TS, CHANGED_BY) VALUES (?,?,?,?,?,current_timestamp,?)";
					System.out.println("Inserting HRLOG level");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					ps1.setInt(2,e.getC_LEVEL());
					ps1.setString(3,e.getC_Branch());
					ps1.setString(4, e.getC_STATUS());
					ps1.setString(5,String.valueOf(0));
					//ps1.setString(6, "");
					ps1.setInt(6,e.getPass_ssn());//here alone hr id is passed
					rs1 = ps1.executeUpdate();
					return rs1;
					
					//rs.close();
					//Con.close();
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
			//function for editing office level address info
			public int levelupdate(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE level edit function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "INSERT INTO LEVELS (EMP_ID, LEVEL_ID, S_DATE) VALUES (?, ?, ?)";
					System.out.println("Inserting office level");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					ps1.setInt(2,e.getC_LEVEL());
					java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					ps1.setString(3,String.valueOf(date));
					rs1 = ps1.executeUpdate();
					return rs1;
					
					//rs.close();
					//Con.close();
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
			//function for setting employee access type into logon table
			//4 parameters are there in logon table
			public int setlogon(Employee e)throws SQLException, ClassNotFoundException{
				Employee elocal = new Employee();
				try {
					System.out.println("Inside edit OFFICE contact edit function");
					Connection Con = MySQLConnUtils.getMySQLConnection();
					System.out.println("Passed login NAME is "+e.getEMP_ID());
					String sql = "INSERT INTO LOGON (EMP_ID,ACC_ID,PSW) VALUE (?,?,?)";
					System.out.println("Inserting office contact");
					PreparedStatement ps1 = Con.prepareStatement(sql);
					ps1.setString(1, String.valueOf(e.getEMP_ID()));
					System.out.println("printing from testdao"+e.getACC_type());
					ps1.setString(2,e.getACC_type());
					ps1.setString(3,"123456");
					rs1 = ps1.executeUpdate();
					return rs1;
					//
					//rs.close();
					//Con.close();
					}
				catch(SQLException ex) {
				  	System.out.println(ex); 
				   		}
					return rs;
			}
}

