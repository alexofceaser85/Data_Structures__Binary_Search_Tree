package model;

import enums.NodeType;
import errormessages.ErrorMessages;

public class QuestionNode extends TreeNode {

	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public QuestionNode(String value, NodeType nodeType) {
		super(value, nodeType);
		
		this.leftChild = null;
		this.rightChild = null;
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
		return super.getParentNode();
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
	 * Gets the node type
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the node type
	 */
	
	public NodeType getNodeType() {
		return super.getNodeType();
	}
	
	/**
	 * Sets the value of the node
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void setValue(String valueToSet) {
		super.setValue(valueToSet);
	}
	
	/**
	 * Sets the parent node of the tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void setParentNode(TreeNode parentNodeToSet) {
		super.setParentNode(parentNodeToSet);
	}
	
	/**
	 * Sets the left child to a node
	 * 
	 * @precondition !nodeToSet.getNodeValue().equals(this.rightChild.getNodeValue()@prev)
	 * @postcondition none
	 */
	
	public void setLeftChild(TreeNode nodeToSet) {
		
		if (nodeToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SET_A_NULL_LEFT_CHILD);
		}
		
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
		
		if (nodeToSet == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SET_A_NULL_RIGHT_CHILD);
		}
		
		if (this.rightChild != null && this.rightChild.getNodeValue().equals(nodeToSet.getNodeValue())) {
			throw new IllegalArgumentException(ErrorMessages.THE_VALUE_OF_THE_RIGHT_CHILD_CANNOT_BE_THE_SAME_AS_PREVIOUS);
		}
		
		this.rightChild = nodeToSet;
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
