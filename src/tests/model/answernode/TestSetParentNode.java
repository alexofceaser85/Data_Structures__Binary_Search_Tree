package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AnswerNode;
import model.QuestionNode;

class TestSetParentNode {

	@Test
	public void shouldNotAllowNullParentNode() {
		
		AnswerNode parent = new AnswerNode("parent");
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		AnswerNode parent = new AnswerNode("parent");
		parent.setParentNode(new AnswerNode("value"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new AnswerNode("value"));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		AnswerNode parent = new AnswerNode("value");
		AnswerNode newParent = new AnswerNode("new value");
		
		parent.setParentNode(newParent);
		
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		AnswerNode parent = new AnswerNode("value");
		AnswerNode oldParent = new AnswerNode("old value");
		AnswerNode newParent = new AnswerNode("new value");
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}

}
