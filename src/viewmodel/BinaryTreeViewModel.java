package viewmodel;

import enums.NodeType;
import model.BinaryTree;
import model.TreeNode;

public class BinaryTreeViewModel {

	private BinaryTree theBinaryTree;
	
	/**
	 * Creates a new binary tree
	 * 
	 * @precondition none
	 * @postcondition this.theBinaryTree = new BinaryTree()
	 */
	
	public BinaryTreeViewModel() {
		this.theBinaryTree = new BinaryTree();
	}
	
	/**
	 * Gets the binary tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the binary tree
	 */
	
	public BinaryTree getBinaryTree() {
		return this.theBinaryTree;
	}
	
	/**
	 * Gets the root node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the root node
	 */
	
	public TreeNode getRootNode() {
		return this.theBinaryTree.getRootNode();
	}
	
	/**
	 * Gets the current node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the current node
	 */
	
	public TreeNode getCurrentNode() {
		return this.theBinaryTree.getCurrentNode();
	}
	
	/**
	 * Gets the user question
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the user question
	 */
	
	public String getUserQuestion() {
		return this.theBinaryTree.getUserQuestion();
	}
	
	/**
	 * Traverses to the parent of the current node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if traversed to parent false otherwise
	 */
	
	public boolean traverseToParent() {
		return this.theBinaryTree.traverseToParent();
	}
	
	/**
	 * Traverses to the left child of the current node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if traversed to left child false otherwise
	 */
	
	public boolean traverseToLeftChild() {
		return this.theBinaryTree.traverseToLeftChild();
	}
	
	/**
	 * Traverses to the right child of the current node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if traversed to right child false otherwise
	 */
	
	public boolean traverseToRightChild() {
		return this.theBinaryTree.traverseToRightChild();
	}
	
	/**
	 * Sets the user question
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param userQuestionToSet the user question to set
	 */
	
	public void setUserQuestion(String userQuestionToSet) {
		this.theBinaryTree.setUserQuestion(userQuestionToSet);
	}
	
	
	/**
	 * Sets the root node for the binary tree
	 * 
	 * @precondition rootNodeToSet != null
	 * @postcondition this.rootNode == rootNodeToSet
	 * 
	 * @param rootNodeToSet the root node to set
	 */
	
	public void setRootNode(TreeNode rootNodeToSet) {
		this.theBinaryTree.setRootNode(rootNodeToSet);
	}
	
	/**
	 * Sets the current node
	 * 
	 * @precondition currentNodeToSet != null
	 * @postcondition this.currentNode.equals(currentNodeToSet)
	 * 
	 * @param currentNodeToSet the node to set as the current node
	 */
	
	public void setCurrentNode(TreeNode currentNodeToSet) {
		this.theBinaryTree.setCurrentNode(currentNodeToSet);
	}
	
	/**
	 * Inserts a node into the tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void insertNode(String questionDescription, String answerDescription, NodeType nodeType, boolean responseToQuestion) {
		this.theBinaryTree.insertNode(questionDescription, answerDescription, nodeType, responseToQuestion);
	}
}
