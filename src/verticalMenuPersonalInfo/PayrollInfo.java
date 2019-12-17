package verticalMenuPersonalInfo;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TreeTableColumn;
import loginController.LoginController;

public class PayrollInfo {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();

    @FXML
    private JFXTextField Annual_Salary;

    @FXML
    private JFXTextField Bonus;
    
    @FXML
    public void initialize() throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	System.out.println("Inside Payroll Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.fetchPayRollInfo(e);
  	    Annual_Salary.setText(String.valueOf(enew.getC_SALARY()));
  	    Bonus.setText(String.valueOf(enew.getBONUS()));
    }
}
