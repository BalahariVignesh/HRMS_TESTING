package verticalMenuPersonalInfo;
import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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

import java.io.IOException;

import org.planning.test.jdbc.*;
public class PersonalInfoController {
	private final LoginController contrl = new LoginController();
		Employee epass = contrl.getEmployee();
		
	 	@FXML
	    public JFXTextField FNAME = new JFXTextField();
	 	
	 	
	    @FXML
	    private JFXTextField MNAME;

	    @FXML
	    private JFXTextField LNAME;

	    @FXML
	    private JFXTextField DOB;

	    @FXML
	    private JFXTextField SSN;

	    @FXML
	    private JFXTextField MaritalStatus;

	    @FXML
	    private JFXButton Cancel_btn;

	    @FXML
	    private JFXButton Edit_btn;

	    @FXML
	    private JFXButton TEST;
	    
	    @FXML
	    private JFXTextField GENDER;

	    @FXML
	    void CancelPinfo(ActionEvent event) {

	    }

	    @FXML
	    void EditPInfo(ActionEvent event) throws IOException {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/PersonalInfoEdit.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
	    }
	    @FXML
	    public void initialize() {
	    	Employee e = new Employee();
	    	System.out.println("Inside Personal Info Controller"+epass.getEMP_ID());
      	    e.setEMP_ID(epass.getEMP_ID());
      	    TestDao t = new TestDao();
      	    Employee enew = t.fetchEmployeePersonalDetails(e);
      	    System.out.println(e.getFNAME());
      	    FNAME.setText(enew.getFNAME());
      	    System.out.println(enew.getFNAME());
      	    MNAME.setText(enew.getMNAME());
      	    LNAME.setText(enew.getLNAME());
      	    DOB.setText(String.valueOf(enew.getDOB()));
      	    SSN.setText(String.valueOf(enew.get_sno()));
      	    MaritalStatus.setText(enew.getMAR());
      	    GENDER.setText(enew.getGENDER());
	    }


	    @FXML
	    void TEST_DISPLAY(ActionEvent event) {
	    	
	    }
}