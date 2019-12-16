package verticalMenuPersonalInfo;


import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import loginController.LoginController;

public class OfficeInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	
	 @FXML
	    private JFXTextField EmployeeLevel;

	    @FXML
	    private JFXTextField EmployeeBranch;

	    @FXML
	    private JFXTextField EmployeeStatus;

	    @FXML
	    private JFXTextField EmployeeManager;

	    @FXML
	    private JFXTextField EmployeeProjectName;
	    
	    @FXML
	    public void initialize() throws ClassNotFoundException, SQLException {
	    	Employee e = new Employee();
	    	System.out.println("Inside Office Info Controller"+epass.getEMP_ID());
      	    e.setEMP_ID(epass.getEMP_ID());
      	    TestDao t = new TestDao();
      	    Employee enew = t.fetchOfficeInfo(e);
      	    EmployeeLevel.setText(String.valueOf(enew.getC_LEVEL()));
      	    System.out.println(enew.getC_LEVEL());
      	    EmployeeBranch.setText(enew.getC_Branch());
      	    EmployeeStatus.setText(enew.getC_STATUS());
      	    EmployeeManager.setText(enew.getMANAGER());
      	    EmployeeProjectName.setText(enew.getPROJECT_NAME());
	    }

}
