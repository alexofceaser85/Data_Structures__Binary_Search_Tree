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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import viewmodel.BinaryTreeViewModel;

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

    private BinaryTreeViewModel binaryTreeViewModel;
    
    public void setViewModel(BinaryTreeViewModel viewModelToSet) {
    	this.binaryTreeViewModel = viewModelToSet;
    }
    
    @FXML
    void submitAnimal(ActionEvent event) {
    	try {
    		if (!distinguishQuestionYes.isSelected() && !distinguishQuestionNo.isSelected()) {
    			throw new IllegalArgumentException(ErrorMessages.CANNOT_ADD_NEW_NODE_WITHOUT_SELECTING_NODE_SIZE);
    		} else {
        		this.binaryTreeViewModel.insertNode(questionTextField.getText(), answerTextField.getText(), NodeType.QUESTION, this.distinguishQuestionYes.isSelected());
            	this.switchToStart(event);
    		}
    	} catch (IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(e.getMessage());
    		alert.setTitle("There was an error adding your animal");
    		alert.showAndWait();
    	}
    }
    
    private void switchToStart(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartMenu.fxml"));
    		Parent root = (Parent) loader.load();
    		StartMenuCodeBehind controller = loader.<StartMenuCodeBehind>getController();
    		System.out.println(this.binaryTreeViewModel.getCurrentNode().getNodeValue());
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
