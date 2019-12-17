package org.planning.test.jdbc;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.SQLException;

import org.planning.test.jdbc.*;

 
public class TableEmpTest extends Application {
	@Override
	public void start(Stage stage) throws ClassNotFoundException, SQLException {
		TableView<Employee> table = new TableView<Employee>();
		TableColumn<Employee, Integer> empidcol = new TableColumn<Employee, Integer>("EMP ID");
		TableColumn<Employee, String> fnamecol = new TableColumn<Employee, String>("First Name");
		TableColumn<Employee, String> lnamecol = new TableColumn<Employee, String>("Last Name");
		TableColumn<Employee, String> branchcol = new TableColumn<Employee, String>("Branch");
		TableColumn<Employee, String> statuscol = new TableColumn<Employee, String>("Status");
		TableColumn<Employee, Integer> projectcol = new TableColumn<Employee, Integer>("Project");
		//TableColumn<EmployeeTable, String> updatecol = new TableColumn<EmployeeTable, String>("Status");
		
		empidcol.setCellValueFactory(new PropertyValueFactory<>("EMP_ID"));
		fnamecol.setCellValueFactory(new PropertyValueFactory<>("FNAME"));
		lnamecol.setCellValueFactory(new PropertyValueFactory<>("LNAME"));
		branchcol.setCellValueFactory(new PropertyValueFactory<>("C_Branch"));
		statuscol.setCellValueFactory(new PropertyValueFactory<>("C_STATUS"));
		projectcol.setCellValueFactory(new PropertyValueFactory<>("C_PROJ"));
		//updatecol.setCellValueFactory(new PropertyValueFactory<>(""))
		fnamecol.setSortType(TableColumn.SortType.DESCENDING);
		TestDao t = new TestDao();
		ObservableList<Employee> emplist = t.getEmpListSearchFname("First");
		table.setItems(emplist);
		
		table.getColumns().addAll(empidcol, fnamecol, lnamecol, branchcol, statuscol, projectcol);
		
		 StackPane root = new StackPane();
	      root.setPadding(new Insets(5));
	      root.getChildren().add(table);
	 
	      stage.setTitle("TableView (Testing)");
	 
	      Scene scene = new Scene(root, 450, 300);
	      stage.setScene(scene);
	      stage.show();
	  
	}
//	private ObservableList<EmployeeTable> getEmpList(){
//		
//		
//		EmployeeTable e1 = new EmployeeTable(1,"Bala","Hari");
//		EmployeeTable e2 = new EmployeeTable(2,"Hari","Vignesh");
//		
//		ObservableList<EmployeeTable> emplist = FXCollections.observableArrayList(e1,e2);
//		//emplist.add(e)
//		return emplist;
//	}
	public static void main(String[] args) {
		launch(args);
	}
}