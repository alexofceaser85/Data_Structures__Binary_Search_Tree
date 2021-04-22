package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AnswerNode;
import model.QuestionNode;

class TestConstructor {

	@Test
	public void shouldNotAllowTreeNodeWithNullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new AnswerNode(null);
		});
	}
	
	@Test
	public void shouldNotAllowTreeNodeWithEmptyValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new AnswerNode("");
		});
	}
	
	@Test
	public void shouldInstantiateValidValues() {
		AnswerNode node = new AnswerNode("valid value");
		
		assertEquals("valid value", node.getNodeValue());
		assertEquals(null, node.getParentNode());
	}

}
