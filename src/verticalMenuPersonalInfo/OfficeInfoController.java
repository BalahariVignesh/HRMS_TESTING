package verticalMenuPersonalInfo;


import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import loginController.LoginController;

public class OfficeInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	
	 @FXML
	    private JFXTextField PersonalNo_Display;

	    @FXML
	    private JFXTextField OfficeNo_Display;

	    @FXML
	    private JFXTextField EmergencyNo_field;

	    @FXML
	    private JFXButton Edit_Contact_btn;

	    @FXML
	    private JFXTextField PersonalEmail;

	    @FXML
	    private JFXTextField OfficialEmail;

	    @FXML
	    private JFXButton Edit_Email_btn;
	    
	    @FXML
	    public void initialize() {
	    	Employee e = new Employee();
	    	System.out.println("Inside Personal Info Controller"+epass.getEMP_ID());
      	    e.setEMP_ID(epass.getEMP_ID());
      	    TestDao t = new TestDao();
      	    Employee enew = t.fetchEmployeePersonalDetails(e);
      	    System.out.println(e.getFNAME());
//      	    FNAME.setText(enew.getFNAME());
//      	    System.out.println(enew.getFNAME());
//      	    MNAME.setText(enew.getMNAME());
//      	    LNAME.setText(enew.getLNAME());
//      	    DOB.setText(String.valueOf(enew.getDOB()));
//      	    SSN.setText(String.valueOf(enew.get_sno()));
//      	    MaritalStatus.setText(enew.getMAR());
	    }

}
