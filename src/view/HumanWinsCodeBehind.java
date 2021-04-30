package view;

import java.io.File;
import java.io.FileNotFoundException;

import enums.NodeType;
import errormessages.ErrorMessages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import viewmodel.BinaryTreeViewModel;
import viewmodel.LoadBinaryTreeViewModel;
import viewmodel.SaveBinaryTreeViewModel;

/**
 * The code behind for the human wins screen
 * 
 * @author Alex DeCesare
 * @version 20-April-2021
 */

public class HumanWinsCodeBehind {

    @FXML
    private TextField answerTextField;

    @FXML
    private TextField questionTextField;

    @FXML
    private RadioButton distinguishQuestionYes;

    @FXML
    private ToggleGroup distinguishAnswer;

    @FXML
    private RadioButton distinguishQuestionNo;

    @FXML
    private Button submitButton;
    
    @FXML
    private MenuItem saveFileButton;

    @FXML
    private MenuItem loadFileButton;

    @FXML
    private AnchorPane mainPane;
    
    private BinaryTreeViewModel binaryTreeViewModel;
    private final String errorSavingFile = "There was an error saving your file";
    private final String errorLoadingFile = "There was an error loading your file";
    private final String errorAddingAnimal = "There was an error adding your animal";
    
    /**
     * Sets the view model for the code behind
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param viewModelToSet the view model to set
     */
    
    public void setViewModel(BinaryTreeViewModel viewModelToSet) {
    	this.binaryTreeViewModel = viewModelToSet;
    }
    
    @FXML
    void submitAnimal(ActionEvent event) {
    	try {
    		if (!this.distinguishQuestionYes.isSelected() && !this.distinguishQuestionNo.isSelected()) {
    			throw new IllegalArgumentException(ErrorMessages.CANNOT_ADD_NEW_NODE_WITHOUT_SELECTING_NODE_SIZE);
    		} else {
        		this.binaryTreeViewModel.insertNode(this.questionTextField.getText(), this.answerTextField.getText(), NodeType.QUESTION, this.distinguishQuestionYes.isSelected());
            	this.switchToStart(event);
    		}
    	} catch (IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(e.getMessage());
    		alert.setTitle(this.errorAddingAnimal);
    		alert.showAndWait();
    	}
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
    		cannotFindAnimalGuessAlert.setTitle(this.errorLoadingFile);
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle(this.errorLoadingFile);
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
    		cannotFindAnimalGuessAlert.setTitle(this.errorSavingFile);
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	} catch (FileNotFoundException e) {
    		Alert cannotFindAnimalGuessAlert = new Alert(AlertType.INFORMATION);
    		cannotFindAnimalGuessAlert.setTitle(this.errorSavingFile);
    		cannotFindAnimalGuessAlert.setContentText(e.getMessage());
        	cannotFindAnimalGuessAlert.showAndWait();
    	}
    }
    
    private void switchToStart(ActionEvent actionEvent) {
    	WindowManager windowManager = new WindowManager(this.binaryTreeViewModel);
    	windowManager.switchToStart(actionEvent);
    }
}
