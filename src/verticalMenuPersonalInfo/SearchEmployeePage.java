package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SearchEmployeePage {
	
    @FXML
    private JFXTextField EmployeeId;

    @FXML
    private JFXTextField FirstName;

    @FXML
    private JFXTextField LastName;

    @FXML
    private JFXTextField Level;

    @FXML
    private JFXButton NewEmployeeData;

    @FXML
    private JFXTextField Branch;

    @FXML
    private JFXTextField Status;

    @FXML
    private JFXTextField Manager;

    @FXML
    private JFXTextField Project;

    @FXML
    private JFXTextField Country;

    @FXML
    private JFXTextField City;
    
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
    void AddNewEmployee(ActionEvent event) {
    	
    }
    
}
