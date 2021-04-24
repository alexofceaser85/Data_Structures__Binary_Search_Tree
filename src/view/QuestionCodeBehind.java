package view;

import java.io.IOException;
import java.util.Optional;

import enums.NodeType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.AnswerNode;
import model.QuestionNode;
import viewmodel.BinaryTreeViewModel;

public class QuestionCodeBehind {

    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;

    @FXML
    private Label questionLabel;
    
    private Scene secondScene;

    private BinaryTreeViewModel binaryTreeViewModel;
    
    public QuestionCodeBehind() {

    }
    
    public void setViewModel(BinaryTreeViewModel viewModelToSet) {
    	this.binaryTreeViewModel = viewModelToSet;
    	this.updateGUI();
    }
    
    private void updateGUI() {
    	this.questionLabel.setText(this.binaryTreeViewModel.getCurrentNode().getNodeValue());
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
        	Optional<ButtonType> computerWinsResult = computerWinsAlert.showAndWait();
    		this.switchToMain(actionEvent);
    	} else {
    		this.switchToHumanWins(actionEvent);
    	}
    }
    
    private void switchToHumanWins(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HumanWins.fxml"));
    		Parent root = (Parent) loader.load();
    		HumanWinsCodeBehind controller = loader.<HumanWinsCodeBehind>getController();
    		controller.setViewModel(this.binaryTreeViewModel);
    		
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
    
    private void switchToMain(ActionEvent actionEvent) {
    	try {
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    		
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