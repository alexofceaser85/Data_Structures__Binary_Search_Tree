package view;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;

public class StartMenuCodeBehind {

    @FXML
    private AnchorPane startMenuPane;

    @FXML
    private MenuItem saveMenuButton;

    @FXML
    private MenuItem loadMenuButton;

    @FXML
    private Button playButton;
    
    private Scene firstScene;

    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }
    
    public StartMenuCodeBehind() {
    	
    }
    
    @FXML
    public void switchToQuestion(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    		URL theURL = super.getClass().getResource("/view/Question.fxml");
    		
    		AnchorPane thePane = FXMLLoader.load(theURL);
    			
    		Scene theScene = new Scene(thePane);
            primaryStage.setScene(theScene);

            primaryStage.show();
    	} catch (IOException e) {
    		
    	}
    }

}