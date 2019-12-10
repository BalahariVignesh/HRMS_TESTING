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
    private JButton PersonalInfo;

    @FXML
    private JButton CONTACT;

    @FXML
    private JButton ADDRESS;

    @FXML
    private JButton OFFICE;

    @FXML
    private JButton PAYROLL;

    @FXML
    private JButton ASSETS;

    @FXML
    private JButton EDUCATIONAL;

    @FXML
    private Pane TitlePane;

    @FXML
    private Text Title;

    @FXML
    private JButton CLOSE;

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
    void handleClicks(ActionEvent event) {

    }

}
