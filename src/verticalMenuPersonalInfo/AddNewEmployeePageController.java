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
    private JFXTextField NewSSN;
    
    @FXML
    final ToggleGroup marital_group = new ToggleGroup();
    
    @FXML
    final ToggleGroup gender_group = new ToggleGroup();
    
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
    	String m_stat = null;
    	String g = null;
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    e.setFNAME(NewFirstName.getText());
  	    e.setMNAME(NewMiddleName.getText());
  	    e.setLNAME(NewLastName.getText());
  	    e.setDOB(java.sql.Date.valueOf(NewDOB.getValue()));
  	    e.set_sno(Integer.parseInt(NewSSN.getText()));
  	    e.setC_SALARY(Float.parseFloat(NewCTC.getText()));
  	    RadioButton selectedRadioButton = (RadioButton)marital_group.getSelectedToggle();
  	    String marital_status = selectedRadioButton.getText();
  	    System.out.println(marital_status);
  	    if(marital_status.matches("SINGLE")) {
  	    	m_stat = "M_S";
  	    }else if(marital_status.matches("MARRIED")) {
  	    	m_stat = "M_M";
  	    }else if(marital_status.matches("DIVORCED")) {
  	    	m_stat = "M_D";
  	    }
  	    RadioButton selectedRadioButton2 = (RadioButton)gender_group.getSelectedToggle();
	    String gender = selectedRadioButton2.getText();
	    System.out.println(gender);
	    if(gender.matches("MALE")) {
	    	g = "G_M";
	    }
	    else if(gender.matches("FEMALE")) {
	    	g = "G_F";
	    }
	    else if(gender.matches("OTHERS")) {
	    	g = "G_O";
	    }
	    e.setMAR(m_stat);
	    e.setGENDER(g);
  	    int result = t.insertEmployee(e);
  	    if(result>0) {
  	    	//invoke page 2 of the insert employee and close this window
  	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddNewEmployeePage2.fxml"));
  		    Parent root1 = (Parent) fxmlLoader.load();
  		    Stage stage = new Stage();
  		    stage.initModality(Modality.APPLICATION_MODAL);
  		    stage.initStyle(StageStyle.UNDECORATED);
  		    stage.setScene(new Scene(root1));  
  		    stage.show();
  	    }
  	    else {
  	    	//ask to reinsert the employee name once again
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
