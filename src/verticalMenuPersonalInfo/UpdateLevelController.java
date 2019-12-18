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

public class UpdateLevelController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	 	@FXML
	    private JFXTextField LevelId;

	    @FXML
	    private JFXTextField EmployeeId;

	    @FXML
	    private JFXButton SAVE_Level;

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
	    void SAVE_Level(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	Employee e = new Employee();
	    	System.out.println("Inside update level Controller"+epass.getEMP_ID());
	    	int hrid=epass.getEMP_ID();
	    	e.setPass_ssn(hrid);
	  	    TestDao t = new TestDao();
	  	    e.setEMP_ID(Integer.parseInt(EmployeeId.getText()));
	  	    e.setC_LEVEL(Integer.parseInt(LevelId.getText()));
	  	    int levelupdate = t.levelupdate(e);
	  	    if(levelupdate==1)
	  	    {
	  	    	System.out.println("level Success");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("levelNot Success");
	  	    }
	  	    int hr_update = t.hrlog(e);
	  	    if(hr_update==1)
	  	    {
	  	    	System.out.println("level hr Success");
		        // get a handle to the stage
		        Stage stage = (Stage) CLOSE.getScene().getWindow();
		        // do what you have to do
		        stage.close();
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("level hr Not Success");
	  	    }
	  	    e.setEMP_ID(hrid);
	    }
}
