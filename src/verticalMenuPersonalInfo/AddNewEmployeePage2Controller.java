package verticalMenuPersonalInfo;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import loginController.LoginController;

public class AddNewEmployeePage2Controller {
		private final LoginController contrl = new LoginController();
		Employee epass = contrl.getEmployee();
		
		@FXML
	    private JFXButton CLOSE;

	    @FXML
	    private JFXTextField NewAddressLine;

	    @FXML
	    private JFXTextField NewStreet;

	    @FXML
	    private JFXTextField NewCity;
	    
	    @FXML
	    private JFXTextField NewCountry;
	    
	    @FXML
	    private JFXTextField NewZip;

	    @FXML
	    private JFXTextField NewOfficeContact;

	    @FXML
	    private JFXTextField NewOfficeEmail;

	    @FXML
	    private JFXTextField NewLevel;

	    @FXML
	    private JFXTextField NewBranch;

	    @FXML
	    private JFXTextField NewStatus;

	    @FXML
	    private JFXRadioButton HR;

	    @FXML
	    private JFXRadioButton EMPLOYEE;

	    @FXML
	    private JFXRadioButton PMO;
	    
	    @FXML
	    final ToggleGroup emp_type = new ToggleGroup();
	    
	    @FXML
	    private JFXButton NewEmployeeData;

	    @FXML
	    void AddNewEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	Employee e = new Employee();
	    	System.out.println("Inside 2nd insert Controller"+epass.getEMP_ID());
	  	    e.setEMP_ID(epass.getEMP_ID());
	  	    int hr_id = epass.getEMP_ID();
	  	    e.setPass_ssn(hr_id);//pass hr id for updated by log as pass_ssn
	  	    TestDao t = new TestDao();
	  	    int sno= epass.getPass_ssn();
	  	    		//contrl.getPass_ssn_param();
	  	    System.out.println("passedint val as ssn is"+ sno);
	  	    int empid = t.fetchempid(sno);
	  	    e.setEMP_ID(empid);
	  	    System.out.println (empid);
	  	    e.setOFFICIAL_ADDR(NewAddressLine.getText());
	  	    e.setOFFICIAL_STREET(NewStreet.getText());
	  	    e.setOFFICIAL_CITY(NewCity.getText());
	  	    e.setOFFICIAL_COUNTRY(NewCountry.getText());
	  	    e.setOFFICIAL_ZIP(Integer.parseInt(NewZip.getText()));
	  	    int add_update = t.editofficeaddressinfo(e);
	  	    if(add_update==1) {
	  	    	System.out.println("official address succcess");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("officialaddress not succcess");
	  	    }
	  	    e.setOCONTACT(Integer.parseInt(NewOfficeContact.getText()));
	  	    int contact_update = t.editofficecontact(e);
	  	    if(contact_update==1) {
	  	    	System.out.println("official contact succcess");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("official contact not succcess");
	  	    }
	  	    e.setOFFICIAL_EMAIL(NewOfficeEmail.getText());
	  	    int contact_email_update = t.editofficeemail(e);
	  	    if(contact_email_update==1) {
	  	    	System.out.println("official email succcess");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("official email not succcess");
	  	    }
	  	  	e.setC_LEVEL(Integer.parseInt(NewLevel.getText()));
	  	  	e.setC_Branch(NewBranch.getText());
	  	  	e.setC_STATUS(NewStatus.getText());
	  	    int hr_update = t.hrlog(e);
	  	    if(hr_update==1) {
	  	    	System.out.println("hrlog succcess");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("hrlog not succcess");
	  	    }
	  	    
	  	    int levelupdate = t.levelupdate(e);
	  	    if(levelupdate==1) {
	  	    	System.out.println("level succcess");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("level not succcess");
	  	    }
	  	    
	  	  RadioButton access_type = (RadioButton) emp_type.getSelectedToggle();
	  	  String access_type_value = access_type.getText();
	  	  
	  	  if(access_type_value.matches("HR")) {
	  		 access_type_value="AC_HR";
	  	  }
	  	  	else if(access_type_value.matches("EMPLOYEE")){
	  	  	access_type_value="AC_EMP";
	  	  }
	  	  	else if(access_type_value.matches("PMO")){
	  		access_type_value="AC_PMO";
	  	  }
	  	  System.out.println("Printing from controller 2, access type is"+access_type_value);
	  	  e.setACC_type(access_type_value);
	  	  int logon_update = t.setlogon(e);
	  	  if(logon_update==1) {
	  		  System.out.println("login succcess");
	  	  }
	  	  else
	  	  {
	  		  System.out.println("login not succcess");
	  	  }
	  	    //INSERT CODE HERE FOR CLOSING THE WINDOW AFTER ALL UPDATE
	  	    /////////////////////////////
	  	    // get a handle to the stage
	  	    Stage stage1 = (Stage) NewEmployeeData.getScene().getWindow();
	  	    // do what you have to do
	  	    stage1.close();
	  	    /////////////////////////////
	  	    
	    }
	    
	    @FXML
	    public void initialize() {
	    	HR.setToggleGroup(emp_type);
	    	EMPLOYEE.setToggleGroup(emp_type);
	    	
	    	PMO.setToggleGroup(emp_type);
	    	
	    }
	    
	    @FXML
	    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
	    }

}
