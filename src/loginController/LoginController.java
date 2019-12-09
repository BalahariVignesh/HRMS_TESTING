package loginController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.*;
public class LoginController {
	static Employee epass = new Employee();
	//static int passint;
	public Employee getEmployee() {
		return epass;
	}

    @FXML
    private Pane LoginMainPane;
    
    @FXML
    private JFXTextField loginField;


    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private Button login_Submit_Btn;

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
    void Login(ActionEvent event) throws SQLException, IOException {
    	if (loginField.getText().isEmpty() && passwordField.getText().isEmpty()) 
    	{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginController/LoginAndPassword.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    	else if (loginField.getText().isEmpty()| (loginField.getText().isEmpty() && !loginField.getText().isEmpty())) 
    	{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginController/Login.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    	else  if (passwordField.getText().isEmpty()) 
    	{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginController/Password.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    	Employee e = new Employee();
    	TestDao t = new TestDao();
    	e.setEMP_ID(Integer.parseInt(loginField.getText()));
    	e.setPWD(passwordField.getText());
    	Employee enew = t.login(e);
//    	Access type ID		
//    	AC_HR	HR
//    	AC_PMO	PMO
//    	AC_EMP	Employee
    	System.out.println(enew.getLogin()+enew.getACC_type());
    	String acctype = enew.getACC_type();
    	
    	if(enew.getLogin()) {
    		
    		epass.setEMP_ID(enew.getEMP_ID());
    		
    		if(acctype.equals("AC_HR"))
        	{
        		System.out.println("Logged in as HR");
        		Stage stage = (Stage) CLOSE.getScene().getWindow();
        		System.out.println("flag");
               	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/HrManagerPages/HrManagerAndEmployeePage.fxml"));
               	System.out.println("flag2");
        	    Parent root1 = (Parent) fxmlLoader.load();
        	    System.out.println("flag3");
        	    Stage stagelocal = new Stage();
        	    System.out.println("flag4");
        	    stagelocal.initModality(Modality.APPLICATION_MODAL);
        	    System.out.println("flag5");
        	    stagelocal.initStyle(StageStyle.UNDECORATED);
        	    System.out.println("flag6");
        	    stagelocal.setScene(new Scene(root1));
        	    System.out.println("flag7");
        	    stagelocal.show();
        	    System.out.println("flag8");
        	    stage.close();
        	}
        	else if(acctype.equals("AC_PMO"))
        	{
        		System.out.println("Logged in as PMO");
        	}
        	else if(acctype.equals("AC_EMP"))
        	{
        		Stage stage = (Stage) CLOSE.getScene().getWindow();
                System.out.println("Logged in as Employee");
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/VerticalMenu.fxml"));
        	    Parent root1 = (Parent) fxmlLoader.load();
        	    Stage stagelocal = new Stage();
        	    stagelocal.initModality(Modality.APPLICATION_MODAL);
        	    stagelocal.initStyle(StageStyle.UNDECORATED);
        	    stagelocal.setScene(new Scene(root1));  
        	    stagelocal.show();
        	    stage.close();
        	}
    	}
    	else
    	{
    		System.out.println("Login Failed");
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginController/LoginFailed.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.initStyle(StageStyle.UNDECORATED);
    	    stage.setScene(new Scene(root1));  
    	    stage.show();
    	}
    }
   
}
