package verticalMenuPersonalInfo;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;
import org.planning.test.jdbc.*;


public class ContactEditController {
	private final LoginController contrl = new LoginController();
	private final AlertMessage alert = new AlertMessage();
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
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void DisplayCEdit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
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
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/ContactSuccessAlert.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    	else
    	{
    		System.out.println("Update Failed");
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/ContactUnSuccessAlert.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1)); 
    	    alert.setAlert("Update unsuccessful");
    	    
    	    stage.show();
    	}
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
