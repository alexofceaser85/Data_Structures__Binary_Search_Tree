package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import data.fileparsers.InitialAnimalGuessesParser;
import data.filepaths.FilePaths;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Main;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import viewmodel.InitialAnimalGuessViewModel;

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
    
    public StartMenuCodeBehind() {
    	this.theBinaryTree = new BinaryTreeViewModel();
    }
    
    public void setViewModel(BinaryTreeViewModel binaryTreeToSet) {
    	this.theBinaryTree = binaryTreeToSet;
    }
    
    @FXML
    public void switchToQuestion(ActionEvent actionEvent) {
    	try {
    		if (this.theBinaryTree.getCurrentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode() == null || this.theBinaryTree.getCurrentNode().getParentNode().getNodeType().equals(NodeType.ANSWER)) {

    			
    			this.theBinaryTree.setRootNode(new AnswerNode(this.getInitialNode(), NodeType.ANSWER));
    			this.switchToWinningScreen(actionEvent);
    		} else {
        		this.theBinaryTree.setCurrentNode(this.theBinaryTree.getRootNode());
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        		
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
        	Optional<ButtonType> computerWinsResult = computerWinsAlert.showAndWait();
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