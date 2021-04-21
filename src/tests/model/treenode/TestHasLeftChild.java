package tests.model.treenode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestHasLeftChild {

	@Test
	public void shouldReturnFalseIfLeftChildIsNull() {
		TreeNode node = new TreeNode("value");
		
		assertFalse(node.hasLeftChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		TreeNode node = new TreeNode("value");
		TreeNode leftChild = new TreeNode("left");
		
		node.setLeftChild(leftChild);
		assertTrue(node.hasLeftChild());
	}

}
