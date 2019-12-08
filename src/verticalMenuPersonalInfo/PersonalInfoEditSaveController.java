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

public class PersonalInfoEditSaveController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	   @FXML
	    private JFXTextField MNAME_EDIT;

	    @FXML
	    private JFXTextField LNAME_EDIT;

	    @FXML
	    private JFXTextField Marital_Status_EDIT;

	    @FXML
	    private JFXButton Cancel_btn;

	    @FXML
	    private JFXButton CLOSE;

	    @FXML
	    void CloseWindow(ActionEvent event) {
	        // get a handle to the stage
	        Stage stage = (Stage) CLOSE.getScene().getWindow();
	        // do what you have to do
	        stage.close();
	    }

	    @FXML
	    void Updateinfo(ActionEvent event) throws SQLException {
	    	Employee e = new Employee();
	    	TestDao t = new TestDao();
	    	e.setEMP_ID(epass.getEMP_ID());
	    	e.setMNAME(MNAME_EDIT.getText());
	    	e.setLNAME(LNAME_EDIT.getText());
	    	e.setMAR(Marital_Status_EDIT.getText());
	    	int rs = t.contactedit(e);
	    	if(rs>0)
	    	{
	    		System.out.println("Updated Successfully");
	    	}
	    	else
	    	{
	    		System.out.println("Failed");
	    	}
	    	

	    }
}
