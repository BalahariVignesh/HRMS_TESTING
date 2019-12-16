package HrManagerPages;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class EmployeeListController {

    @FXML
    private TableColumn<?, ?> EmployeeId;

    @FXML
    private TableColumn<?, ?> FirstName;

    @FXML
    private TableColumn<?, ?> LastName;

    @FXML
    private TableColumn<?, ?> Branch;

    @FXML
    private TableColumn<?, ?> Status;

    @FXML
    private TableColumn<?, ?> Project;

    @FXML
    private TableColumn<?, ?> UpdateBtn;
}
