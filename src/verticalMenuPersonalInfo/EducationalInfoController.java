package verticalMenuPersonalInfo;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class EducationalInfoController {
	@FXML
    private JFXTextField HighestE;

    @FXML
    private JFXTextArea EducationalDetails;

    @FXML
    private JFXButton Edit_Education_Info;


    @FXML
    void EditEducationInfo(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/EducationInfoEdit.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }

}
