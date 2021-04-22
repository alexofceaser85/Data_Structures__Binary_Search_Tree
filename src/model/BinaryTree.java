package model;

import enums.NodeType;
import errormessages.ErrorMessages;

public class BinaryTree {
	
	private TreeNode rootNode;
	private String userQuestion;
	private TreeNode currentNode;
	
	/**
	 * Creates a new binary tree
	 * 
	 * @precondition none
	 * @postcondition this.rootNode == null
	 * 				  this.theNodeType == nodeType
	 * 				  this.currentNode == this.rootNode
	 * 				  this.userQuestion == ""
	 */
	
	public BinaryTree() {
		this.rootNode = null;
		this.currentNode = this.rootNode;
		this.userQuestion = "";
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
		return this.rootNode;
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
		return this.currentNode;
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
		return this.userQuestion;
	}
	
	/**
	 * Sets the user question
	 * 
	 * @precondition userQuestionToSet != null
	 * 				 && !userQuestionToSet.isBlank()
	 * 
	 * @postcondition this.userQuestion == userQuestionToSet
	 */
	
	public void setUserQuestion(String userQuestionToSet) {
		this.userQuestion = userQuestionToSet;
	}
	
	/**
	 * Sets the root node for the binary tree
	 * 
	 * @precondition none
	 * @postcondition this.rootNode == rootNodeToSet
	 */
	
	public void setRootNode(TreeNode rootNodeToSet) {
		
		if (rootNodeToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SET_ROOT_NODE_TO_NULL);
		}
		
		this.rootNode = rootNodeToSet; 
	}
	
	/**
	 * Inserts a node into the tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void insertNode(String description, NodeType nodeType) {
		//if (this.currentNode.)
	}

}
