package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;

class TestHasLeftChild {

	private final String nodeValue = "value";
	private final String leftChildValue = "left";
	
	@Test
	public void shouldReturnFalseIfLeftChildIsNull() {
		QuestionNode node = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		
		assertFalse(node.hasLeftChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode(this.leftChildValue, NodeType.QUESTION);
		
		node.setLeftChild(leftChild);
		assertTrue(node.hasLeftChild());
	}

}
