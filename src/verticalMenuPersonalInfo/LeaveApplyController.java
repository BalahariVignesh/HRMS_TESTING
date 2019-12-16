package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    void ApplyLeaveFunction(ActionEvent event) {

    }

    @FXML
    void CloseWindow(ActionEvent event) {

    }
}
