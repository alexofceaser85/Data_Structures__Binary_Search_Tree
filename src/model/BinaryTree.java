package model;

public class BinaryTree {
	
	private TreeNode rootNode;
	
	/**
	 * Creates a new binary tree
	 * 
	 * @precondition none
	 * @postcondition this.rootNode == null
	 */
	
	public BinaryTree() {
		this.rootNode = null;
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
		this.rootNode = rootNodeToSet; 
	}

}
