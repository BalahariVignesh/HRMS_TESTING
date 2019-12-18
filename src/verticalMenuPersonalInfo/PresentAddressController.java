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

public class PresentAddressController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	@FXML
    private JFXTextField PresentAddressLine_edit;

    @FXML
    private JFXTextField PresentStreet_edit;

    @FXML
    private JFXTextField PresentCity_edit;

    @FXML
    private JFXTextField PresentCountry_edit;

    @FXML
    private JFXTextField PresentZip_edit;

    @FXML
    private JFXButton Cancel_Address_btn;

    @FXML
    private JFXButton SavePresentAddress;

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
    void EditPresentAddress(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Employee e = new Employee();
    	TestDao t = new TestDao();
    	e.setEMP_ID(epass.getEMP_ID());
    	e.setPRESENT_ADDR(PresentAddressLine_edit.getText());
    	System.out.println("Present address is"+e.getPRESENT_ADDR());
    	e.setPRESENT_STREET(PresentStreet_edit.getText());
    	e.setPRESENT_CITY(PresentCity_edit.getText());
    	e.setPRESENT_COUNTRY(PresentCountry_edit.getText());
    	e.setPRESENT_ZIP(Integer.parseInt(PresentZip_edit.getText()));
    	int result = t.editpresentaddressinfo(e);
    	if(result == 1) {
    		System.out.println("Updated the record successfully");
    		Stage stage = (Stage) CLOSE.getScene().getWindow();
            // do what you have to do
            stage.close();
    	}
    	else
    	{
    		System.out.println("Update Failed");
    	}
    }

}
