package model;

import enums.NodeType;
import errormessages.ErrorMessages;

public class BinaryTree {
	
	private TreeNode rootNode;
	private NodeType theNodeType;
	
	/**
	 * Creates a new binary tree
	 * 
	 * @precondition none
	 * @postcondition this.rootNode == null
	 */
	
	public BinaryTree(NodeType nodeType) {
		this.rootNode = null;
		this.theNodeType = nodeType;
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
		return this.theNodeType;
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

}
