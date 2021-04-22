package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import model.QuestionNode;

class TestSetParentNode {

	@Test
	public void shouldNotAllowNullParentNode() {
		
		AnswerNode parent = new AnswerNode("parent", NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		AnswerNode parent = new AnswerNode("parent", NodeType.ANSWER);
		parent.setParentNode(new AnswerNode("value", NodeType.ANSWER));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new AnswerNode("value", NodeType.ANSWER));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		AnswerNode parent = new AnswerNode("value", NodeType.ANSWER);
		AnswerNode newParent = new AnswerNode("new value", NodeType.ANSWER);
		
		parent.setParentNode(newParent);
		
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		AnswerNode parent = new AnswerNode("value", NodeType.ANSWER);
		AnswerNode oldParent = new AnswerNode("old value", NodeType.ANSWER);
		AnswerNode newParent = new AnswerNode("new value", NodeType.ANSWER);
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}

}
