package verticalMenuPersonalInfo;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.Asset;
import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;

public class AssetsInfoController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private JFXTextField SeatNumber;

    @FXML
    private TableColumn<?, ?> AssetNumber;

    @FXML
    private TableColumn<?, ?> AssetType;

    @FXML
    private JFXButton Request_New_Btn;
    
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
    	Employee e = new Employee();
    	System.out.println("Inside Asseet Info Controller"+epass.getEMP_ID());
  	    e.setEMP_ID(epass.getEMP_ID());
  	    TestDao t = new TestDao();
  	    Employee enew = t.fetchAssetInfo(e);
  	    SeatNumber.setText(String.valueOf(enew.getSEAT_NUMBER()));
  	    String[] asset_type=enew.getASSET_TYPE();
  	    int[] asset_id=enew.getASSET_NUMBER();
  	    
  	    TableView tableView = new TableView();

  	    TableColumn<String, Employee> AssetNumber = new TableColumn<>("Asset Type");
  	    AssetNumber.setCellValueFactory(new PropertyValueFactory<>("Asset_type"));


  	    TableColumn<String, Employee> AssetType = new TableColumn<>("Asset ID");
  	    AssetType.setCellValueFactory(new PropertyValueFactory<>("Asset_ID"));


  	    tableView.getColumns().add(AssetNumber);
  	    tableView.getColumns().add(AssetType);

  	    tableView.getItems().add(new Asset("John", 12));
  	    tableView.getItems().add(new Asset("Jane", 23));

  	   
  	    //AssetNumber.setCellFactory(0,0,asset_type[0]);
  	    
  	    //SickLeave.setText(String.valueOf(enew.getS_LEAVE()));
  	 	    	       	
    }

    @FXML
    void RequestNewAsset(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/AssetsAddNew.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
    }

}
