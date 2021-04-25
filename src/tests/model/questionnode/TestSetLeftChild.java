package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;

class TestSetLeftChild {

	private final String nodeValue = "value";
	
	@Test
	public void shouldNotSetNullLeftChild() {
		QuestionNode parent = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setLeftChild(null);
		});
	}

	@Test
	public void shouldSetNewLeftChild() {
		QuestionNode parent = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("left value", NodeType.QUESTION);
		
		parent.setLeftChild(leftChild);
		
		assertEquals("left value", parent.getLeftChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingLeftChild() {
		QuestionNode parent = new QuestionNode(this.nodeValue, NodeType.QUESTION);
		QuestionNode oldLeftChild = new QuestionNode("old left value", NodeType.QUESTION);
		QuestionNode newLeftChild = new QuestionNode("new left value", NodeType.QUESTION);
		parent.setLeftChild(oldLeftChild);
		assertEquals("old left value", parent.getLeftChild().getNodeValue());
		parent.setLeftChild(newLeftChild);
		assertEquals("new left value", parent.getLeftChild().getNodeValue());
	}

}
