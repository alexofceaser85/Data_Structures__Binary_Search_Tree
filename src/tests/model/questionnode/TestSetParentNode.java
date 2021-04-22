package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QuestionNode;
import model.TreeNode;

class TestSetParentNode {

	@Test
	public void shouldNotAllowNullParentNode() {
		
		QuestionNode parent = new QuestionNode("parent");
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		QuestionNode parent = new QuestionNode("parent");
		parent.setParentNode(new QuestionNode("value"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new QuestionNode("value"));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode newParent = new QuestionNode("new value");
		
		parent.setParentNode(newParent);
		
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		QuestionNode parent = new QuestionNode("value");
		QuestionNode oldParent = new QuestionNode("old value");
		QuestionNode newParent = new QuestionNode("new value");
		parent.setParentNode(oldParent);
		assertEquals("old value", parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals("new value", parent.getParentNode().getNodeValue());
	}

}
