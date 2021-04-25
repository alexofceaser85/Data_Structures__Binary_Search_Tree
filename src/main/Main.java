package main;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The main class of the application
 * 
 * @author Alex DeCesare
 * @version 20-April 2021
 */

public class Main extends Application {
	
	private static final String VIEW_EVENT_PANE_FXML = "/view/StartMenu.fxml";

	/**
	 * The launch method for the application
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args the arguments
	 */
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL theURL = super.getClass().getResource(VIEW_EVENT_PANE_FXML);
		
		AnchorPane thePane = FXMLLoader.load(theURL);
			
		Scene theScene = new Scene(thePane);

		theScene.setRoot(thePane);
		
		primaryStage.setScene(theScene);
		primaryStage.show();
	}

}
