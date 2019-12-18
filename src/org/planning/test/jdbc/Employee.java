package org.planning.test.jdbc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	private int EMP_ID;
	private String FNAME;
	private String MNAME;
	private String LNAME;
	private String MAR;
	private String GENDER;
	

	//for login
	private String LOGIN_ID;
	private String PWD;
	private String ACC_type;
	//for login boolean variable is used only in java to check if login is successful or not
	private Boolean login;
	
	private java.sql.Date DOB;
	private int _sno;
	private int C_LEVEL;
	private String C_Branch;
	private String C_STATUS;
	private float C_SALARY;
	private int RATING;
	private int C_MAN;
	private int C_PROJ;
	private String MANAGER;
	private String PROJECT_NAME;
	
	//parameters for payroll
	private float BONUS;
	//message for passing search parameters
	private String SearchParam;
	//passing ssn param
	private int pass_ssn;
	//storing result set
	private int rs;
	
	 // .matches('.{10}')
	public Employee(int EMP_ID, String FNAME, String LNAME, String C_Branch, String C_STATUS, int C_PROJ) {
		this.EMP_ID=EMP_ID;
		this.FNAME = FNAME;
		this.LNAME = LNAME;
		this.C_Branch = C_Branch;
		this.C_STATUS = C_STATUS;
		this.C_PROJ = C_PROJ;
		
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}

	public String getMANAGER() {
		return MANAGER;
	}

	public void setMANAGER(String mANAGER) {
		MANAGER = mANAGER;
	}

	private String PERSONAL_EMAIL;
	private String OFFICIAL_EMAIL;
	
	//Present Addressinfo
	private String PRESENT_ADDR;
	private String PRESENT_STREET;
	private String PRESENT_CITY;
	private String PRESENT_COUNTRY;
	private int PRESENT_ZIP;// .matches('\d{6}')
	
	//Permanent Addressinfo
	private String PERMANENT_ADDR;
	private String PERMANENT_STREET;
	private String PERMANENT_CITY;
	private String PERMANENT_COUNTRY;
	private int PERMANENT_ZIP;// .matches('\d{6}')
	//Office Addressinfo
	private String OFFICIAL_ADDR;
	private String OFFICIAL_STREET;
	private String OFFICIAL_CITY;
	private String OFFICIAL_COUNTRY;
	private int OFFICIAL_ZIP;// .matches('\d{6}')
	
	//for leave
	private float S_LEAVE;
	private float C_LEAVE;
	private java.sql.Date START_DATE;
	private java.sql.Date END_DATE;
	private String LEAVE_TYPE;
	private String LEAVES_APPROVAL;
	//assets
	private int SEAT_NUMBER;
	private int[] ASSET_NUMBER;
	private String[] ASSET_TYPE;
	private int TOTAL_ASSETS;
	
	//for list
	private IntegerProperty idProperty;
	private StringProperty fnameProperty;
	private StringProperty lnameProperty;
	private StringProperty branchProperty;
	private StringProperty statusProperty;
	private StringProperty projectProperty;
	
	public void EmployeeTest() {
		this.idProperty = new SimpleIntegerProperty();
		this.fnameProperty = new SimpleStringProperty();
		this.lnameProperty = new SimpleStringProperty();
		this.branchProperty= new SimpleStringProperty();
		this.statusProperty = new SimpleStringProperty();
		this.projectProperty = new SimpleStringProperty();
				
	}
	
	//Address Mapping Table Content Datatypes
	//private String ADD_ID;
	//private java.sql.Date S_DATE;
	//private java.sql.Date E_DATE;
	
	
