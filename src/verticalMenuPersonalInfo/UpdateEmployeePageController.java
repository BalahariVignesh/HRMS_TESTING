package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateEmployeePageController {
	@FXML
    private JFXButton UpdateBranch;

    @FXML
    private JFXButton UpdateLevel;

    @FXML
    private JFXButton UpdateSalary;

    @FXML
    private JFXButton UpdateStatus;

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
    void UpdateBranch(ActionEvent event) {

    }

    @FXML
    void UpdateLevel(ActionEvent event) {

    }

    @FXML
    void UpdateSalary(ActionEvent event) {

    }

    @FXML
    void UpdateStatus(ActionEvent event) {

    }
}
