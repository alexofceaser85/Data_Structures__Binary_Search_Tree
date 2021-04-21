package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestHasRightChild {

	@Test
	public void shouldReturnFalseIfRightChildIsNull() {
		TreeNode node = new TreeNode("value");
		
		assertFalse(node.hasRightChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		TreeNode node = new TreeNode("value");
		TreeNode leftChild = new TreeNode("right");
		
		node.setRightChild(leftChild);
		assertTrue(node.hasRightChild());
	}

}
