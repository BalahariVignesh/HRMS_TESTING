package verticalMenuPersonalInfo;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import loginController.LoginController;

public class UpdateStatusController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	 @FXML
	    private JFXRadioButton EMPLOYED;

	    @FXML
	    private JFXRadioButton TERMINATED;

	    @FXML
	    private JFXRadioButton RETIRED;

	    @FXML
	    private JFXRadioButton INTERN;

	    @FXML
	    private JFXRadioButton PARTTIME;

	    @FXML
	    private JFXRadioButton CONTRACT;
	    
	    @FXML
	    final ToggleGroup status_group = new ToggleGroup();
	    
	    @FXML
	    private JFXTextField EmployeeId;

	    @FXML
	    private JFXButton SAVE_Status;

	    @FXML
	    private JFXButton CLOSE;
	    @FXML
	    public void initialize() {
	    	EMPLOYED.setToggleGroup(status_group);
	    	TERMINATED.setToggleGroup(status_group);
	    	RETIRED.setToggleGroup(status_group);
	    	INTERN.setToggleGroup(status_group);
	    	PARTTIME.setToggleGroup(status_group);
	    	CONTRACT.setToggleGroup(status_group);
	    }

	    @FXML
	    void CloseWindow(ActionEvent event) {
	        // get a handle to the stage
	        Stage stage = (Stage) CLOSE.getScene().getWindow();
	        // do what you have to do
	        stage.close();
	    }

	    @FXML
	    void SAVE_Status(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	Employee e = new Employee();
	    	System.out.println("Inside update level Controller"+epass.getEMP_ID());
	    	int hrid=epass.getEMP_ID();
	    	e.setPass_ssn(hrid);
	    	e.setEMP_ID(Integer.parseInt(EmployeeId.getText()));
	    	TestDao t = new TestDao();
	  	    RadioButton status = (RadioButton) status_group.getSelectedToggle();
	  	    String status_value = status.getText();
	  	    String selected_status = null;
	  	    if(status_value.matches("EMPLOYED")) {
	  	    	selected_status = "S_E";
	  	    }
	  	    else if(status_value.matches("TERMINATED")) {
	  	    	selected_status = "S_T";
	  	    }
	  	    else if(status_value.matches("RETIRED")) {
	  	    	selected_status = "S_R";
	  	    }
	  	    else if(status_value.matches("INTERN")) {
	  		  	selected_status = "S_I";
	  	    }
	  	    else if(status_value.matches("PARTTIME")) {
	  	    	selected_status = "S_P";
	  	    }
	  	    else if(status_value.matches("CONTRACT")) {
	  	    	selected_status = "S_C";
	  	    }
	  	    e.setC_STATUS(selected_status);
	  	    int statusupdate = t.insertstatus(e);
	  	    if(statusupdate==1)
	  	    {
	  	    	System.out.println("status Success");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("status Not Success");
	  	    }
	  	    int hr_update = t.hrlog(e);
	  	    if(hr_update==1)
	  	    {
	  	    	System.out.println("status hr Success");
		        // get a handle to the stage
		        Stage stage = (Stage) CLOSE.getScene().getWindow();
		        // do what you have to do
		        stage.close();
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("status hr Not Success");
	  	    }
	  	    
	  	  e.setEMP_ID(hrid);
	    }
}
