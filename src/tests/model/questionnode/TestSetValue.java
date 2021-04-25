package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;

class TestSetValue {

	private final String oldNodeValue = "node value";
	private final String newNodeValue = "new node value";
	
	@Test
	public void shouldNotSetNullValue() {
		QuestionNode node = new QuestionNode(this.oldNodeValue, NodeType.QUESTION);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyValue() {
		QuestionNode node = new QuestionNode(this.oldNodeValue, NodeType.QUESTION);
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue("");
		});
	}
	
	@Test
	public void shouldSetValidValue() {
		QuestionNode node = new QuestionNode(this.oldNodeValue, NodeType.QUESTION);
		node.setValue(this.newNodeValue);
		assertEquals(this.newNodeValue, node.getNodeValue());
	}

}
