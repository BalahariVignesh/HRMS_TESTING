package HrManagerPages;

import java.sql.SQLException;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeListController {

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
    private TableView<Employee> EmployeeSearchList = new TableView<Employee>();
    
    @FXML
   private void initialize() throws ClassNotFoundException, SQLException {
    	TableView<Employee> table = new TableView<Employee>();
//		TableColumn<Employee, Integer> empidcol = new TableColumn<Employee, Integer>("EMP ID");
//		TableColumn<Employee, String> fnamecol = new TableColumn<Employee, String>("First Name");
//		TableColumn<Employee, String> lnamecol = new TableColumn<Employee, String>("Last Name");
//		TableColumn<Employee, String> branchcol = new TableColumn<Employee, String>("Branch");
//		TableColumn<Employee, String> statuscol = new TableColumn<Employee, String>("Status");
//		TableColumn<Employee, Integer> projectcol = new TableColumn<Employee, Integer>("Project");
    	EmployeeIdCol.setCellValueFactory(new PropertyValueFactory<>("EMP_ID"));
    	FirstNameCol.setCellValueFactory(new PropertyValueFactory<>("FNAME"));
    	LastNameCol.setCellValueFactory(new PropertyValueFactory<>("LNAME"));
    	BranchCol.setCellValueFactory(new PropertyValueFactory<>("C_Branch"));
    	StatusCol.setCellValueFactory(new PropertyValueFactory<>("C_STATUS"));
    	ProjectCol.setCellValueFactory(new PropertyValueFactory<>("C_PROJ"));
    	
    	FirstNameCol.setSortType(TableColumn.SortType.ASCENDING);
		TestDao t = new TestDao();
		ObservableList<Employee> emplist = t.getEmpListSearchFname("First");
		EmployeeSearchList.setItems(emplist);
		EmployeeSearchList.getColumns().addAll(EmployeeIdCol,FirstNameCol,LastNameCol,BranchCol,StatusCol,ProjectCol);
//    	EmployeeId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
//    	FirstName.setCellFactory(cellData -> cellData.getValue().getfnameProperty());
//    	LastName.setCellFactory(cellData -> cellData.getValue().getlnameProperty());
//    	Branch.setCellFactory(cellData -> cellData.getValue().getbranchProperty());
//    	Status.setCellFactory(cellData -> cellData.getValue().getstatusProperty());
//    	Project.setCellFactory(cellData -> cellData.getValue().getprojectProperty());
//    	ObservableList<Employee> emplist = TestDao.get
    	
   }
}
