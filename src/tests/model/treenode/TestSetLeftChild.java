package tests.model.treenode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestSetLeftChild {

	@Test
	public void shouldNotSetNewLeftChildEqualToPreviousLeftChild() {
		
		TreeNode parent = new TreeNode("value");
		TreeNode leftChild = new TreeNode("left value");
		parent.setLeftChild(leftChild);
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setLeftChild(new TreeNode("left value"));
		});
	}
	
	@Test
	public void shouldSetNewLeftChild() {
		TreeNode parent = new TreeNode("value");
		TreeNode leftChild = new TreeNode("left value");
		
		parent.setLeftChild(leftChild);
		
		assertEquals("left value", parent.getLeftChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingLeftChild() {
		TreeNode parent = new TreeNode("value");
		TreeNode oldLeftChild = new TreeNode("old left value");
		TreeNode newLeftChild = new TreeNode("new left value");
		parent.setLeftChild(oldLeftChild);
		assertEquals("old left value", parent.getLeftChild().getNodeValue());
		parent.setLeftChild(newLeftChild);
		assertEquals("new left value", parent.getLeftChild().getNodeValue());
	}

}
