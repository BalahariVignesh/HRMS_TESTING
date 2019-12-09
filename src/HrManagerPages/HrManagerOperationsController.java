package HrManagerPages;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	    void AddNewEmployeePage(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/HrManagerPages/AddNewEmployeePage.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
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
