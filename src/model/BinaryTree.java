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
	 * 				  && this.currentNode == this.rootNode
	 * 				  && this.userQuestion == ""
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
		
		if (userQuestionToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SET_NULL_USER_QUESTION);
		}
		if (userQuestionToSet.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SET_EMPTY_USER_QUESTION);
		}
		
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
		this.currentNode = this.rootNode;
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
		this.currentNode = currentNodeToSet;
	}
	
	/**
	 * Inserts a node into the tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void insertNode(String questionDescription, String answerDescription, NodeType nodeType, boolean responseToQuestion) {
		if (this.currentNode.getNodeType().equals(NodeType.QUESTION)) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_INSERT_NEW_NODE_AT_QUESTION_NODE);
		} else {
			AnswerNode theAnswerNode = (AnswerNode) this.currentNode;
			QuestionNode theQuestionNode = new QuestionNode(questionDescription, NodeType.QUESTION);
			AnswerNode theNewAnswerNode = new AnswerNode(answerDescription, NodeType.ANSWER);
			QuestionNode answerNodesParent = (QuestionNode) theAnswerNode.getParentNode();
			
			if (this.rootNode.getNodeType().equals(NodeType.ANSWER)) {
				this.rootNode = theQuestionNode;
				theNewAnswerNode.setParentNode(theQuestionNode);
				theAnswerNode.setParentNode(theQuestionNode);
				
				if (responseToQuestion == true) {
					theQuestionNode.setLeftChild(theNewAnswerNode);
					theQuestionNode.setRightChild(theAnswerNode);
				} else {
					theQuestionNode.setLeftChild(theAnswerNode);
					theQuestionNode.setRightChild(theNewAnswerNode);
				}
					
			} else {
				if (answerNodesParent.getLeftChild().getNodeValue().equals(theAnswerNode.getNodeValue())) {
					
					if (responseToQuestion == true) {
						theQuestionNode.setLeftChild(theNewAnswerNode);
						theQuestionNode.setRightChild(theAnswerNode);
						answerNodesParent.setLeftChild(theQuestionNode);
					} else {
						theQuestionNode.setLeftChild(theAnswerNode);
						theQuestionNode.setRightChild(theNewAnswerNode);
						answerNodesParent.setLeftChild(theQuestionNode);
					}
					
					answerNodesParent.setLeftChild(theQuestionNode);
				} else {
					
					if (responseToQuestion == true) {
						theQuestionNode.setLeftChild(theNewAnswerNode);
						theQuestionNode.setRightChild(theAnswerNode);
						answerNodesParent.setRightChild(theQuestionNode);
					} else {
						theQuestionNode.setLeftChild(theAnswerNode);
						theQuestionNode.setRightChild(theNewAnswerNode);
						answerNodesParent.setRightChild(theQuestionNode);
					}
				} 
			}
		}
	}

}
