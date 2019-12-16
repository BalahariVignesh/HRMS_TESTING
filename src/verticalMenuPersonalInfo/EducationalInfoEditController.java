package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EducationalInfoEditController {
	 @FXML
	    private JFXTextField HighestEducationEdit;

	    @FXML
	    private JFXTextArea EditEducationDetails;

	    @FXML
	    private JFXButton Cancel_Cancel_btn;

	    @FXML
	    private JFXButton SAVE_Education_Info;

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
	    void DisplayEducationEdit(ActionEvent event) {

	    }

}
