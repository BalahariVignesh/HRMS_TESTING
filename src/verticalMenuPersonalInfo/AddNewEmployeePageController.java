package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import loginController.LoginController;
import org.planning.test.jdbc.*;

public class AddNewEmployeePageController{
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	

    @FXML
    private JFXButton CLOSE;

    @FXML
    private JFXButton NewEmployeeData;

    @FXML
    private JFXTextField EmployeeId;

    @FXML
    private JFXTextField NewFirstName;

    @FXML
    private JFXTextField NewMiddleName;

    @FXML
    private JFXTextField NewLastName;

    @FXML
    private JFXDatePicker NewDOB;

    @FXML
    private JFXRadioButton MALE;

    @FXML
    private JFXRadioButton FEMALE;

    @FXML
    private JFXRadioButton OTHERS;

    @FXML
    private JFXTextField NewSSN;

    @FXML
    private JFXTextField NewAddLine;

    @FXML
    private JFXTextField NewStreet;

    @FXML
    private JFXTextField NewCity;

    @FXML
    private JFXTextField NewCountry;

    @FXML
    private JFXTextField NewZIP;

    @FXML
    private JFXTextField NewPersonalContact;

    @FXML
    private JFXTextField NewPersonalEmail;

    @FXML
    private JFXTextField NewEducation;

    @FXML
    private JFXTextField NewMajor;

    @FXML
    private JFXTextField NewLevel;

    @FXML
    private JFXTextField NewBranch;

    @FXML
    private JFXTextField NewCTC;

    @FXML
    private JFXTextField NewStatus;

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
