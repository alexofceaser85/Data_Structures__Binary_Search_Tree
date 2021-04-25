package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;

class TestHasRightChild {
	
	private final String nodeValue = "value";
	private final String rightChildValue = "right";

	@Test
	public void shouldReturnFalseIfRightChildIsNull() {
		QuestionNode node = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		
		assertFalse(node.hasRightChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		QuestionNode rightChild = new QuestionNode(this.rightChildValue, NodeType.QUESTION);
		
		node.setRightChild(rightChild);
		assertTrue(node.hasRightChild());
	}

}
