package verticalMenuPersonalInfo;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;

public class LeaveInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private JFXTextField CasualLeave;

    @FXML
    private JFXTextField SickLeave;

    @FXML
    private JFXButton Request_Leave_Btn;
    
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
    	Employee e = new Employee();
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.fetchLeaveBalance(e);
  	    CasualLeave.setText(String.valueOf(enew.getC_LEAVE()));
  	    SickLeave.setText(String.valueOf(enew.getS_LEAVE()));
  	 	    	       	
    }

    @FXML
    void RequestNewLeave(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/LeaveApply.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }
}
