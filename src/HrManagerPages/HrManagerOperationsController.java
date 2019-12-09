package HrManagerPages;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class HrManagerOperationsController {
	
	 @FXML
	    private JFXButton AddNewEmployee;

	    @FXML
	    private JFXButton ViewEmployeePage;

	    @FXML
	    private JFXButton CLOSE;

	    @FXML
	    private JFXButton UpdateEmployeePage;

	    @FXML
	    void AddNewEmployeePage(ActionEvent event) {

	    }

	    @FXML
	    void CloseWindow(ActionEvent event) {
	        // get a handle to the stage
	        Stage stage = (Stage) CLOSE.getScene().getWindow();
	        // do what you have to do
	        stage.close();

	    }

	    @FXML
	    void UpdateEmployeePage(ActionEvent event) {

	    }

	    @FXML
	    void ViewEmployeePage(ActionEvent event) {

	    }

	
}
