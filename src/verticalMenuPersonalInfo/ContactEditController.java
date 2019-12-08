package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.*;
import loginController.LoginController;


public class ContactEditController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private Label Mobile;

    @FXML
    private Label Landline;

    @FXML
    private Label Email;

    @FXML
    private JFXTextField PersonalNoEdit;

    @FXML
    private JFXTextField OfficeNoEdit;

    @FXML
    private JFXButton Cancel_Cancel_btn;

    @FXML
    private JFXButton SAVE_Contact;

    @FXML
    private JFXButton CLOSE;

    @FXML
    void CancelCinfo(ActionEvent event) {

    }

    @FXML
    void CloseWindow(ActionEvent event) {

    }

    @FXML
    void DisplayCEdit(ActionEvent event) {

    }
}
