package tests.model.questionnode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.QuestionNode;
import model.TreeNode;

class TestSetLeftChild {

	@Test
	public void shouldNotSetNullLeftChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		assertThrows(IllegalArgumentException.class, () -> {
			parent.setLeftChild(null);
		});
	}
	
//	@Test
//	public void shouldNotSetNewLeftChildEqualToPreviousLeftChild() {
//		
//		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
//		QuestionNode leftChild = new QuestionNode("left value", NodeType.QUESTION);
//		parent.setLeftChild(leftChild);
//		assertThrows(IllegalArgumentException.class, () -> {
//			parent.setLeftChild(new QuestionNode("left value", NodeType.QUESTION));
//		});
//	}
//	
	@Test
	public void shouldSetNewLeftChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode leftChild = new QuestionNode("left value", NodeType.QUESTION);
		
		parent.setLeftChild(leftChild);
		
		assertEquals("left value", parent.getLeftChild().getNodeValue());
	}
	
	@Test
	public void shouldReplaceExistingLeftChild() {
		QuestionNode parent = new QuestionNode("value", NodeType.QUESTION);
		QuestionNode oldLeftChild = new QuestionNode("old left value", NodeType.QUESTION);
		QuestionNode newLeftChild = new QuestionNode("new left value", NodeType.QUESTION);
		parent.setLeftChild(oldLeftChild);
		assertEquals("old left value", parent.getLeftChild().getNodeValue());
		parent.setLeftChild(newLeftChild);
		assertEquals("new left value", parent.getLeftChild().getNodeValue());
	}

}
