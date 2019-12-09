package HrManagerPages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
    private JFXTextField NewStreet;

    @FXML
    private JFXTextField NewCity;

    @FXML
    private JFXTextField NewCountry;

    @FXML
    private JFXTextField NewZip;

    @FXML
    private JFXTextField NewPersonalContact;

    @FXML
    private JFXTextField NewEmailId;

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
    private JFXTextField NewFirstName;

    @FXML
    private JFXTextField NewMiddleName;

    @FXML
    private JFXTextField NewLastName;

    @FXML
    private JFXDatePicker NewDOB;

    @FXML
    private JFXTextField NewSSN;

    @FXML
    private JFXTextField NewAddLine;

    @FXML
    private JFXButton NewEmployeeData;

    @FXML
    void AddNewEmployee(ActionEvent event) {
    	System.out.println("Hiiiiiiiiiiiiiiiiiiiii");
    }

}
