package verticalMenuPersonalInfo;

import org.planning.test.jdbc.AlertMessage;

import com.jfoenix.controls.JFXButton;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

import java.sql.SQLException;

import org.planning.test.jdbc.*;


public class ContactUnSuccessAlertController {
	private final AlertMessage alert = new AlertMessage();
	    @FXML
	    public void initialize(){
	    	((Labeled) AlertContentText).setText("HOIIII");
	    }
	    
	    
	    @FXML
	    private JFXButton CLOSE;

	    @FXML
	    private Label AlertContentText;

	    @FXML
	    void CloseWindow(ActionEvent event) {
		        // get a handle to the stage
		        Stage stage = (Stage) CLOSE.getScene().getWindow();
		        // do what you have to do
		        stage.close();
	    }
}
