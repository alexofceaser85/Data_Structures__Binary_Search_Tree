package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestConstructor {

	@Test
	public void shouldNotAllowTreeNodeWithNullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuestionNode(null, NodeType.QUESTION);
		});
	}
	
	@Test
	public void shouldNotAllowTreeNodeWithEmptyValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuestionNode("", NodeType.QUESTION);
		});
	}
	
	@Test
	public void shouldInstantiateValidValues() {
		QuestionNode node = new QuestionNode("valid value", NodeType.QUESTION);
		
		assertEquals("valid value", node.getNodeValue());
		assertEquals(null, node.getLeftChild());
		assertEquals(null, node.getRightChild());
		assertEquals(null, node.getParentNode());
		assertEquals(NodeType.QUESTION, node.getNodeType());
	}

}
