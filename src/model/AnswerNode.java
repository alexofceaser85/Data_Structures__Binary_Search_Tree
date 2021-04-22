package model;

import errormessages.ErrorMessages;

public class AnswerNode extends TreeNode {

	/**
	 * Creates a new answer node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param value the value for the answer node
	 */
	
	public AnswerNode(String value) {
		super(value);
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
	 * Gets the node value
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the node value
	 */
	
	public String getNodeValue() {
		return super.getNodeValue();
	}
	
	/**
	 * Sets the value of the node
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param valueToSet the value to set
	 */
	
	public void setValue(String valueToSet) {
		super.setValue(valueToSet);
	}
	
	/**
	 * Sets the parent node of the tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param parentNodeToSet the parent node to set
	 */
	
	public void setParentNode(TreeNode parentNodeToSet) {
		super.setParentNode(parentNodeToSet);
	}
	
}
