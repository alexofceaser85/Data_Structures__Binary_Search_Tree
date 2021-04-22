package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestHasRightChild {

	@Test
	public void shouldReturnFalseIfRightChildIsNull() {
		QuestionNode node = new QuestionNode("value");
		
		assertFalse(node.hasRightChild());
	}
	
	@Test
	public void shouldReturnTrueIfLeftChildIsNotNull() {
		QuestionNode node = new QuestionNode("value");
		QuestionNode leftChild = new QuestionNode("right");
		
		node.setRightChild(leftChild);
		assertTrue(node.hasRightChild());
	}

}
