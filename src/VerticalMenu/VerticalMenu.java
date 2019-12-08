package VerticalMenu;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VerticalMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
    	try
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("/verticalMenuPersonalInfo/VerticalMenu.fxml"));
    	   	Scene scene = new Scene(root);
    	   	primaryStage.initStyle(StageStyle.UNDECORATED);
    	   	primaryStage.setScene(scene);
    	   	primaryStage.show();
    	}
    	catch(IOException ex) {
        	System.out.println(ex);
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }

}