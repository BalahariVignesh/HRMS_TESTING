package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateBranchController {
	  @FXML
	    private JFXTextField BranchName;

	    @FXML
	    private JFXTextField EmployeeId;

	    @FXML
	    private JFXButton SAVE_Branch;

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
	    void SAVE_Branch(ActionEvent event) {

	    }
}
