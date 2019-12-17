package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
    final ToggleGroup gender_group = new ToggleGroup();
    
    @FXML
    private JFXTextField NewSSN;

    @FXML
    private JFXRadioButton SINGLE;
    
    
    @FXML
    private JFXRadioButton MARRIED;

    @FXML
    private JFXRadioButton DIVORCED;
    
    @FXML
    final ToggleGroup marital_group = new ToggleGroup();
    
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
    public void initialize() {
    	SINGLE.setToggleGroup(marital_group);
    	MARRIED.setToggleGroup(marital_group);
    	DIVORCED.setToggleGroup(marital_group);
    	MALE.setToggleGroup(gender_group);
    	FEMALE.setToggleGroup(gender_group);
    	OTHERS.setToggleGroup(gender_group);
    }
    @FXML
    void AddNewEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	String selected_gender = null;
    	String selected_martial = null;
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    e.setFNAME(NewFirstName.getText());
  	    e.setMNAME(NewMiddleName.getText());
  	    e.setLNAME(NewLastName.getText());
  	    e.setDOB(java.sql.Date.valueOf(NewDOB.getValue()));
  	    e.set_sno(Integer.parseInt(NewSSN.getText()));
  	    e.setC_SALARY(Float.parseFloat(NewCTC.getText()));
  	    RadioButton gender = (RadioButton) gender_group.getSelectedToggle();
  	    String gender_value = gender.getText();
  	    if(gender_value.matches("MALE")) {
  	    	selected_gender = "G_M";
  	    }
  	    else if(gender_value.matches("FEMALE")) {
  	    	selected_gender = "G_F";
  	    }
  	    else if(gender_value.matches("OTHERS")) {
  	    	selected_gender = "G_O";
  	    }
  	    e.setGENDER(selected_gender);
  	    RadioButton marital = (RadioButton) marital_group.getSelectedToggle();
  	    String marital_value = marital.getText();
  	    if(marital_value.matches("SINGLE")) {
  	    	selected_martial = "M_S";
	    }
	    else if(marital_value.matches("MARRIED")) {
	    	selected_martial = "M_M";
	    }
	    else if(marital_value.matches("DIVORCED")) {
	    	selected_martial = "M_D";
	    }
  	    e.setMAR(marital_value);
  	    int result = t.insertEmployee(e);
  	    if(result>0) {
  	    	//code to open second window of insert and close this window
  	    	
  	    }
  	    else {
  	    	//ask to reinsert the values, this window should not close
  	    }
  	    
    }

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
