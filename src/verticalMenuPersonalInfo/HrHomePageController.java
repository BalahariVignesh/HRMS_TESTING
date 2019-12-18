package verticalMenuPersonalInfo;

import java.io.IOException;
import java.nio.file.Paths;

import javax.print.DocFlavor.URL;
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
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
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
	    private JFXButton LEAVES;

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
	    	// get a handle to the stage
	        Stage stage = (Stage) CLOSE.getScene().getWindow();
	        // do what you have to do
	        stage.close();
	    }

	    @FXML
	    void handleClicks(ActionEvent event) throws IOException {
	    	if(event.getSource() == PersonalInfo)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("PERSONAL INFORMATION");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/PERSONALINFO");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/PersonalInfo.fxml"));
	    	    mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == CONTACT)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("CONTACT");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/CONTACT");
	    		System.out.println("flag1");
	    		try{FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/ContactInfo.fxml"));
	    		System.out.println("flag2");
	    		mainPane.getChildren().add(fxmlLoader.load());}
	    		catch(Exception ex) {
	    			System.out.println(ex);
	    		}
	    		System.out.println("flag3");
	    	}
	    	else if(event.getSource() == ADDRESS)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("ADDRESS");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/ADDRESS");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddressInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == OFFICE)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("OFFICE");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/OFFICE");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/OfficeInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == PAYROLL)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("PAYROLL");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/PAYROLL");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/PayrollInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == ASSETS)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("ASSETS");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/ASSETS");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AssetsInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == EDUCATIONAL)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("EDUCATIONAL");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/EDUCATIONAL");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/EducationalInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == LEAVES)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("LEAVES");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/LEAVES");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/LeaveInfo.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    	else if(event.getSource() == HROPERATIONS)
	    	{
	    		mainPane.getChildren().clear();
	    		UserIcon.setVisible(false);
	    		Title.setText("HR OPERATIONS");
	    		Title.setStyle("-fx-font-size:36px");
	    		TitlePane.setStyle("-fx-background-color:#4250EB");
	    		Breadcrumb.setText("/HOME/HR/HROPERATIONS");
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/HrOperations.fxml"));
	    		mainPane.getChildren().add(fxmlLoader.load());
	    	}
	    }
}
