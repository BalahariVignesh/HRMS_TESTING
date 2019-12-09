package HrManagerPages;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class HrManagerAndEmployeePageController {
	
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
	    void ShowEmployeePage(ActionEvent event) {

	    }

	    @FXML
	    void ShowHrManagerPage(ActionEvent event) {

	    }

}
