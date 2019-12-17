package verticalMenuPersonalInfo;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import loginController.LoginController;

public class EmployeeListController {
	private final LoginController contrl = new LoginController();
	Employee epass = contrl.getEmployee();
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
    private TableColumn<Employee, String> UpdateBtn;
    
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
    private void initialize() throws ClassNotFoundException, SQLException {
    TableView<Employee> table = new TableView<Employee>();
	EmployeeIdCol.setCellValueFactory(new PropertyValueFactory<>("EMP_ID"));
	FirstNameCol.setCellValueFactory(new PropertyValueFactory<>("FNAME"));
	LastNameCol.setCellValueFactory(new PropertyValueFactory<>("LNAME"));
	BranchCol.setCellValueFactory(new PropertyValueFactory<>("C_Branch"));
	StatusCol.setCellValueFactory(new PropertyValueFactory<>("C_STATUS"));
	ProjectCol.setCellValueFactory(new PropertyValueFactory<>("C_PROJ"));
	
	FirstNameCol.setSortType(TableColumn.SortType.ASCENDING);
	TestDao t = new TestDao();
	//System.out.println(FirstName.getText());
	ObservableList<Employee> emplist = t.getEmpListSearchFname(epass.getSearchParam());
	EmployeeSearchList.setItems(emplist);
	EmployeeSearchList.getColumns().addAll(EmployeeIdCol,FirstNameCol,LastNameCol,BranchCol,StatusCol,ProjectCol);
	StackPane root = new StackPane();
      root.setPadding(new Insets(5));
      root.getChildren().add(table);
 
//      stage.setTitle("TableView (Testing)");
// 
//      Scene scene = new Scene(root, 450, 300);
//      stage.setScene(scene);
//      stage.show();
    	
    }
}
