package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestSetParentNode {

	@Test
	public void shouldNotAllowNullParentNode() {
		
		QuestionNode parent = new QuestionNode("parent", NodeType.QUESTION);
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		QuestionNode parent = new QuestionNode("parent", NodeType.QUESTION);
		parent.setParentNode(new QuestionNode("value", NodeType.QUESTION));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new QuestionNode("value", NodeType.QUESTION));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode newParent = new QuestionNode("new value", NodeType.QUESTION);
		
		parent.setParentNode(newParent);
		
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode oldParent = new QuestionNode("old value", NodeType.QUESTION);
		QuestionNode newParent = new QuestionNode("new value", NodeType.QUESTION);
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}

}
