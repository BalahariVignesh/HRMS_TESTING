package verticalMenuPersonalInfo;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AssetsAddNewController {
	
	   @FXML
	    private JFXButton RequestNewAsset;

	    @FXML
	    public JFXButton CLOSE;  
	    
	    
	    @FXML
	    void CloseWindow(ActionEvent event) {
	    // get a handle to the stage
	    Stage stage = (Stage) CLOSE.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	    }


	    @FXML
	    void RequestNewAssetFunction(ActionEvent event) {

	    }
    
}
