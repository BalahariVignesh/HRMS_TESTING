package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;

import java.io.IOException;
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
    void AddNewEmployee(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    	Employee e = new Employee();
    	String selected_gender = null;
    	String selected_martial = null;
    	System.out.println("Inside 1st insert Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    e.setFNAME(NewFirstName.getText());
  	    e.setMNAME(NewMiddleName.getText());
  	    e.setLNAME(NewLastName.getText());
  	    e.setDOB(java.sql.Date.valueOf(NewDOB.getValue()));
  	    int sno = Integer.parseInt(NewSSN.getText());
  	    e.set_sno(sno);
  	    System.out.println("Printing from 1st controller"+sno);
  	    //passing ssn for next insert page
  	    //contrl.setPass_ssn_param(e.get_sno());
  	    e.setPass_ssn(sno);
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
  	    e.setMAR(selected_martial);
  	    Employee eresult = t.insertEmployee(e);
  	    int result = eresult.getRs();
  	    epass.setPass_ssn(eresult.getPass_ssn());
  	    if(result>0) {
  	    	//code to open second window of insert and close this window
  	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddNewEmployeePage2.fxml"));
  		    Parent root1 = (Parent) fxmlLoader.load();
  		    Stage stage = new Stage();
  		    stage.initModality(Modality.APPLICATION_MODAL);
  		    stage.initStyle(StageStyle.UNDECORATED);
  		    stage.setScene(new Scene(root1));  
  		    stage.show();
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
