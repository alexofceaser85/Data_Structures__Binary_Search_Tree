package main;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final String VIEW_EVENT_PANE_FXML = "/view/StartMenu.fxml";
	private static final String THE_TITLE = "Alex DeCesare's Project Four";
	private static final String THE_IO_EXCEPTION_TEXT = "Problem opening the view pane file";
	private static final String THE_NUMBER_FORMAT_EXCEPTION_TEXT = "Cannot find the view pane file";

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(THE_TITLE);
		

			
			URL theURL = super.getClass().getResource(VIEW_EVENT_PANE_FXML);
			
			AnchorPane thePane = FXMLLoader.load(theURL);
			
			Scene theScene = new Scene(thePane);

			primaryStage.setScene(theScene);
		
			primaryStage.show();

	}

}
