package verticalMenuPersonalInfo;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

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

public class LeaveApplyController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	@FXML
    private JFXRadioButton SickLeave;

    @FXML
    private JFXRadioButton CasualLeave;

    @FXML
    private JFXDatePicker LeaveStartDate;

    @FXML
    private JFXDatePicker LeaveEndDate;
    @FXML
    final ToggleGroup leave_group = new ToggleGroup();
    
    @FXML
    private JFXButton Request_Leave_Btn;

    @FXML
    private JFXButton CLOSE;

    @FXML
    void ApplyLeaveFunction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	System.out.println("Inside update level Controller"+epass.getEMP_ID());
    	TestDao t = new TestDao();
    	e.setEMP_ID(epass.getEMP_ID());
    	e.setSTART_DATE(java.sql.Date.valueOf(LeaveStartDate.getValue()));
    	e.setEND_DATE(java.sql.Date.valueOf(LeaveEndDate.getValue()));
  	    RadioButton leave = (RadioButton) leave_group.getSelectedToggle();
  	    String leave_type = leave.getText();
  	    String selected_leave_type = null;
  	    if(leave_type.matches("SickLeave")) {
  	    	selected_leave_type = "L_S";
  	    }
  	    else if(leave_type.matches("CasualLeave")) {
  	    	selected_leave_type = "L_V";
  	    }
  	    e.setLEAVE_TYPE(selected_leave_type);
  	    int statusupdate = t.applyleave(e);
  	    if(statusupdate==1)
  	    {
  	    	System.out.println("apply leave Success");
  	    	// get a handle to the stage
  		    Stage stage = (Stage) CLOSE.getScene().getWindow();
  		    // do what you have to do
  		    stage.close();
  	    }
  	    else
  	    {
  	    	System.out.println("apply leave Not Success");
  	    }
  	    
  	    
    }

    @FXML
    void CloseWindow(ActionEvent event) {
	    // get a handle to the stage
	    Stage stage = (Stage) CLOSE.getScene().getWindow();
	    // do what you have to do
	    stage.close();
    }
    @FXML
    public void initialize() {
    	SickLeave.setToggleGroup(leave_group);
    	CasualLeave.setToggleGroup(leave_group);
    	}
}
