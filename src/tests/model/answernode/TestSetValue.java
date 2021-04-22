package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import model.QuestionNode;

class TestSetValue {

	@Test
	public void shouldNotSetNullValue() {
		AnswerNode node = new AnswerNode("node value", NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyValue() {
		AnswerNode node = new AnswerNode("node value", NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue("");
		});
	}
	
	@Test
	public void shouldSetValidValue() {
		AnswerNode node = new AnswerNode("node value", NodeType.ANSWER);
		node.setValue("new node value");
		assertEquals("new node value", node.getNodeValue());
	}

}
