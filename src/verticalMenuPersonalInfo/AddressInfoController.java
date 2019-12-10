package verticalMenuPersonalInfo;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import loginController.LoginController;
import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

public class AddressInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
	@FXML
    private JFXButton Edit_Present_Address_btn;

    @FXML
    private JFXTextField PresentStreet;

    @FXML
    private JFXTextField PresentCity;

    @FXML
    private JFXTextField PresentAddLine;

    @FXML
    private JFXTextField PresentCountry;

    @FXML
    private JFXTextField PresentZip;

    @FXML
    private JFXButton Edit_PermanentAddress_btn;

    @FXML
    private JFXTextField PermanentAddLine;

    @FXML
    private JFXTextField PermanentStreet;

    @FXML
    private JFXTextField PermanentCity;

    @FXML
    private JFXTextField PermanentCountry;

    @FXML
    private JFXTextField PermanentZip;

    @FXML
    private JFXTextField OfficeAddLine;

    @FXML
    private JFXTextField OfficeStreet;

    @FXML
    private JFXTextField OfficeCity;

    @FXML
    private JFXTextField OfficeCountry;

    @FXML
    private JFXTextField OfficeZip;

    @FXML
    private JFXButton Cancel_Address_btn;

    @FXML
    void CancelAinfo(ActionEvent event) {

    }

    @FXML
    void EditPermanentAddressInfo(ActionEvent event) {

    }

    @FXML
    void EditPresentAddressInfo(ActionEvent event) {

    }
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
    	Employee e = new Employee();
    	System.out.println("Inside Contact Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.officeaddressinfo(e);
  	    //System.out.println(enew.getCONTACT());
  	    OfficeAddLine.setText(enew.getOFFICIAL_ADDR());
  	    OfficeStreet.setText(enew.getOFFICIAL_STREET());
  	    OfficeCity.setText(enew.getOFFICIAL_CITY());
  	    OfficeCountry.setText(enew.getOFFICIAL_COUNTRY());
  	    OfficeZip.setText(String.valueOf(enew.getOFFICIAL_ZIP()));
  	    enew = t.permanentaddressinfo(e);
  	    PermanentAddLine.setText(enew.getPERMANENT_ADDR());
  	    PermanentStreet.setText(enew.getPERMANENT_STREET());
  	    PermanentCity.setText(enew.getPERMANENT_CITY());
  	    PermanentCountry.setText(enew.getPERMANENT_COUNTRY());
  	    PermanentZip.setText(String.valueOf(enew.getPERMANENT_ZIP()));
  	    enew = t.presentaddressinfo(e);
	    PresentAddLine.setText(enew.getPRESENT_ADDR());
	    PresentStreet.setText(enew.getPRESENT_STREET());
	    PresentCity.setText(enew.getPRESENT_CITY());
	    PresentCountry.setText(enew.getPRESENT_COUNTRY());
	    PresentZip.setText(String.valueOf(enew.getPRESENT_ZIP()));
  	    
  	       	
    }
}
