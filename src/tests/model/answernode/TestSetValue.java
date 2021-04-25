package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;

class TestSetValue {

	private final String answerNodeValue = "node value";
	private final String newNodeValue = "new node value";
	
	@Test
	public void shouldNotSetNullValue() {
		AnswerNode node = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyValue() {
		AnswerNode node = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue("");
		});
	}
	
	@Test
	public void shouldSetValidValue() {
		AnswerNode node = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		node.setValue(this.newNodeValue);
		assertEquals(this.newNodeValue, node.getNodeValue());
	}

}
