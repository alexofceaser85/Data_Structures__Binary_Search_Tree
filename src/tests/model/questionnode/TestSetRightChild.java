package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestSetRightChild {

	@Test
	public void shouldNotSetNullRightChild() {
		QuestionNode parent = new QuestionNode("value");
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setRightChild(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		QuestionNode parent = new QuestionNode("parent");
		parent.setRightChild(new QuestionNode("value"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setRightChild(new QuestionNode("value"));
		});
	}
	
	@Test
	public void shouldSetNewRightChild() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode leftChild = new QuestionNode("right value");
		
		parent.setRightChild(leftChild);
		
		assertEquals("right value", parent.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingRightChild() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode oldRightChild = new QuestionNode("old right value");
		QuestionNode newRightChild = new QuestionNode("new right value");
		parent.setRightChild(oldRightChild);
		assertEquals("old right value", parent.getRightChild().getNodeValue());
		parent.setRightChild(newRightChild);
		assertEquals("new right value", parent.getRightChild().getNodeValue());
	}

}
