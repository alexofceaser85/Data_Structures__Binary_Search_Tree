package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

import enums.NodeType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import viewmodel.BinaryTreeViewModel;
import viewmodel.LoadBinaryTreeViewModel;
import viewmodel.SaveBinaryTreeViewModel;

/**
 * The code behind for the question screen
 * 
 * @author Alex DeCesare
 * @version 20-April-2021
 */

public class QuestionCodeBehind {

    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;

    @FXML
    private Label questionLabel;

    @FXML
    private AnchorPane mainPane;
    
    private BinaryTreeViewModel binaryTreeViewModel;
    
    /**
     * The constructor for the question code behind
     * 
     * @precondition none
     * @postcondition none
     */
    
    public QuestionCodeBehind() {

    }
    
    /**
     * Sets the view model of the question code behind
     * 
     * @precondition none
     * @postcondition this.binaryTreeViewModel == viewModelToSet
     * 
     * @param viewModelToSet the view model to set for the code behind
     */
    
    public void setViewModel(BinaryTreeViewModel viewModelToSet) {
    	this.binaryTreeViewModel = viewModelToSet;
    	this.updateGUI();
    }
    
    @FXML
    void loadFile(ActionEvent event) {
    	try {
    		WindowManager windowManager = new WindowManager(this.binaryTreeViewModel);
    		File theFile = windowManager.showLoadFile(this.mainPane);

    		LoadBinaryTreeViewModel loadTree = new LoadBinaryTreeViewModel();
        	this.binaryTreeViewModel = loadTree.loadBinaryTree(theFile);
        	
        	windowManager = new WindowManager(this.binaryTreeViewModel);
        	windowManager.switchToQuestion(event, (Stage) ((Node) this.mainPane).getScene().getWindow());
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
        	WindowManager windowManager = new WindowManager(this.binaryTreeViewModel);
        	File theFile = windowManager.showSaveFile(this.mainPane);
        	
        	SaveBinaryTreeViewModel saveTree = new SaveBinaryTreeViewModel();
			saveTree.saveFile(theFile, this.binaryTreeViewModel);
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
    
    @FXML
    void traverseLeft(ActionEvent event) {
    	try {
        	if (this.binaryTreeViewModel.traverseToLeftChild() && this.binaryTreeViewModel.getCurrentNode().getNodeType().equals(NodeType.QUESTION)) {
        		this.updateGUI();
        	} else {
        		this.switchToWinningScreen(event);
        	}
    	} catch (IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(e.getMessage());
    		alert.setTitle("Could Not Traverse Left");
    		alert.showAndWait();
    	}
    }

    @FXML
    void traverseRight(ActionEvent event) {
    	try {
        	if (this.binaryTreeViewModel.traverseToRightChild() && this.binaryTreeViewModel.getCurrentNode().getNodeType().equals(NodeType.QUESTION)) {
        		this.updateGUI();
        	} else {
        		this.switchToWinningScreen(event);
        	}
    	} catch (IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(e.getMessage());
    		alert.setTitle("Could Not Traverse Right");
    		alert.showAndWait();
    	}
    }
    
    private void switchToWinningScreen(ActionEvent actionEvent) {
    	WindowManager windowManager = new WindowManager(this.binaryTreeViewModel);
    	Alert alert = 
    	        new Alert(AlertType.INFORMATION, 
    	             "Is your animal a: " + this.binaryTreeViewModel.getCurrentNode().getNodeValue(),
    	             ButtonType.YES, 
    	             ButtonType.NO);
    	alert.setTitle("The computers guess is this: ");
    	Optional<ButtonType> result = alert.showAndWait();

    	if (result.get() == ButtonType.YES) {
    		Alert computerWinsAlert = new Alert(AlertType.INFORMATION);
    		computerWinsAlert.setTitle("The computers guess is this: ");
    		computerWinsAlert.setContentText("The computer correctly guessed your animal");
        	computerWinsAlert.showAndWait();
    		windowManager.switchToStart(actionEvent);
    	} else {
    		windowManager.switchToHumanWins(actionEvent);
    	}
    }
    
    private void updateGUI() {
    	this.questionLabel.setText(this.binaryTreeViewModel.getCurrentNode().getNodeValue());
    }
}