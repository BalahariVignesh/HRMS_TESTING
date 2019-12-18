package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateLevelController {
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
	    void SAVE_Level(ActionEvent event) {

	    }
}
