package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestConstructor {

	@Test
	public void shouldNotAllowTreeNodeWithNullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuestionNode(null);
		});
	}
	
	@Test
	public void shouldNotAllowTreeNodeWithEmptyValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuestionNode("");
		});
	}
	
	@Test
	public void shouldInstantiateValidValues() {
		QuestionNode node = new QuestionNode("valid value");
		
		assertEquals("valid value", node.getNodeValue());
		assertEquals(null, node.getLeftChild());
		assertEquals(null, node.getRightChild());
		assertEquals(null, node.getParentNode());
	}

}
