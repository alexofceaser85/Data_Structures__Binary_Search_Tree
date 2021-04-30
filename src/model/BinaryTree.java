package model;

import enums.NodeType;
import errormessages.ErrorMessages;

/**
 * Models the binary tree
 * 
 * @author Alex DeCesare
 * @version 20-April-2021
 */

public class BinaryTree {
	
	private TreeNode rootNode;
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
	 * Traverses to the parent of the current node
	 * 
	 * @precondition none
	 * @postcondition this.currentNode == this.currentNode.getParent()@prev
	 * 
	 * @return true if traversed to parent false otherwise
	 */
	
	public boolean traverseToParent() {
		if (this.currentNode == null) {
			return false;
		}
		
		TreeNode parent = this.currentNode.getParentNode();
		
		if (parent != null) {
			this.currentNode = parent;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Traverses to the left child of the current node
	 * 
	 * @precondition this.currentNode != null
	 * @postcondition this.currentNode == this.currentNode.getLeftChild()@prev
	 * 
	 * @return true if traversed to left child false otherwise
	 */
	
	public boolean traverseToLeftChild() {
		
		if (this.currentNode == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_TRAVERSE_LEFT_ON_AN_EMPTY_TREE);
		}
		
		if (this.currentNode.getNodeType().equals(NodeType.ANSWER)) {
			return false;
		}
		
		QuestionNode question = (QuestionNode) this.currentNode;
		this.currentNode = question.getLeftChild();
		return true;
	}
	
	/**
	 * Traverses to the right child of the current node
	 * 
	 * @precondition this.currentNode != null
	 * @postcondition this.currentNode == this.currentNode.getRightChild()@prev
	 * 
	 * @return true if traversed to right child false otherwise
	 */
	
	public boolean traverseToRightChild() {
		
		if (this.currentNode == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_TRAVERSE_RIGHT_ON_AN_EMPTY_TREE);
		}
		
		if (this.currentNode.getNodeType().equals(NodeType.ANSWER)) {
			return false;
		}
		
		QuestionNode question = (QuestionNode) this.currentNode;
		this.currentNode = question.getRightChild();
		return true;
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
	 * 
	 * @param questionDescription the description of the question to insert
	 * @param answerDescription the description of the answer of the question
	 * @param nodeType the type of the question to insert
	 * @param responseToQuestion if the answer to the question is the correct answer or not
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
				this.setRootQuestionReferenceNodes(responseToQuestion, theAnswerNode, theQuestionNode, theNewAnswerNode);
					
			} else {
				if (answerNodesParent.getLeftChild().getNodeValue().equals(theAnswerNode.getNodeValue())) {
					this.setLeftQuestionReferenceNodes(responseToQuestion, theAnswerNode, theQuestionNode, theNewAnswerNode, answerNodesParent);
				} else {
					this.setRightQuestionReferenceNodes(responseToQuestion, theAnswerNode, theQuestionNode, theNewAnswerNode, answerNodesParent);
				} 
			}
		}
	}

	private void setRightQuestionReferenceNodes(boolean responseToQuestion, AnswerNode theAnswerNode,
			QuestionNode theQuestionNode, AnswerNode theNewAnswerNode, QuestionNode answerNodesParent) {
		if (responseToQuestion) {
			theQuestionNode.setLeftChild(theNewAnswerNode);
			theQuestionNode.setRightChild(theAnswerNode);
			answerNodesParent.setRightChild(theQuestionNode);
			theQuestionNode.setParentNode(answerNodesParent);
			theQuestionNode.getLeftChild().setParentNode(theQuestionNode);
			theQuestionNode.getRightChild().setParentNode(theQuestionNode);
			this.currentNode = theQuestionNode.getLeftChild();
		} else {
			theQuestionNode.setLeftChild(theAnswerNode);
			theQuestionNode.setRightChild(theNewAnswerNode);
			answerNodesParent.setRightChild(theQuestionNode);
			theQuestionNode.setParentNode(answerNodesParent);
			theQuestionNode.getLeftChild().setParentNode(theQuestionNode);
			theQuestionNode.getRightChild().setParentNode(theQuestionNode);
			this.currentNode = theQuestionNode.getRightChild();
		}
	}

	private void setLeftQuestionReferenceNodes(boolean responseToQuestion, AnswerNode theAnswerNode,
			QuestionNode theQuestionNode, AnswerNode theNewAnswerNode, QuestionNode answerNodesParent) {
		if (responseToQuestion) {
			theQuestionNode.setLeftChild(theNewAnswerNode);
			theQuestionNode.setRightChild(theAnswerNode);
			answerNodesParent.setLeftChild(theQuestionNode);
			theQuestionNode.setParentNode(answerNodesParent);
			theQuestionNode.getLeftChild().setParentNode(theQuestionNode);
			theQuestionNode.getRightChild().setParentNode(theQuestionNode);
			this.currentNode = theQuestionNode.getLeftChild();
		} else {
			theQuestionNode.setLeftChild(theAnswerNode);
			theQuestionNode.setRightChild(theNewAnswerNode);
			answerNodesParent.setLeftChild(theQuestionNode);
			theQuestionNode.getLeftChild().setParentNode(theQuestionNode);
			theQuestionNode.getRightChild().setParentNode(theQuestionNode);
			theQuestionNode.setParentNode(answerNodesParent);
			this.currentNode = theQuestionNode.getRightChild();
		}
		
		answerNodesParent.setLeftChild(theQuestionNode);
	}

	private void setRootQuestionReferenceNodes(boolean responseToQuestion, AnswerNode theAnswerNode,
			QuestionNode theQuestionNode, AnswerNode theNewAnswerNode) {
		this.rootNode = theQuestionNode;
		theNewAnswerNode.setParentNode(theQuestionNode);
		theAnswerNode.setParentNode(theQuestionNode);
		
		if (responseToQuestion) {
			theQuestionNode.setLeftChild(theNewAnswerNode);
			theQuestionNode.setRightChild(theAnswerNode);
			this.currentNode = theQuestionNode.getLeftChild();
		} else {
			theQuestionNode.setLeftChild(theAnswerNode);
			theQuestionNode.setRightChild(theNewAnswerNode);
			this.currentNode = theQuestionNode.getRightChild();
		}
	}

}
