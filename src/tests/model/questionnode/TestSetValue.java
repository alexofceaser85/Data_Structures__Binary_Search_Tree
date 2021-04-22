package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestSetValue {

	@Test
	public void shouldNotSetNullValue() {
		QuestionNode node = new QuestionNode("node value");
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyValue() {
		QuestionNode node = new QuestionNode("node value");
		
		assertThrows(IllegalArgumentException.class, () -> {
			node.setValue("");
		});
	}
	
	@Test
	public void shouldSetValidValue() {
		QuestionNode node = new QuestionNode("node value");
		node.setValue("new node value");
		assertEquals("new node value", node.getNodeValue());
	}

}
