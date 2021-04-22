package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestHasLeftChild {

	@Test
	public void shouldReturnFalseIfLeftChildIsNull() {
		QuestionNode node = new QuestionNode("value", NodeType.QUESTION);
		
		assertFalse(node.hasLeftChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("left", NodeType.QUESTION);
		
		node.setLeftChild(leftChild);
		assertTrue(node.hasLeftChild());
	}

}
