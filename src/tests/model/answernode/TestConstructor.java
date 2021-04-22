package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import model.QuestionNode;

class TestConstructor {

	@Test
	public void shouldNotAllowTreeNodeWithNullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new AnswerNode(null, NodeType.ANSWER);
		});
	}
	
	@Test
	public void shouldNotAllowTreeNodeWithEmptyValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new AnswerNode("", NodeType.ANSWER);
		});
	}
	
	@Test
	public void shouldInstantiateValidValues() {
		AnswerNode node = new AnswerNode("valid value", NodeType.ANSWER);
		
		assertEquals("valid value", node.getNodeValue());
		assertEquals(null, node.getParentNode());
		assertEquals(NodeType.ANSWER, node.getNodeType());
	}

}
