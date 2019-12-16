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

public class PermanentAddressController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	@FXML
    private JFXTextField PermanentAddressLine_edit;

    @FXML
    private JFXTextField PermanentStreet_edit;

    @FXML
    private JFXTextField PermanentCity_edit;

    @FXML
    private JFXTextField PermanentCountry_edit;

    @FXML
    private JFXTextField PermanentZip_edit;

    @FXML
    private JFXButton Cancel_Address_btn;

    @FXML
    private JFXButton SavePermanentAddress;

    @FXML
    private JFXButton CLOSE;

    @FXML
    void CancelAinfo(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) Cancel_Address_btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void EditPermanentAddress(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	TestDao t = new TestDao();
    	e.setEMP_ID(epass.getEMP_ID());
    	e.setPERMANENT_ADDR(PermanentAddressLine_edit.getText());
    	System.out.println("Permanent address is"+e.getPERMANENT_ADDR());
    	e.setPERMANENT_STREET(PermanentStreet_edit.getText());
    	e.setPERMANENT_CITY(PermanentCity_edit.getText());
    	e.setPERMANENT_COUNTRY(PermanentCountry_edit.getText());
    	e.setPERMANENT_ZIP(Integer.parseInt(PermanentZip_edit.getText()));
    	int result = t.editpermanentaddressinfo(e);
    	if(result == 1) {
    		System.out.println("Updated the record successfully");
    	}
    	else
    	{
    		System.out.println("Update Failed");
    	}
    	
   
    	
    }
}
