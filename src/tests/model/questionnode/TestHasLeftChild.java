package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestHasLeftChild {

	@Test
	public void shouldReturnFalseIfLeftChildIsNull() {
		QuestionNode node = new QuestionNode("value");
		
		assertFalse(node.hasLeftChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode("value");
		QuestionNode leftChild = new QuestionNode("left");
		
		node.setLeftChild(leftChild);
		assertTrue(node.hasLeftChild());
	}

}
