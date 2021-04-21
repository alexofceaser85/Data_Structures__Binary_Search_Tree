package model;

import errormessages.ErrorMessages;

public class TreeNode {

	private String nodeValue;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private TreeNode parentNode;
	
	/**
	 * Makes a new node on the tree
	 * 
	 * @precondition this.nodeValue.isBlank() == false && this.nodeValue != null
	 * @postcondition 
	 * 		this.nodeValue = value
	 * 		&& this.leftChild == null
	 * 		&& this.rightChild == null
	 * 		&& this.parentNode == null
	 * 
	 * @param value the value of the new tree node
	 */
	
	public TreeNode(String value) {
		
		if (value == null) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_OF_NEW_TREE_NODE_CANNOT_BE_NULL);
		}
		if (value.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_OF_NEW_TREE_NODE_CANNOT_BE_EMPTY);
		}
		
		this.nodeValue = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parentNode = null;
	}
	
	/**
	 * Gets the node value
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the node value
	 */
	
	public String getNodeValue() {
		return this.nodeValue;
	}
	
	/**
	 * Gets the left child
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the left child
	 */
	
	public TreeNode getLeftChild() {
		return this.leftChild;
	}
	
	/**
	 * Gets the right child
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the right child
	 */
	
	public TreeNode getRightChild() {
		return this.rightChild;
	}
	
	/**
	 * Gets the parent node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the parent node
	 */
	
	public TreeNode getParentNode() {
		return this.parentNode;
	}
	
	/**
	 * Sets the left child to a node
	 * 
	 * @precondition !nodeToSet.getNodeValue().equals(this.rightChild.getNodeValue()@prev)
	 * @postcondition none
	 */
	
	public void setLeftChild(TreeNode nodeToSet) {
		
		if (this.leftChild != null && this.leftChild.getNodeValue().equals(nodeToSet.getNodeValue())) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_LEFT_CHILD_CANNOT_BE_THE_SAME_AS_PREVIOUS);
		}
		
		this.leftChild = nodeToSet;
	}
	
	/**
	 * Sets the right child to a node
	 * 
	 * @precondition !nodeToSet.getNodeValue().equals(this.rightChild.getNodeValue()@prev)
	 * @postcondition none
	 */
	
	public void setRightChild(TreeNode nodeToSet) {
		
		if (this.rightChild != null && this.rightChild.getNodeValue().equals(nodeToSet.getNodeValue())) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_RIGHT_CHILD_CANNOT_BE_THE_SAME_AS_PREVIOUS);
		}
		
		this.rightChild = nodeToSet;
	}
	
	/**
	 * Sets the value of the node
	 * 
	 * @precondition valueToSet != null && !valueToSet.isBlank()
	 * @postcondition this.value == valueToSet
	 */
	
	public void setValue(String valueToSet) {
		if (valueToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_NODE_CANNOT_BE_SET_TO_NULL);
		}
		if (valueToSet.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_NODE_CANNOT_BE_SET_TO_EMPTY);
		}
		
		this.nodeValue = valueToSet;
	}
	
	/**
	 * Sets the parent node of the tree
	 * 
	 * @precondition !parentNodeToSet.getNodeValue().equals(this.parentNode.getNodeValue()@prev)
	 * @postcondition this.parentNode == parentNodeToSet
	 */
	
	public void setParentNode(TreeNode parentNodeToSet) {
		if (this.parentNode != null && this.parentNode.getNodeValue().equals(parentNodeToSet.getNodeValue())) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_PARENT_NODE_CANNOT_BE_THE_SAME_AS_PREVIOUS);
		}
		
		this.parentNode = parentNodeToSet;
	}
	
	/**
	 * Checks if the node has a left child
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the node has a left child and false otherwise
	 */
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	/**
	 * Checks if the node has a right child
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the node has a right child and false otherwise
	 */
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
}
