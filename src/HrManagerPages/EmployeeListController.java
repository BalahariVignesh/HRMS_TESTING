package HrManagerPages;

import org.planning.test.jdbc.Employee;
import org.planning.test.jdbc.TestDao;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmployeeListController {

    @FXML
    private TableColumn<Employee, Integer> EmployeeId;

    @FXML
    private TableColumn<Employee, String> FirstName;

    @FXML
    private TableColumn<Employee, String> LastName;

    @FXML
    private TableColumn<Employee, String> Branch;

    @FXML
    private TableColumn<Employee, String> Status;

    @FXML
    private TableColumn<Employee, String> Project;

    @FXML
    private TableColumn<Employee, String> UpdateBtn;
    
    @FXML
    private TableView EmployeeSearchList;
    
//    @FXML
//    private void iniialize() {
//    	EmployeeId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
//    	FirstName.setCellFactory(cellData -> cellData.getValue().getfnameProperty());
//    	LastName.setCellFactory(cellData -> cellData.getValue().getlnameProperty());
//    	Branch.setCellFactory(cellData -> cellData.getValue().getbranchProperty());
//    	Status.setCellFactory(cellData -> cellData.getValue().getstatusProperty());
//    	Project.setCellFactory(cellData -> cellData.getValue().getprojectProperty());
//    	ObservableList<Employee> emplist = TestDao.get
    	
//    }
}
