package verticalMenuPersonalInfo;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.*;
import loginController.LoginController;


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
    private JFXButton Edit_Contact_btn;

    @FXML
    private JFXTextField PersonalEmail;

    @FXML
    private JFXTextField OfficialEmail;

    @FXML
    private JFXButton Edit_Email_btn;

    @FXML
    void EditContactDetails(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/ContactEdit.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }

    @FXML
    void EditEmailId(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/EmailEdit.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();

    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
    	Employee e = new Employee();
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.contactinfo(e);
  	    System.out.println(enew.getCONTACT());
  	    PersonalNo_Display.setText(String.valueOf(enew.getCONTACT()));
  	    OfficeNo_Display.setText(String.valueOf(enew.getOCONTACT()));
  	    EmergencyNo_field.setText(String.valueOf(enew.getECONTACT()));
  	    OfficialEmail.setText(enew.getOFFICIAL_EMAIL());
  	    PersonalEmail.setText(enew.getPERSONAL_EMAIL());
//  	    PersonalNo_Display.setText(enew.getFNAME());
//  	    System.out.println(enew.getFNAME());
//  	    MNAME.setText(enew.getMNAME());
//  	    LNAME.setText(enew.getLNAME());
//  	    DOB.setText(String.valueOf(enew.getDOB()));
//  	    SSN.setText(String.valueOf(enew.get_sno()));
//  	    MaritalStatus.setText(enew.getMAR());
    	
    }
    	
}
