package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddNewEmployeePage2Controller {
	 @FXML
	    private JFXButton CLOSE;

	    @FXML
	    private JFXTextField NewAddressLine;

	    @FXML
	    private JFXTextField NewStreet;

	    @FXML
	    private JFXTextField NewCity;

	    @FXML
	    private JFXTextField NewZip;

	    @FXML
	    private JFXTextField NewOfficeContact;

	    @FXML
	    private JFXTextField NewOfficeEmail;

	    @FXML
	    private JFXTextField NewLevel;

	    @FXML
	    private JFXTextField NewBranch;

	    @FXML
	    private JFXTextField NewStatus;

	    @FXML
	    private JFXRadioButton HR;

	    @FXML
	    private JFXRadioButton EMPLOYEE;

	    @FXML
	    private JFXRadioButton MANAGER;

	    @FXML
	    private JFXRadioButton PMO;

	    @FXML
	    private JFXButton NewEmployeeData;

	    @FXML
	    void AddNewEmployee(ActionEvent event) {

	    }

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
