package model;

import enums.NodeType;
import errormessages.ErrorMessages;

/**
 * The tree node
 *
 * @author Alex DeCesare
 * @version 20-April-2021
 */

public abstract class TreeNode {

	private String nodeValue;
	private TreeNode parentNode;
	private NodeType nodeType;
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
	 * @param nodeType the type of the tree node
	 */
	
	public TreeNode(String value, NodeType nodeType) {
		
		if (value == null) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_OF_NEW_TREE_NODE_CANNOT_BE_NULL);
		}
		if (value.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_OF_NEW_TREE_NODE_CANNOT_BE_EMPTY);
		}
		
		this.nodeValue = value;
		this.parentNode = null;
		this.nodeType = nodeType;
	}
	
	/**
	 * Gets the node type
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the node type
	 */
	
	public NodeType getNodeType() {
		return this.nodeType;
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
	 * 
	 * @param valueToSet the value of the node to set
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
	 * 
	 * @param parentNodeToSet the node to set as the parent node
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
