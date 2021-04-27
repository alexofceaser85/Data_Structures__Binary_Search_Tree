package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import data.filepaths.FilePaths;
import data.io.InitialAnimalGuessesParser;
import data.io.LoadBinaryTree;
import data.io.SaveBinaryTree;
import enums.NodeType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import viewmodel.InitialAnimalGuessViewModel;

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
    void loadFile(ActionEvent event) {
    	try {
        	FileChooser chooser = new FileChooser(); 
        	chooser.setTitle("Load File");
        	chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
        	Window stage = this.startMenuPane.getScene().getWindow();
        	File theFile = chooser.showOpenDialog(stage);

        	LoadBinaryTree loadTree = new LoadBinaryTree();
        	this.theBinaryTree = loadTree.loadBinaryTree(theFile);
        	
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
        	FileChooser chooser = new FileChooser(); 
        	chooser.setTitle("Save File");
        	chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
        	Window stage = this.startMenuPane.getScene().getWindow();
        	File theFile = chooser.showSaveDialog(stage);

        	SaveBinaryTree saveTree = new SaveBinaryTree();
        	saveTree.saveFile(theFile, theBinaryTree);
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
    	try {
    		if (this.theBinaryTree.getCurrentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode().getNodeType().equals(NodeType.ANSWER)) {
    			this.theBinaryTree.setRootNode(new AnswerNode(this.getInitialNode(), NodeType.ANSWER));
    			this.switchToWinningScreen(actionEvent);
    		} else {
        		this.theBinaryTree.setCurrentNode(this.theBinaryTree.getRootNode());
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        		
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Question.fxml"));
        		Parent root = (Parent) loader.load();
        		QuestionCodeBehind controller = loader.<QuestionCodeBehind>getController();
        		
        		controller.setViewModel(this.theBinaryTree);
        		
        		Scene theScene = new Scene(root);
                primaryStage.setScene(theScene);

                primaryStage.show();
    		}
    	} catch (IOException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Question GUI load error");
    		alert.setTitle("Load Error");
    		alert.showAndWait();
    	}
    }
    
    private String getInitialNode() {
    	try {
    		InitialAnimalGuessesParser theParser = new InitialAnimalGuessesParser();
			theParser.parseFile(FilePaths.RANDOM_GUESS_FILE);
			ArrayList<String> theAnimalDictionary = theParser.getGuesses();
			
			InitialAnimalGuessViewModel theInitalGuesses = new InitialAnimalGuessViewModel(theAnimalDictionary);
			return theInitalGuesses.pickRandom(0, theAnimalDictionary.size());
		} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle("Error loading file");
    		cannotFindAnimalGuessAlert.setContentText("Could not load the inital animal guesses file");
        	cannotFindAnimalGuessAlert.showAndWait();
        	return "Could not find animal";
		}
    }
    
    private void switchToWinningScreen(ActionEvent actionEvent) {
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
    		this.switchToHumanWins(actionEvent);
    	}
    }
    
    private void switchToHumanWins(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HumanWins.fxml"));
    		Parent root = (Parent) loader.load();
    		HumanWinsCodeBehind controller = loader.<HumanWinsCodeBehind>getController();
    		controller.setViewModel(this.theBinaryTree);
    		
    		Scene theScene = new Scene(root);
            primaryStage.setScene(theScene);

            primaryStage.show();
    	} catch (IOException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Human Wins GUI load error");
    		alert.setTitle("Load Error");
    		alert.showAndWait();
    	}
    }

}