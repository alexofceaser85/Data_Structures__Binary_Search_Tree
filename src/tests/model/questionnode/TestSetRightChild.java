package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestSetRightChild {

	@Test
	public void shouldNotSetNullRightChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setRightChild(null);
		});
	}
	
//	@Test
//	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
//		
//		QuestionNode parent = new QuestionNode("parent", NodeType.QUESTION);
//		parent.setRightChild(new QuestionNode("value", NodeType.QUESTION));
//		
//		assertThrows(IllegalArgumentException.class, () -> {
//			parent.setRightChild(new QuestionNode("value", NodeType.QUESTION));
//		});
//	}
	
	@Test
	public void shouldSetNewRightChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("right value", NodeType.QUESTION);
		
		parent.setRightChild(leftChild);
		
		assertEquals("right value", parent.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingRightChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode oldRightChild = new QuestionNode("old right value", NodeType.QUESTION);
		QuestionNode newRightChild = new QuestionNode("new right value", NodeType.QUESTION);
		parent.setRightChild(oldRightChild);
		assertEquals("old right value", parent.getRightChild().getNodeValue());
		parent.setRightChild(newRightChild);
		assertEquals("new right value", parent.getRightChild().getNodeValue());
	}

}
