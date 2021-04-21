package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestSetRightChild {

	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		TreeNode parent = new TreeNode("parent");
		parent.setRightChild(new TreeNode("value"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setRightChild(new TreeNode("value"));
		});
	}
	
	@Test
	public void shouldSetNewRightChild() {
		TreeNode parent = new TreeNode("value");
		TreeNode leftChild = new TreeNode("right value");
		
		parent.setRightChild(leftChild);
		
		assertEquals("right value", parent.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingRightChild() {
		TreeNode parent = new TreeNode("value");
		TreeNode oldRightChild = new TreeNode("old right value");
		TreeNode newRightChild = new TreeNode("new right value");
		parent.setRightChild(oldRightChild);
		assertEquals("old right value", parent.getRightChild().getNodeValue());
		parent.setRightChild(newRightChild);
		assertEquals("new right value", parent.getRightChild().getNodeValue());
	}

}
