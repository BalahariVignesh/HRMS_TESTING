package HrManagerPages;

import java.io.IOException;

import javax.swing.JButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;
import org.planning.test.jdbc.*;

public class HrHomePageController {
	@FXML
    private JFXButton PersonalInfo;

    @FXML
    private JFXButton CONTACT;

    @FXML
    private JFXButton ADDRESS;

    @FXML
    private JFXButton OFFICE;

    @FXML
    private JFXButton PAYROLL;

    @FXML
    private JFXButton ASSETS;

    @FXML
    private JFXButton EDUCATIONAL;

    @FXML
    private JFXButton HROPERATIONS;

    @FXML
    private Pane TitlePane;

    @FXML
    private Text Title;

    @FXML
    private JFXButton CLOSE;

    @FXML
    private Text Breadcrumb;

    @FXML
    private Pane mainPane;

    @FXML
    private FontAwesomeIconView UserIcon;

    @FXML
    void CloseWindow(ActionEvent event) {

    }

    @FXML
    void handleClicks(ActionEvent event) throws IOException {
    	
    	if(event.getSource() == HROPERATIONS )
    	{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/HrManagerPages/HrOperations.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}

    }
}
