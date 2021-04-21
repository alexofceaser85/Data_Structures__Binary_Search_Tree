package tests.model.treenode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TreeNode;

class TestSetValue {

	@Test
	public void shouldNotSetNullValue() {
		TreeNode node = new TreeNode("node value");
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyValue() {
		TreeNode node = new TreeNode("node value");
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue("");
		});
	}
	
	@Test
	public void shouldSetValidValue() {
		TreeNode node = new TreeNode("node value");
		node.setValue("new node value");
		assertEquals("new node value", node.getNodeValue());
	}

}
