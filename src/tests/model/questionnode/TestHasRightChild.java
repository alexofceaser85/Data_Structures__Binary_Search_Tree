package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestHasRightChild {

	@Test
	public void shouldReturnFalseIfRightChildIsNull() {
		QuestionNode node = new QuestionNode("value", NodeType.QUESTION);
		
		assertFalse(node.hasRightChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("right", NodeType.QUESTION);
		
		node.setRightChild(leftChild);
		assertTrue(node.hasRightChild());
	}

}
