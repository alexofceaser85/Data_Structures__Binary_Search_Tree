package tests.model.treenode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestConstructor {

	@Test
	public void shouldNotAllowTreeNodeWithNullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new TreeNode(null);
		});
	}
	
	@Test
	public void shouldNotAllowTreeNodeWithEmptyValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new TreeNode("");
		});
	}
	
	@Test
	public void shouldInstantiateValidValues() {
		TreeNode node = new TreeNode("valid value");
		
		assertEquals("valid value", node.getNodeValue());
		assertEquals(null, node.getLeftChild());
		assertEquals(null, node.getRightChild());
		assertEquals(null, node.getParentNode());
	}

}
