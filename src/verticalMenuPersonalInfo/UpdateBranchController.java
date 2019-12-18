package verticalMenuPersonalInfo;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import loginController.LoginController;

public class UpdateBranchController {
		private final LoginController contrl = new LoginController();
		Employee epass = contrl.getEmployee();
		@FXML
	    private JFXTextField BranchName;

	    @FXML
	    private JFXTextField EmployeeId;

	    @FXML
	    private JFXButton SAVE_Branch;

	    @FXML
	    private JFXButton CLOSE;

	    @FXML
	    void CloseWindow(ActionEvent event) {
	        // get a handle to the stage
	        Stage stage = (Stage) CLOSE.getScene().getWindow();
	        // do what you have to do
	        stage.close();
	    }

	    @FXML
	    void SAVE_Branch(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	Employee e = new Employee();
	    	System.out.println("Inside update branch Controller"+epass.getEMP_ID());
	    	int hrid=epass.getEMP_ID();
	    	e.setPass_ssn(hrid);
	  	    TestDao t = new TestDao();
	  	    e.setEMP_ID(Integer.parseInt(EmployeeId.getText()));
	  	    e.setC_Branch(BranchName.getText());
	  	    int branchupdate = t.insertbranch(e);
	  	    if(branchupdate==1)
	  	    {
	  	    	System.out.println("branch Success");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("branch Not Success");
	  	    }
	  	    int hr_update = t.hrlog(e);
	  	    if(hr_update==1)
	  	    {
	  	    	System.out.println("branch hr Success");
		        // get a handle to the stage
		        Stage stage = (Stage) CLOSE.getScene().getWindow();
		        // do what you have to do
		        stage.close();
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("branch hr Not Success");
	  	    }
	  	    e.setEMP_ID(hrid);
	    }
}
