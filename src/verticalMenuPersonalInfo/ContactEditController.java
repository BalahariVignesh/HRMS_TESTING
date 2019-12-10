package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
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


public class ContactEditController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private Label Mobile;

    @FXML
    private Label Landline;

    @FXML
    private Label Email;

    @FXML
    private JFXTextField PersonalNoEdit;

    @FXML
    private JFXTextField OfficeNoEdit;//change tag to emergency contact as office number cant be edited

    @FXML
    private JFXButton Cancel_Cancel_btn;

    @FXML
    private JFXButton SAVE_Contact;

    @FXML
    private JFXButton CLOSE;

    @FXML
    void CancelCinfo(ActionEvent event) {

    }

    @FXML
    void CloseWindow(ActionEvent event) {

    }

    @FXML
    void DisplayCEdit(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	TestDao t = new TestDao();
    	e.setEMP_ID(epass.getEMP_ID());
    	if(!PersonalNoEdit.getText().isEmpty() && OfficeNoEdit.getText().isEmpty()) {
    		System.out.println("Personal number field is not empty and hence personal number is set as"+PersonalNoEdit.getText());
    		e.setCONTACT(Integer.parseInt(PersonalNoEdit.getText()));    		
    	}
    	if(!OfficeNoEdit.getText().isEmpty()&& PersonalNoEdit.getText().isEmpty()) {
    		System.out.println("Emergency number field is not empty and hence personal number is set as"+OfficeNoEdit.getText());
    		e.setECONTACT(Integer.parseInt(OfficeNoEdit.getText()));//change tag to emergency contact as office number cant be edited
    	}
    	if(PersonalNoEdit.getText().isEmpty()&& OfficeNoEdit.getText().isEmpty()) {
    		//add code to show alert that both fields cant be empty
    		System.out.println("Both the fields are empty");
    		
    	}
    	int result = t.editcontactnumber(e);
    	if(result == 1) {
    		System.out.println("Updated the record successfully");
    	}
    	else
    	{
    		System.out.println("Update Failed");
    	}
    }
}
