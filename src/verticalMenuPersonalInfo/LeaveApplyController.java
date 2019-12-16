package verticalMenuPersonalInfo;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LeaveApplyController {
	@FXML
    private JFXRadioButton SickLeave;

    @FXML
    private JFXRadioButton CasualLeave;

    @FXML
    private JFXDatePicker LeaveStartDate;

    @FXML
    private JFXDatePicker LeaveEndDate;

    @FXML
    private JFXButton Request_Leave_Btn;

    @FXML
    private JFXButton CLOSE;

    @FXML
    void ApplyLeaveFunction(ActionEvent event) throws IOException {

    }

    @FXML
    void CloseWindow(ActionEvent event) {
	    // get a handle to the stage
	    Stage stage = (Stage) CLOSE.getScene().getWindow();
	    // do what you have to do
	    stage.close();
    }
}
