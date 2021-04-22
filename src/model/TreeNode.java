package model;

import errormessages.ErrorMessages;

public abstract class TreeNode {

	private String nodeValue;
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
		this.parentNode = null;
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
	 * @precondition 
	 * 		parentNodeToSet != null
	 * 		!parentNodeToSet.getNodeValue().equals(this.parentNode.getNodeValue()@prev)
	 * @postcondition this.parentNode == parentNodeToSet
	 */
	
	public void setParentNode(TreeNode parentNodeToSet) {
		if (parentNodeToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.THE_PARENT_NODE_TO_SET_CANNOT_BE_NULL);
		}
		
		if (this.parentNode != null && this.parentNode.getNodeValue().equals(parentNodeToSet.getNodeValue())) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_PARENT_NODE_CANNOT_BE_THE_SAME_AS_PREVIOUS);
		}
		
		this.parentNode = parentNodeToSet;
	}
	
}
