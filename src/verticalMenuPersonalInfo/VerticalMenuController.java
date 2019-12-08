package verticalMenuPersonalInfo;

import java.io.IOException;

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
public class VerticalMenuController {
		private final LoginController contrl = new LoginController();
		Employee epass = contrl.getEmployee();
		
	 	@FXML
	    public JFXButton PersonalInfo;
	 
	    @FXML
	    private JFXTextField MaritalStatus;
	    
	    @FXML
	    private JFXTextField Marital_Status_EDIT;
	    
	    @FXML
	    public JFXButton CONTACT;

	    @FXML
	    public JFXButton ADDRESS;

	    @FXML
	    public JFXButton OFFICE;

	    @FXML
	    public JFXButton PAYROLL;

	    @FXML
	    public JFXButton ASSETS;

	    @FXML
	    public JFXButton EDUCATIONAL;

	    @FXML
	    public Pane TitlePane;

	    @FXML
	    public Text Title;

	    @FXML
	    public JFXButton CLOSE;

	    @FXML
	    public Text Breadcrumb;

	    @FXML
	    public JFXTextField FNAME;

	    @FXML
	    public JFXTextField MNAME;

	    @FXML
	    public JFXTextField LNAME;

	    @FXML
	    public JFXDatePicker DOB;

	    @FXML
	    public JFXTextField SSN;

	    @FXML
	    public JFXTextField MAJOR;

	    @FXML
	    public JFXTextField EDUCATION;

	    @FXML
	    public JFXButton SAVE;
	    
	    @FXML
	    public Pane mainPane;
	    
	    @FXML
	    public FontAwesomeIconView UserIcon;

	    @FXML
	    public Text welcomeTitle;
	    
	    @FXML
	    public JFXTextField FNAME_EDIT;

	    @FXML
	    public JFXTextField MNAME_EDIT;

	    @FXML
	    public JFXTextField LNAME_EDIT;

	    @FXML
	    public JFXDatePicker DOB_EDIT;

	    @FXML
	    public JFXTextField SSN_EDIT;

	    @FXML
	    public JFXTextField MAJOR_EDIT;

	    @FXML
	    public JFXTextField EDUCATION_EDIT;

	    
	    @FXML
	    public JFXButton Cancel_btn;

	    @FXML
	    public JFXButton Edit_btn;
	    

	    @FXML
	    private Label Mobile;

	    @FXML
	    private Label Landline;

	    @FXML
	    private Label Email;

	    @FXML
	    private JFXTextField Mobile_Edit;

	    @FXML
	    private JFXTextField Landline_Edit;

	    @FXML
	    private JFXTextField Email_Edit;

	    @FXML
	    private JFXButton Cancel_Cancel_btn;

	    @FXML
	    private JFXButton SAVE_Contact;
	    @FXML
	    private JFXButton Edit_Contact_btn;
	    
	    
	    
	    
	    @FXML
	    private JFXButton Cancel_Address_btn;

	    @FXML
	    private JFXButton Edit_Address_btn;
	    

	    @FXML
	    private Label Address_edit_label;

	    @FXML
	    private JFXTextField Address_edit;

	    @FXML
	    private JFXButton SAVE_Address;
	    
	    
	    
	    
	    @FXML
	    private JFXButton Cancel_Office_btn;

	    @FXML
	    private JFXButton Edit_Office_btn;

	    
	    
	    
    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    
    
    
    @FXML
    void DisplayAEdit(ActionEvent event) {

    }
    @FXML
    void CancelAinfo(ActionEvent event) {

    }
    
    
    @FXML
    void CancelCinfo(ActionEvent event) {

    }
    
    @FXML
    void DisplayCEdit(ActionEvent event) {

    }
    
    
    
    @FXML
    void CancelOinfo(ActionEvent event) {

    }


    
    
    
    @FXML
    void EditCInfo(ActionEvent event) throws IOException {
    	
    	if(event.getSource() == Edit_Contact_btn)
    	{
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/ContactEdit.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    	
    }
    
    @FXML
    void EditAInfo(ActionEvent event) throws IOException {
    	
    	if(event.getSource() == Edit_Address_btn)
    	{
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddressEdit.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}

    }
    
    @FXML
    void EditOInfo(ActionEvent event) throws IOException {
    	if(event.getSource() == Edit_Office_btn)
    	{
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/OfficeEdit.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}

    }
    
    @FXML
    void handleClicks(ActionEvent event) throws IOException {
    	if(event.getSource() == PersonalInfo)
    	{
    		mainPane.getChildren().clear();
    		UserIcon.setVisible(false);
    		welcomeTitle.setVisible(false);
    		Title.setText("PERSONAL INFORMATION of "+epass.getEMP_ID());
    		Title.setStyle("-fx-font-size:36px");
    		TitlePane.setStyle("-fx-background-color:#4250EB");
    		Breadcrumb.setText("/HOME/PERSONALINFO");
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/PersonalInfo.fxml"));
    		
    	    mainPane.getChildren().add(fxmlLoader.load());
    	    
    	  
        	
    	}
    	else if(event.getSource() == CONTACT)
    	{
    		mainPane.getChildren().clear();
    		UserIcon.setVisible(false);
    		welcomeTitle.setVisible(false);
    		Title.setText("CONTACT");
    		Title.setStyle("-fx-font-size:36px");
    		TitlePane.setStyle("-fx-background-color:#4250EB");
    		Breadcrumb.setText("/HOME/CONTACT");
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
    		welcomeTitle.setVisible(false);
    		Title.setText("CONTACT");
    		Title.setStyle("-fx-font-size:36px");
    		TitlePane.setStyle("-fx-background-color:#4250EB");
    		Breadcrumb.setText("/HOME/ADDRESS");
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddressInfo.fxml"));
    		mainPane.getChildren().add(fxmlLoader.load());
    	}
    	else if(event.getSource() == OFFICE)
    	{
    		mainPane.getChildren().clear();
    		UserIcon.setVisible(false);
    		welcomeTitle.setVisible(false);
    		Title.setText("OFFICE");
    		Title.setStyle("-fx-font-size:36px");
    		TitlePane.setStyle("-fx-background-color:#4250EB");
    		Breadcrumb.setText("/HOME/CONTACT");
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/OfficeInfo.fxml"));
    		mainPane.getChildren().add(fxmlLoader.load());
    	}
    	else if(event.getSource() == PAYROLL)
    	{
    		mainPane.getChildren().clear();
    		UserIcon.setVisible(false);
    		welcomeTitle.setVisible(false);
    		Title.setText("CONTACT");
    		Title.setStyle("-fx-font-size:36px");
    		TitlePane.setStyle("-fx-background-color:#4250EB");
    		Breadcrumb.setText("/HOME/CONTACT");
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/PayrollInfo.fxml"));
    		mainPane.getChildren().add(fxmlLoader.load());
    	}
    	else if(event.getSource() == ASSETS)
    	{
    		System.out.println("HIIIIIIIIIIIIIIIII");
    	}
    	else if(event.getSource() == EDUCATIONAL)
    	{
    		System.out.println("HIIIIIIIIIIIIIIIII");
    	}
    }
}
