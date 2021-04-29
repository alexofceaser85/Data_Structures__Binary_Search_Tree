package tests.data.io.savebinarytree;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import data.filepaths.FilePaths;
import data.io.SaveBinaryTree;
import enums.NodeType;
import model.AnswerNode;
import model.QuestionNode;
import viewmodel.BinaryTreeViewModel;

class TestSaveFile {

	private final String filePathForRootNodeSaveTests = FilePaths.TEST_FILE_FOR_SAVE_FILE_UNIT_TESTS + "\\shouldSaveFileWithRootNode";
	private final String filePathForQuestionRootNodeAndChildrenSaveTests = FilePaths.TEST_FILE_FOR_SAVE_FILE_UNIT_TESTS + "\\shouldSaveFileWithQuestionRootNodeAndChildren";
	private final String filePathForEmptyQuestionRootNode = FilePaths.TEST_FILE_FOR_SAVE_FILE_UNIT_TESTS + "\\shouldSaveEmptyQuestionNode";
	
	private final String answerDescription = "ANSWER";
	private final String questionDescription = "QUESTION";
	
	public String fileReader(File file) {
		try {
			Scanner scanner = new Scanner(file);
			String fileData = "";
			
			while (scanner.hasNextLine()) {
				fileData += scanner.nextLine() + System.lineSeparator();
			}
			
			return fileData;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
	@Test
	public void shouldNotSaveFileWithNullFile() {
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		theTree.setRootNode(new AnswerNode("answer", NodeType.ANSWER));
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		
		assertThrows(IllegalArgumentException.class, () -> {
			saveBinaryTree.saveFile(null, theTree);
		});
	}
	
	@Test
	public void shouldNotSaveFileWithNullTree() {
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		File newFile = new File(this.filePathForRootNodeSaveTests);
		
		assertThrows(IllegalArgumentException.class, () -> {
			saveBinaryTree.saveFile(newFile, null);
		});
	}
	
	@Test
	public void shouldNotSaveFileWithNullRootNode() {
		File newFile = new File(this.filePathForRootNodeSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		
		assertThrows(IllegalArgumentException.class, () -> {
			saveBinaryTree.saveFile(newFile, theTree);
		});
	}
	
	@Test
	public void shouldSaveFileWithOnlyAnswerRootNode() throws FileNotFoundException {
		File newFile = new File(this.filePathForRootNodeSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		theTree.setRootNode(new AnswerNode("answer", NodeType.ANSWER));
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		saveBinaryTree.saveFile(newFile, theTree);
		String testData = "answer" + System.lineSeparator() + this.answerDescription + System.lineSeparator();
		assertEquals(testData, this.fileReader(newFile));
	}
	
	@Test
	public void shouldSaveFileWithQuestionRootNodeAndTwoAnswers() throws FileNotFoundException {
		File newFile = new File(this.filePathForQuestionRootNodeAndChildrenSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		theTree.setRootNode(new AnswerNode("no", NodeType.ANSWER));
		theTree.insertNode("is it the answer?", "yes", NodeType.QUESTION, true);
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		saveBinaryTree.saveFile(newFile, theTree);
		String testData = "is it the answer?" + System.lineSeparator() 
			+ this.questionDescription + System.lineSeparator() 
			+ "yes"  + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator()
			+ "no" + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator();
		assertEquals(testData, this.fileReader(newFile));
	}
	
	@Test
	public void shouldSaveFileWithQuestionRootNodeAndTwoQuestions() throws FileNotFoundException {
		File newFile = new File(this.filePathForQuestionRootNodeAndChildrenSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		QuestionNode root = new QuestionNode("does it walk?", NodeType.QUESTION);
		QuestionNode rightChild = new QuestionNode("is it black?", NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("does it eat meat?", NodeType.QUESTION);
		
		rightChild.setRightChild(new AnswerNode("Robin", NodeType.ANSWER));
		rightChild.setLeftChild(new AnswerNode("Vulture", NodeType.ANSWER));
		
		leftChild.setRightChild(new AnswerNode("Turtle", NodeType.ANSWER));
		leftChild.setLeftChild(new AnswerNode("Dog", NodeType.ANSWER));
		
		root.setRightChild(rightChild);
		root.setLeftChild(leftChild);
		theTree.setRootNode(root);
		
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		saveBinaryTree.saveFile(newFile, theTree);
		String testData = "does it walk?" + System.lineSeparator() 
			+ this.questionDescription + System.lineSeparator() 
			+ "does it eat meat?"  + System.lineSeparator()
			+ this.questionDescription + System.lineSeparator()
			+ "Dog" + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator()
			+ "Turtle" + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator()
			+ "is it black?" + System.lineSeparator()
			+ this.questionDescription + System.lineSeparator()
			+ "Vulture" + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator()
			+ "Robin" + System.lineSeparator()
			+ this.answerDescription + System.lineSeparator();
		assertEquals(testData, this.fileReader(newFile));
	}
	
	@Test
	public void shouldSaveQuestionNodeWithoutChildren() throws FileNotFoundException {
		File newFile = new File(this.filePathForRootNodeSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		theTree.setRootNode(new QuestionNode("question", NodeType.QUESTION));
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		saveBinaryTree.saveFile(newFile, theTree);
		String testData = "question" + System.lineSeparator() + this.questionDescription + System.lineSeparator();
		assertEquals(testData, this.fileReader(newFile));
	}

}
