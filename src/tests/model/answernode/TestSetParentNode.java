package tests.model.answernode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;

class TestSetParentNode {

	private final String answerNodeValue = "parent";
	private final String parentNodeValue = "value";
	private final String newNodeValue = "new value";
	private final String oldNodeValue = "old value";
	
	@Test
	public void shouldNotAllowNullParentNode() {
		
		AnswerNode parent = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		AnswerNode parent = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		parent.setParentNode(new AnswerNode(this.parentNodeValue, NodeType.ANSWER));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new AnswerNode(this.parentNodeValue, NodeType.ANSWER));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		AnswerNode parent = new AnswerNode(this.parentNodeValue, NodeType.ANSWER);
		AnswerNode newParent = new AnswerNode(this.newNodeValue, NodeType.ANSWER);
		
		parent.setParentNode(newParent);
		
		assertEquals(this.newNodeValue, parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		AnswerNode parent = new AnswerNode(this.parentNodeValue, NodeType.ANSWER);
		AnswerNode oldParent = new AnswerNode(this.oldNodeValue, NodeType.ANSWER);
		AnswerNode newParent = new AnswerNode(this.newNodeValue, NodeType.ANSWER);
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals(this.newNodeValue, parent.getParentNode().getNodeValue());
	}

}
