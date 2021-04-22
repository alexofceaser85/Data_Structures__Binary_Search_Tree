package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestSetLeftChild {

	@Test
	public void shouldNotSetNullLeftChild() {
		QuestionNode parent = new QuestionNode("value");
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setLeftChild(null);
		});
	}
	
	@Test
	public void shouldNotSetNewLeftChildEqualToPreviousLeftChild() {
		
		QuestionNode parent = new QuestionNode("value");
		QuestionNode leftChild = new QuestionNode("left value");
		parent.setLeftChild(leftChild);
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setLeftChild(new QuestionNode("left value"));
		});
	}
	
	@Test
	public void shouldSetNewLeftChild() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode leftChild = new QuestionNode("left value");
		
		parent.setLeftChild(leftChild);
		
		assertEquals("left value", parent.getLeftChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingLeftChild() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode oldLeftChild = new QuestionNode("old left value");
		QuestionNode newLeftChild = new QuestionNode("new left value");
		parent.setLeftChild(oldLeftChild);
		assertEquals("old left value", parent.getLeftChild().getNodeValue());
		parent.setLeftChild(newLeftChild);
		assertEquals("new left value", parent.getLeftChild().getNodeValue());
	}

}
