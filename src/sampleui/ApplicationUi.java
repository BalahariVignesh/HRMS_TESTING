package sampleui;

import org.planning.test.jdbc.TestDao;
import org.planning.test.jdbc.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationUi {
	

    @FXML
    private JFXButton submit_button;

    @FXML
    private JFXTextField message1;

    @FXML
    private JFXTextField message2;

    @FXML
    void Display(ActionEvent event) {
    	Employee e = new Employee();
    	TestDao t = new TestDao();
    	if(event.getSource() == submit_button)
    	{
    	System.out.println(message2.getText());
    	e.setLNAME(message2.getText());
    	Employee eReceived = t.fetchEmployeePersonalDetails(e);
    	message1.setText(eReceived.getFNAME());
    	System.out.println("Lname is "+eReceived.getFNAME());
    	}
    	e.setFNAME(message1.getText());
    	//e.setMNAME(message2.getText());
    	//System.out.println("Lname is"+e.getMNAME());
    	
    	
    	
    	
        //System.out.println(message1.getText());
        //System.out.println(message2.getText());

    }

    
}
