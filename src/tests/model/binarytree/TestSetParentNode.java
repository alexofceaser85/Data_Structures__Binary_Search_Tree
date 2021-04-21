package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestSetParentNode {

	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		TreeNode parent = new TreeNode("parent");
		parent.setParentNode(new TreeNode("value"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new TreeNode("value"));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		TreeNode parent = new TreeNode("value");
		TreeNode newParent = new TreeNode("new value");
		
		parent.setParentNode(newParent);
		
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		TreeNode parent = new TreeNode("value");
		TreeNode oldParent = new TreeNode("old value");
		TreeNode newParent = new TreeNode("new value");
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}

}