//	private String CITY;
//	private String COUNTRY;
//	private int ZIP;
	
	public int getTOTAL_ASSETS() {
		return TOTAL_ASSETS;
	}

	public void setTOTAL_ASSETS(int tOTAL_ASSETS) {
		TOTAL_ASSETS = tOTAL_ASSETS;
	}

	public int getSEAT_NUMBER() {
		return SEAT_NUMBER;
	}

	public void setSEAT_NUMBER(int sEAT_NUMBER) {
		SEAT_NUMBER = sEAT_NUMBER;
	}

	public int[] getASSET_NUMBER() {
		return ASSET_NUMBER;
	}

	public void setASSET_NUMBER(int[] aSSET_NUMBER) {
		ASSET_NUMBER = aSSET_NUMBER;
	}

	public String[] getASSET_TYPE() {
		return ASSET_TYPE;
	}

	public void setASSET_TYPE(String[] aSSET_TYPE) {
		ASSET_TYPE = aSSET_TYPE;
	}

	public float getS_LEAVE() {
		return S_LEAVE;
	}

	public void setS_LEAVE(float s_LEAVE) {
		S_LEAVE = s_LEAVE;
	}

	public float getC_LEAVE() {
		return C_LEAVE;
	}

	public void setC_LEAVE(float c_LEAVE) {
		C_LEAVE = c_LEAVE;
	}

	public java.sql.Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(java.sql.Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public java.sql.Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(java.sql.Date eND_DATE) {
		END_DATE = eND_DATE;
	}

	//phone contact info
	private int CONTACT;//Personal number
	private int ECONTACT;//Emergency Contact number
	private int OCONTACT;//Official Contact number
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getFNAME() {
		return FNAME;
	}

	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}

	public String getMNAME() {
		return MNAME;
	}

	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}

	public String getLNAME() {
		return LNAME;
	}

	public void setLNAME(String lNAME) {
		LNAME = lNAME;
	}

	public java.sql.Date getDOB() {
		return DOB;
	}

	public void setDOB(java.sql.Date dOB) {
		DOB = dOB;
	}

	public int get_sno() {
		return _sno;
	}

	public void set_sno(int _sno) {
		this._sno = _sno;
	}

	public int getC_LEVEL() {
		return C_LEVEL;
	}

	public void setC_LEVEL(int c_LEVEL) {
		C_LEVEL = c_LEVEL;
	}

	public String getC_Branch() {
		return C_Branch;
	}

	public void setC_Branch(String c_Branch) {
		C_Branch = c_Branch;
	}

	public String getC_STATUS() {
		return C_STATUS;
	}

	public void setC_STATUS(String c_STATUS) {
		C_STATUS = c_STATUS;
	}

	public float getC_SALARY() {
		return C_SALARY;
	}

	public void setC_SALARY(float c_SALARY) {
		C_SALARY = c_SALARY;
	}

	public int getRATING() {
		return RATING;
	}

	public void setRATING(int rATING) {
		RATING = rATING;
	}

	public int getC_MAN() {
		return C_MAN;
	}

	public void setC_MAN(int c_MAN) {
		C_MAN = c_MAN;
	}

	public int getC_PROJ() {
		return C_PROJ;
	}

	public void setC_PROJ(int c_PROJ) {
		C_PROJ = c_PROJ;
	}

	public int getCONTACT() {
		return CONTACT;
	}

	public String getPRESENT_ADDR() {
		return PRESENT_ADDR;
	}

	public void setPRESENT_ADDR(String pRESENT_ADDR) {
		PRESENT_ADDR = pRESENT_ADDR;
	}

	public String getPRESENT_STREET() {
		return PRESENT_STREET;
	}

	public void setPRESENT_STREET(String pRESENT_STREET) {
		PRESENT_STREET = pRESENT_STREET;
	}

	public String getPRESENT_CITY() {
		return PRESENT_CITY;
	}

	public void setPRESENT_CITY(String pRESENT_CITY) {
		PRESENT_CITY = pRESENT_CITY;
	}

	public String getPRESENT_COUNTRY() {
		return PRESENT_COUNTRY;
	}

	public void setPRESENT_COUNTRY(String pRESENT_COUNTRY) {
		PRESENT_COUNTRY = pRESENT_COUNTRY;
	}

	public int getPRESENT_ZIP() {
		return PRESENT_ZIP;
	}

	public void setPRESENT_ZIP(int pRESENT_ZIP) {
		PRESENT_ZIP = pRESENT_ZIP;
	}

	public String getPERMANENT_ADDR() {
		return PERMANENT_ADDR;
	}

	public void setPERMANENT_ADDR(String pERMANENT_ADDR) {
		PERMANENT_ADDR = pERMANENT_ADDR;
	}

	public String getPERMANENT_STREET() {
		return PERMANENT_STREET;
	}

	public void setPERMANENT_STREET(String pERMANENT_STREET) {
		PERMANENT_STREET = pERMANENT_STREET;
	}

	public String getPERMANENT_CITY() {
		return PERMANENT_CITY;
	}

	public void setPERMANENT_CITY(String pERMANENT_CITY) {
		PERMANENT_CITY = pERMANENT_CITY;
	}

	public String getPERMANENT_COUNTRY() {
		return PERMANENT_COUNTRY;
	}

	public void setPERMANENT_COUNTRY(String pERMANENT_COUNTRY) {
		PERMANENT_COUNTRY = pERMANENT_COUNTRY;
	}

	public int getPERMANENT_ZIP() {
		return PERMANENT_ZIP;
	}

	public void setPERMANENT_ZIP(int pERMANENT_ZIP) {
		PERMANENT_ZIP = pERMANENT_ZIP;
	}

	public String getOFFICIAL_ADDR() {
		return OFFICIAL_ADDR;
	}

	public void setOFFICIAL_ADDR(String oFFICIAL_ADDR) {
		OFFICIAL_ADDR = oFFICIAL_ADDR;
	}

	public String getOFFICIAL_STREET() {
		return OFFICIAL_STREET;
	}

	public void setOFFICIAL_STREET(String oFFICIAL_STREET) {
		OFFICIAL_STREET = oFFICIAL_STREET;
	}

	public String getOFFICIAL_CITY() {
		return OFFICIAL_CITY;
	}

	public void setOFFICIAL_CITY(String oFFICIAL_CITY) {
		OFFICIAL_CITY = oFFICIAL_CITY;
	}

	public String getOFFICIAL_COUNTRY() {
		return OFFICIAL_COUNTRY;
	}

	public void setOFFICIAL_COUNTRY(String oFFICIAL_COUNTRY) {
		OFFICIAL_COUNTRY = oFFICIAL_COUNTRY;
	}

	public int getOFFICIAL_ZIP() {
		return OFFICIAL_ZIP;
	}

	public void setOFFICIAL_ZIP(int oFFICIAL_ZIP) {
		OFFICIAL_ZIP = oFFICIAL_ZIP;
	}

	public void setCONTACT(int cONTACT) {
		CONTACT = cONTACT;
	}

	public String getPERSONAL_EMAIL() {
		return PERSONAL_EMAIL;
	}

	public void setPERSONAL_EMAIL(String eMAIL) {
		PERSONAL_EMAIL = eMAIL;
	}

	public String getOFFICIAL_EMAIL() {
		return OFFICIAL_EMAIL;
	}

	public void setOFFICIAL_EMAIL(String oFFICIAL_EMAIL) {
		OFFICIAL_EMAIL = oFFICIAL_EMAIL;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//Testing login Screen
	public String getLOGIN_ID() {
		return LOGIN_ID;
	}

	public void setLOGIN_ID(String lOGIN_ID) {
		LOGIN_ID = lOGIN_ID;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getACC_type() {
		return ACC_type;
	}

	public void setACC_type(String aCC_type) {
		ACC_type = aCC_type;
	}
	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}
	public String getMAR() {
		return MAR;
	}

	public void setMAR(String mAR) {
		MAR = mAR;
	}

	public int getECONTACT() {
		return ECONTACT;
	}

	public void setECONTACT(int eCONTACT) {
		ECONTACT = eCONTACT;
	}

	public int getOCONTACT() {
		return OCONTACT;
	}

	public void setOCONTACT(int oCONTACT) {
		OCONTACT = oCONTACT;
	}
public String getSearchParam() {
		return SearchParam;
	}
	public void setSearchParam(String searchParam) {
		SearchParam = searchParam;
	}
	public float getBONUS() {
		return BONUS;
	}
	public void setBONUS(float bONUS) {
		BONUS = bONUS;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public int getPass_ssn() {
		return pass_ssn;
	}
	public void setPass_ssn(int pass_ssn) {
		this.pass_ssn = pass_ssn;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public String getLEAVE_TYPE() {
		return LEAVE_TYPE;
	}
	public void setLEAVE_TYPE(String lEAVE_TYPE) {
		LEAVE_TYPE = lEAVE_TYPE;
	}
	public String getLEAVES_APPROVAL() {
		return LEAVES_APPROVAL;
	}
	public void setLEAVES_APPROVAL(String lEAVES_APPROVAL) {
		LEAVES_APPROVAL = lEAVES_APPROVAL;
	}
	//////////////////////////////////////////////////////////////
	public int getIdProperty() {
		return idProperty.get();
	}

	public void setIdProperty(int id) {
		this.idProperty.set(id);
	}
	
	public IntegerProperty getEMPIdProperty() {
		return idProperty;
	}
/////////////////////////////////////
	public StringProperty getFnameProperty() {
		return fnameProperty;
	}

	public void setFnameProperty(String fname) {
		this.fnameProperty.set(fname);
	}
	public StringProperty getfnameEmpProperty() {
		return fnameProperty;
	}
///////////////////////////////////////
	public StringProperty getLnameProperty() {
		return lnameProperty;
	}

	public void setLnameProperty(String lname) {
		this.lnameProperty.set(lname);
	}
	public StringProperty getfnameProperty() {
		return lnameProperty;
	}
/////////////////////////////////////////////	
	public StringProperty getBranchProperty() {
		return branchProperty;
	}

	public void setBranchProperty(String branch) {
		this.branchProperty.set(branch);
	}
	public StringProperty getbranchEmpProperty() {
		return branchProperty;
	}
////////////////////////////////////////////////
	public StringProperty getStatusProperty() {
		return statusProperty;
	}

	public void setStatusProperty(String status) {
		this.statusProperty.set(status);
	}
	public StringProperty getstatusEmpProperty() {
		return statusProperty;
	}
////////////////////////////////////////////////////
	public StringProperty getProjectProperty() {
		return projectProperty;
	}

	public void setProjectProperty(String project) {
		this.projectProperty.set(project);
	}
	public StringProperty getprojectEmpProperty() {
		return projectProperty;
	}
}
