package verticalMenuPersonalInfo;

import java.io.IOException;
import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginController.LoginController;


public class SearchEmployeePage {    
	
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
    @FXML
    private JFXButton CLOSE;

    @FXML
    private JFXTextField EmployeeId;

    @FXML
    private JFXTextField FirstName;

    @FXML
    private JFXTextField LastName;

    @FXML
    private JFXTextField Branch;

    @FXML
    private JFXTextField Status;

    @FXML
    private JFXTextField Project;

    @FXML
    private JFXButton SearchEmployee;

    @FXML
    private TableView<Employee> EmployeeSearchList = new TableView<Employee>();

    @FXML
    private TableColumn<Employee, Integer> EmployeeIdCol = new TableColumn<Employee, Integer>("EMP ID");

    @FXML
    private TableColumn<Employee, String> FirstNameCol = new TableColumn<Employee, String>("First Name");

    @FXML
    private TableColumn<Employee, String> LastNameCol = new TableColumn<Employee, String>("Last Name");

    @FXML
    private TableColumn<Employee, String> BranchCol = new TableColumn<Employee, String>("Branch");

    @FXML
    private TableColumn<Employee, String> StatusCol = new TableColumn<Employee, String>("Status");

    @FXML
    private TableColumn<Employee, Integer> ProjectCol = new TableColumn<Employee, Integer>("Project");

    @FXML
    private TableColumn<?, ?> ManagerCol;

    @FXML
    private TableColumn<?, ?> LevelCol;

    @FXML
    void CloseWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) CLOSE.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void SearchEmployee(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    	epass.setSearchParam(FirstName.getText());
    	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/verticalMenuPersonalInfo/EmployeeList.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setScene(new Scene(root1));  
	    stage.show();
	    
		//StackPane root = new StackPane();
	    
	    //Stage stage = new Stage();
	    //Scene scene = new Scene(root, 450, 300);
	    //stage.setScene(scene);
	    //stage.show();
    }
    
	public void start(Stage stage) throws ClassNotFoundException, SQLException {
    	TableView<Employee> table = new TableView<Employee>();
    	EmployeeIdCol.setCellValueFactory(new PropertyValueFactory<>("EMP_ID"));
    	FirstNameCol.setCellValueFactory(new PropertyValueFactory<>("FNAME"));
    	LastNameCol.setCellValueFactory(new PropertyValueFactory<>("LNAME"));
    	BranchCol.setCellValueFactory(new PropertyValueFactory<>("C_Branch"));
    	StatusCol.setCellValueFactory(new PropertyValueFactory<>("C_STATUS"));
    	ProjectCol.setCellValueFactory(new PropertyValueFactory<>("C_PROJ"));
    	
    	FirstNameCol.setSortType(TableColumn.SortType.ASCENDING);
		TestDao t = new TestDao();
		System.out.println(FirstName.getText());
		ObservableList<Employee> emplist = t.getEmpListSearchFname(FirstName.getText());
		EmployeeSearchList.setItems(emplist);
		EmployeeSearchList.getColumns().addAll(EmployeeIdCol,FirstNameCol,LastNameCol,BranchCol,StatusCol,ProjectCol);
		StackPane root = new StackPane();
	      root.setPadding(new Insets(5));
	      root.getChildren().add(table);
	 
	      stage.setTitle("TableView (Testing)");
	 
	      Scene scene = new Scene(root, 450, 300);
	      stage.setScene(scene);
	      stage.show();
    }
    
}
