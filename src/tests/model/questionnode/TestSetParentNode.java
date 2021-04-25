package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;

class TestSetParentNode {
	
	private final String parentValue = "parent";
	private final String newParentValue = "value";
	private final String newValue = "new value";
	private final String oldValue = "old value";

	@Test
	public void shouldNotAllowNullParentNode() {
		
		QuestionNode parent = new QuestionNode(this.parentValue, NodeType.QUESTION);
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(null);
		});
	}
	
	@Test
	public void shouldNotSetNewRightChildEqualToPreviousRightChild() {
		
		QuestionNode parent = new QuestionNode(this.parentValue, NodeType.QUESTION);
		parent.setParentNode(new QuestionNode(this.newParentValue, NodeType.QUESTION));
		
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setParentNode(new QuestionNode(this.newParentValue, NodeType.QUESTION));
		});
	}
	
	@Test
	public void shouldSetNewParent() {
		QuestionNode parent = new QuestionNode(this.newParentValue, NodeType.QUESTION);
		QuestionNode newParent = new QuestionNode(this.newValue, NodeType.QUESTION);
		
		parent.setParentNode(newParent);
		
		assertEquals(this.newValue, parent.getParentNode().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingParent() {
		QuestionNode parent = new QuestionNode(this.newParentValue, NodeType.QUESTION);
		QuestionNode oldParent = new QuestionNode(this.oldValue, NodeType.QUESTION);
		QuestionNode newParent = new QuestionNode(this.newValue, NodeType.QUESTION);
		parent.setParentNode(oldParent);
		assertEquals(this.oldValue, parent.getParentNode().getNodeValue());
		parent.setParentNode(newParent);
		assertEquals(this.newValue, parent.getParentNode().getNodeValue());
	}

}
