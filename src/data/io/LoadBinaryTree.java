package data.io;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import enums.FileNodeType;
import enums.NodeType;
import errormessages.ErrorMessages;
import model.AnswerNode;
import model.QuestionNode;
import model.TreeNode;
import viewmodel.BinaryTreeViewModel;

/**
 * Loads a file into a binary tree
 * 
 * @author Alex DeCesare
 * @version 29-April-2021
 */

public class LoadBinaryTree {

	/**
	 * Loads the binary tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public LoadBinaryTree() {

	}
	
	/**
	 * Loads the binary tree from a file
	 * 
	 * @precondition theFileToLoad != null
	 * @postcondition none
	 * 
	 * @param theFileToLoad the file to load into a binary tree
	 * 
	 * @return theBinaryTree the loaded binary tree
	 * @throws FileNotFoundException 
	 */
	
	public BinaryTreeViewModel loadBinaryTree(File theFileToLoad) throws FileNotFoundException {
		if (theFileToLoad == null) {
			throw new IllegalArgumentException(ErrorMessages.FILE_TO_LOAD_CANNOT_BE_NULL);
		}
		
		BinaryTreeViewModel theBinaryTree = new BinaryTreeViewModel();
		
		File theFile = new File(theFileToLoad.getAbsolutePath());
		Scanner fileScanner = new Scanner(theFile);
		
		String nodeValue = fileScanner.nextLine();
		String nodeType = fileScanner.nextLine();
		
		if (nodeType.equals(FileNodeType.Q.toString())) {
			theBinaryTree.setRootNode(new QuestionNode(nodeValue, NodeType.QUESTION));
		} else if (nodeType.equals(FileNodeType.A.toString())) {
			theBinaryTree.setRootNode(new AnswerNode(nodeValue, NodeType.ANSWER));
		} else {
			fileScanner.close();
			throw new IllegalArgumentException(ErrorMessages.COULD_NOT_READ_FILE);
		}
		
		this.loadSubtree(theBinaryTree, theBinaryTree.getRootNode(), fileScanner, nodeValue, nodeType, true);
		fileScanner.close();
		return theBinaryTree;
	}
	
	private void loadSubtree(BinaryTreeViewModel binaryTree, TreeNode node, Scanner fileScanner, String oldNodeValue, String oldNodeType, boolean shouldGetNewNodeValue) {
		
		String nodeValue = null;
		String nodeType = null;
		
		if (shouldGetNewNodeValue) {
			nodeValue = this.getNextFileLine(fileScanner);
			nodeType = this.getNextFileLine(fileScanner);
		} else {
			nodeValue = oldNodeValue;
			nodeType = oldNodeType;
		}
		
		if (nodeValue == null || nodeType == null) {
			return;
		}
		
		QuestionNode questionNode = (QuestionNode) node;

		if (nodeType.equals(FileNodeType.A.toString())) {
			this.addAnswerNode(binaryTree, fileScanner, nodeValue, nodeType, questionNode);
		} else if (nodeType.equals(FileNodeType.Q.toString())) {
			this.addQuestionNode(binaryTree, fileScanner, nodeValue, nodeType, questionNode);
		} else {
			fileScanner.close();
			throw new IllegalArgumentException(ErrorMessages.COULD_NOT_READ_FILE);
		}
	}
	
	private String getNextFileLine(Scanner fileScanner) {
		if (fileScanner.hasNextLine()) {
			return fileScanner.nextLine();
		} else {
			return null;
		}
	}

	private void addAnswerNode(BinaryTreeViewModel binaryTree, Scanner fileScanner, String nodeValue, String nodeType, QuestionNode questionNode) {

		if (!questionNode.hasLeftChild()) {
			AnswerNode leftChild = new AnswerNode(nodeValue, NodeType.ANSWER);
			questionNode.setLeftChild(leftChild);
			leftChild.setParentNode(questionNode);
			this.loadSubtree(binaryTree, questionNode, fileScanner, nodeValue, nodeType, true);
		} 
		if (!questionNode.hasRightChild()) {
			AnswerNode rightChild = new AnswerNode(nodeValue, NodeType.ANSWER);
			questionNode.setRightChild(rightChild);
			rightChild.setParentNode(questionNode);
		}
		if (questionNode.hasLeftChild() && questionNode.hasRightChild()) {
			
			String newNodeValue = this.getNextFileLine(fileScanner);
			String newNodeType = this.getNextFileLine(fileScanner);
			
			if (questionNode.getParentNode() != null) {
				this.loadSubtree(binaryTree, questionNode.getParentNode(), fileScanner, newNodeValue, newNodeType, false);
			}
		}
	}
	
	private void addQuestionNode(BinaryTreeViewModel binaryTree, Scanner fileScanner, String nodeValue, String nodeType, QuestionNode questionNode) {
		
		QuestionNode node = new QuestionNode(nodeValue, NodeType.QUESTION);
		node.setParentNode(questionNode);
		
		if (!questionNode.hasLeftChild()) {
			QuestionNode leftChild = node;
			questionNode.setLeftChild(leftChild);
			this.loadSubtree(binaryTree, leftChild, fileScanner, nodeValue, nodeType, true);
		} 
		if (!questionNode.hasRightChild()) {
			QuestionNode rightChild = node;
			questionNode.setRightChild(rightChild);
			this.loadSubtree(binaryTree, rightChild, fileScanner, nodeValue, nodeType, true);
		} 
		
		if (questionNode.hasLeftChild() && questionNode.hasRightChild()) {
			String newNodeValue = this.getNextFileLine(fileScanner);
			String newNodeType = this.getNextFileLine(fileScanner);
			
			if (questionNode.getParentNode() != null) {
				this.loadSubtree(binaryTree, questionNode.getParentNode(), fileScanner, newNodeValue, newNodeType, false);
			} 
		}
	}
}
