package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import model.QuestionNode;

class TestTraverseToLeftChild {

	private final String answerNodeValue = "Dog";
	
	@Test
	public void shouldReturnFalseForEmptyTree() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			tree.traverseToLeftChild();
		});
	}
	
	@Test
	public void shouldReturnFalseForTreeWithParent() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode("node", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("node", tree.getCurrentNode().getNodeValue());
		assertFalse(tree.traverseToLeftChild());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithTwoLevels() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals(this.answerNodeValue, tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Bird", NodeType.QUESTION, true);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Bird", question.getLeftChild().getNodeValue());
		assertEquals(this.answerNodeValue, question.getRightChild().getNodeValue());
		assertEquals("Bird", tree.getCurrentNode().getNodeValue());
		
		tree.setCurrentNode(tree.getRootNode());
		assertTrue(tree.traverseToLeftChild());
		assertEquals("Bird", tree.getCurrentNode().getNodeValue());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithThreeLevels() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals(this.answerNodeValue, tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Vulture", NodeType.QUESTION, true);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Vulture", question.getLeftChild().getNodeValue());
		assertEquals(this.answerNodeValue, question.getRightChild().getNodeValue());
		assertEquals("Vulture", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it swim?", "Duck", NodeType.QUESTION, true);
		assertEquals("Duck", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Can it jump up and down?", "Human", NodeType.QUESTION, true);
		assertEquals("Human", tree.getCurrentNode().getNodeValue());
		
		tree.setCurrentNode(tree.getRootNode());
		assertEquals("Does it fly?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToLeftChild());
		assertEquals("Does it swim?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToLeftChild());
		assertEquals("Can it jump up and down?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToLeftChild());
		assertEquals("Human", tree.getCurrentNode().getNodeValue());
	}

}
