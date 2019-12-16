package org.planning.test.jdbc;



public class Employee {
	private int EMP_ID;
	private String FNAME;
	private String MNAME;
	private String LNAME;
	private String MAR;
	

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
	
	
	 // .matches('.{10}')
	
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
	
	
	//Address Mapping Table Content Datatypes
	//private String ADD_ID;
	//private java.sql.Date S_DATE;
	//private java.sql.Date E_DATE;
	
	
//	private String CITY;
//	private String COUNTRY;
//	private int ZIP;
	
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
}
