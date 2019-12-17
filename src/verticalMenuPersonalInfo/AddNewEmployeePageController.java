package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import loginController.LoginController;

import java.sql.SQLException;

import org.planning.test.jdbc.*;

public class AddNewEmployeePageController{
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private JFXButton CLOSE;

    @FXML
    private JFXButton NewEmployeeData;

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
    private JFXRadioButton SINGLE;

    @FXML
    private JFXRadioButton MARRIED;

    @FXML
    private JFXRadioButton DIVORCED;

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
    void AddNewEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    e.setFNAME(NewFirstName.getText());
  	    e.setMNAME(NewMiddleName.getText());
  	    e.setLNAME(NewLastName.getText());
  	    e.setDOB(java.sql.Date.valueOf(NewDOB.getValue()));
  	    e.set_sno(Integer.parseInt(NewSSN.getText()));
  	    e.setC_SALARY(Float.parseFloat(NewCTC.getText()));
  	  
  	    int result = t.insertEmployee(e);
  	    
    }

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
