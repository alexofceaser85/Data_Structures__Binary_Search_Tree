package view;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import viewmodel.BinaryTreeViewModel;

/**
 * This class manages the windows and window switching for the application
 * 
 * @author Alex DeCesare
 * @version 30-April-2021
 */

public class WindowManager {

	private BinaryTreeViewModel binaryTreeViewModel;
	private final String guiLoadErrorTitle = "GUI load error";
	private final String startGuiLoadError = "Start Menu GUI load error";
	private final String humanWinsLoadError = "Human Wins GUI load error";
	private final String questionLoadError = "Question GUI load error";
	
	/**
	 * The constructor for the window manager
	 * 
	 * @precondition BinaryTreeViewModel != null
	 * @postcondition this.binaryTreeViewModel == binaryTreeViewModel 
	 * 
	 * @param binaryTreeViewModel the binary tree view model
	 */
	
	public WindowManager(BinaryTreeViewModel binaryTreeViewModel) {
		this.binaryTreeViewModel = binaryTreeViewModel;
	}
	
	/**
	 * Switches the window to the start window
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param actionEvent the event to switch for
	 */
	
    public void switchToStart(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartMenu.fxml"));
    		Parent root = (Parent) loader.load();
    		StartMenuCodeBehind controller = loader.<StartMenuCodeBehind>getController();
    		controller.setViewModel(this.binaryTreeViewModel);
    		
    		Scene theScene = new Scene(root);
            primaryStage.setScene(theScene);

            primaryStage.show();
    	} catch (IOException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(this.startGuiLoadError);
    		alert.setTitle(this.guiLoadErrorTitle);
    		alert.showAndWait();
    	}
    }
    
    /**
     * Switches the window to the human wins window
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param actionEvent the event to switch for
     */
    
    public void switchToHumanWins(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HumanWins.fxml"));
    		Parent root = (Parent) loader.load();
    		HumanWinsCodeBehind controller = loader.<HumanWinsCodeBehind>getController();
    		controller.setViewModel(this.binaryTreeViewModel);
    		
    		Scene theScene = new Scene(root);
            primaryStage.setScene(theScene);

            primaryStage.show();
    	} catch (IOException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(this.humanWinsLoadError);
    		alert.setTitle(this.guiLoadErrorTitle);
    		alert.showAndWait();
    	}
    }
    
    /**
     * Switches the window to the question window
     * 
     * @precondition none
     * @postcondition none
     * 
	 * @param actionEvent the event to switch for
	 * @param stage the stage to switch
     */
 
    public void switchToQuestion(ActionEvent actionEvent, Stage stage) {
    	try {
            Stage primaryStage = stage;
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Question.fxml"));
    		Parent root = (Parent) loader.load();
    		QuestionCodeBehind controller = loader.<QuestionCodeBehind>getController();
    		
    		controller.setViewModel(this.binaryTreeViewModel);
    		
    		Scene theScene = new Scene(root);
            primaryStage.setScene(theScene);

            primaryStage.show();
    	} catch (IOException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(this.questionLoadError);
    		alert.setTitle(this.guiLoadErrorTitle);
    		alert.showAndWait();
    	}
    }
    
    /**
     * Shows the load file chooser
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param startMenuPane the pane to get the window from
     * 
     * @return theFile the chosen file
     */
    
    public File showLoadFile(Pane startMenuPane) {
    	FileChooser chooser = new FileChooser(); 
		chooser.setTitle("Load File");
		chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		Window stage = startMenuPane.getScene().getWindow();
		File theFile = chooser.showOpenDialog(stage);
		return theFile;
    }
    
    /**
     * Shows the save file chooser
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param startMenuPane the pane to get the window from
     * 
     * @return theFile the chosen file
     */
	
    public File showSaveFile(Pane startMenuPane) {
    	FileChooser chooser = new FileChooser(); 
    	chooser.setTitle("Save File");
    	chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
    	Window stage = startMenuPane.getScene().getWindow();
    	File theFile = chooser.showSaveDialog(stage);
    	return theFile;
    }
}
