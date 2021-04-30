package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import data.filepaths.FilePaths;
import enums.NodeType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import viewmodel.InitialAnimalGuessViewModel;
import viewmodel.LoadBinaryTreeViewModel;
import viewmodel.SaveBinaryTreeViewModel;

/**
 * The code behind for the start menu screen
 * 
 * @author Alex DeCesare
 * @version 20-April-2021
 */

public class StartMenuCodeBehind {

    @FXML
    private AnchorPane startMenuPane;

    @FXML
    private MenuItem saveMenuButton;

    @FXML
    private MenuItem loadMenuButton;

    @FXML
    private Button playButton;
    
    private BinaryTreeViewModel theBinaryTree;
    
    /**
     * The constructor for the code behind
     * 
     * @precondition none
     * @postcondition this.theBinaryTree == new BinaryTreeViewModel()
     */
    
    public StartMenuCodeBehind() {
    	this.theBinaryTree = new BinaryTreeViewModel();
    }
    
    /**
     * Sets the view model for the start menu code behind
     * 
     * @precondition none
     * @postcondition this.theBinaryTree == binaryTreeToSet
     * 
     * @param binaryTreeToSet the binary tree view model to set
     */
    
    public void setViewModel(BinaryTreeViewModel binaryTreeToSet) {
    	this.theBinaryTree = binaryTreeToSet;
    }
    
    @FXML
    void loadFile(ActionEvent event) throws IOException {
    	try {
    		WindowManager windowManager = new WindowManager(this.theBinaryTree);
    		File theFile = windowManager.showLoadFile(this.startMenuPane);

        	LoadBinaryTreeViewModel loadTree = new LoadBinaryTreeViewModel();
        	this.theBinaryTree = loadTree.loadBinaryTree(theFile);
        	
        	windowManager = new WindowManager(this.theBinaryTree);
        	windowManager.switchToQuestion(event, (Stage) ((Node) this.startMenuPane).getScene().getWindow());
    	} catch (IllegalArgumentException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error loading file");
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error loading file");
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	}
    }

    @FXML
    void saveFile(ActionEvent event) {
    	try {
    		WindowManager windowManager = new WindowManager(this.theBinaryTree);
        	File theFile = windowManager.showSaveFile(this.startMenuPane);

        	SaveBinaryTreeViewModel saveTree = new SaveBinaryTreeViewModel();
        	saveTree.saveFile(theFile, this.theBinaryTree);
    	} catch (IllegalArgumentException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error saving file");
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error saving file");
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	}
    }
    
    /**
     * Switches to the question screen
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param actionEvent the event
     */
    
    @FXML
    public void switchToQuestion(ActionEvent actionEvent) {
    	WindowManager windowManager = new WindowManager(this.theBinaryTree);
		
		if (this.theBinaryTree.getCurrentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode().getNodeType().equals(NodeType.ANSWER)) {
			this.theBinaryTree.setRootNode(new AnswerNode(this.getInitialNode(), NodeType.ANSWER));
			this.switchToWinningScreen(actionEvent, windowManager);
		} else {
			this.theBinaryTree.setCurrentNode(this.theBinaryTree.getRootNode());
			windowManager.switchToQuestion(actionEvent, (Stage) ((Node) this.startMenuPane).getScene().getWindow());
		}
    }
    
    private String getInitialNode() {
    	try {			
			InitialAnimalGuessViewModel theInitalGuesses = new InitialAnimalGuessViewModel();
			theInitalGuesses.populateAnimalGuesses(FilePaths.RANDOM_GUESS_FILE);
			return theInitalGuesses.pickRandom(0, theInitalGuesses.getAnimalGuesses().size());
		} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error loading file");
    		cannotFindAnimalGuessAlert.setContentText("Could not load the inital animal guesses file");
        	cannotFindAnimalGuessAlert.showAndWait();
        	return "Could not find animal";
		}
    }
    
    private void switchToWinningScreen(ActionEvent actionEvent, WindowManager windowManager) {
    	Alert alert = 
    	        new Alert(AlertType.INFORMATION, 
    	        		"Is your animal a: " + this.theBinaryTree.getCurrentNode().getNodeValue(),
    	             ButtonType.YES, 
    	             ButtonType.NO);
    	alert.setTitle("The computers guess is this: ");
    	Optional<ButtonType> result = alert.showAndWait();

    	if (result.get() == ButtonType.YES) {
    		Alert computerWinsAlert = new Alert(AlertType.INFORMATION);
    		computerWinsAlert.setTitle("The computers guess is this: ");
    		computerWinsAlert.setContentText("The computer correctly guessed your animal");
        	computerWinsAlert.showAndWait();
    	} else {
    		windowManager.switchToHumanWins(actionEvent);
    	}
    }

}