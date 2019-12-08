package verticalMenuPersonalInfo;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import javafx.fxml.FXML;
import loginController.LoginController;
import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

public class ContactInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();

    @FXML
    private JFXTextField PersonalNo_Display;

    @FXML
    private JFXTextField OfficeNo_Display;

    @FXML
    private JFXTextField EmergencyNo_field;

    @FXML
    private JFXButton Cancel_Contact_btn;

    @FXML
    private JFXButton Edit_Contact_btn;
    @FXML
    public void initialize() throws SQLException {
    	Employee e = new Employee();
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.contactinfo(e);
  	    System.out.println(enew.getCONTACT());
  	    PersonalNo_Display.setText(String.valueOf(enew.getCONTACT()));
  	    OfficeNo_Display.setText(String.valueOf(enew.getOCONTACT()));
  	    EmergencyNo_field.setText(String.valueOf(enew.getECONTACT()));
//  	    PersonalNo_Display.setText(enew.getFNAME());
//  	    System.out.println(enew.getFNAME());
//  	    MNAME.setText(enew.getMNAME());
//  	    LNAME.setText(enew.getLNAME());
//  	    DOB.setText(String.valueOf(enew.getDOB()));
//  	    SSN.setText(String.valueOf(enew.get_sno()));
//  	    MaritalStatus.setText(enew.getMAR());
    	
    }
    	
}
