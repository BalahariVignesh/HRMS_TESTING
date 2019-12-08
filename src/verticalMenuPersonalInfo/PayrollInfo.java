package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TreeTableColumn;

public class PayrollInfo {
	 @FXML
	    private ScrollBar ScrollVertical;

	    @FXML
	    private ScrollBar ScrollHorizontal;

	    @FXML
	    private TreeTableColumn<?, ?> TableYear;

	    @FXML
	    private TreeTableColumn<?, ?> TablePeriod;

	    @FXML
	    private TreeTableColumn<?, ?> TableCompensation;

	    @FXML
	    private TreeTableColumn<?, ?> TableStatus;

	    @FXML
	    private TreeTableColumn<?, ?> TableProcessedBy;

	    @FXML
	    private TreeTableColumn<?, ?> TableProcessedOn;

	    @FXML
	    private JFXTextField Vaccation_Balance;

	    @FXML
	    private JFXTextField SickLeave_Balance;
}
