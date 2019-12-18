package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateStatusController {
	 @FXML
	    private JFXRadioButton EMPLOYED;

	    @FXML
	    private JFXRadioButton TERMINATED;

	    @FXML
	    private JFXRadioButton RETIRED;

	    @FXML
	    private JFXRadioButton INTERN;

	    @FXML
	    private JFXRadioButton PARTTIME;

	    @FXML
	    private JFXRadioButton CONTRACT;

	    @FXML
	    private JFXTextField EmployeeId;

	    @FXML
	    private JFXButton SAVE_Status;

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
	    void SAVE_Status(ActionEvent event) {

	    }
}
