package HrManagerPages;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;

import java.io.IOException;

import org.planning.test.jdbc.*;


public class HrManagerAndEmployeePageController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	
	  @FXML
	    private JFXButton EmployeePage;

	    @FXML
	    private JFXButton HrManagerPage;

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
	    void ShowEmployeePage(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/VerticalMenu.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();

	    }

	    @FXML
	    void ShowHrManagerPage(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/HrManagerPages/HrManagerOperations.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();

	    }

}
