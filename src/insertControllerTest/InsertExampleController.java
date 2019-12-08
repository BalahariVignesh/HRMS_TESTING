package insertControllerTest;

import org.planning.test.jdbc.TestDao;
import org.planning.test.jdbc.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InsertExampleController {
	

    @FXML
    private JFXButton submit_button;

    @FXML
    private JFXTextField message1;

    @FXML
    private JFXTextField message2;

    @FXML
    void Display(ActionEvent event) {
    	Employee e = new Employee();
    	
    	e.setFNAME(message1.getText());
    	e.setMNAME(message2.getText());
    	TestDao t = new TestDao();
    	t.insertTest(e);
    	
        System.out.println(message1.getText());
        System.out.println(message2.getText());

    }

    
}
