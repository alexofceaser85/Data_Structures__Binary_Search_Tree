package view;

import java.io.IOException;

import enums.NodeType;
import errormessages.ErrorMessages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import viewmodel.BinaryTreeViewModel;

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

    private BinaryTreeViewModel binaryTreeViewModel;
    
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
    		alert.setTitle("There was an error adding your animal");
    		alert.showAndWait();
    	}
    }
    

    @FXML
    void loadFile(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {
    	FileChooser chooser = new FileChooser(); 
    	chooser.setTitle("Save File");
    	chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
    	Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	chooser.showOpenDialog(mainStage);

        HBox root = new HBox();  
        
        root.setSpacing(20);  
      
        Scene scene = new Scene(root, 350, 100);  
        mainStage.setScene(scene);  
        mainStage.setTitle("FileChooser Example");  
        mainStage.show(); 
    }
    
    private void switchToStart(ActionEvent actionEvent) {
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
    		alert.setContentText("Start Menu GUI load error");
    		alert.setTitle("Load Error");
    		alert.showAndWait();
    	}
    }
}
