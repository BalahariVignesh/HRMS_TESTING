package verticalMenuPersonalInfo;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HrOperationsController {
	
    @FXML
    private JFXButton AddEmployee_Btn;

    @FXML
    private JFXButton UpdateEmployee_Btn;
    
    @FXML
    void AddEmployeeData(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AddNewEmployeePage.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }

    @FXML
    void UdpdateEmployeeData(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/SearchEmployee.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }

    @FXML
    void ViewEmployeeData(ActionEvent event) {

    }

}
