package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import model.QuestionNode;

class TestTraverseParent {

	private final String answerNodeValue = "Dog";
	
	@Test
	public void shouldReturnFalseForEmptyTree() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		assertFalse(tree.traverseToParent());
	}
	
	@Test
	public void shouldReturnFalseForTreeWithParent() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode("node", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("node", tree.getCurrentNode().getNodeValue());
		assertFalse(tree.traverseToParent());
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
		assertEquals("Dog", question.getRightChild().getNodeValue());
		assertEquals("Bird", tree.getCurrentNode().getNodeValue());
		assertTrue(tree.traverseToParent());
		assertEquals("Does it fly?", tree.getCurrentNode().getNodeValue());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithThreeLevels() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode(this.answerNodeValue, NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals(this.answerNodeValue, tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Duck", NodeType.QUESTION, true);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Duck", question.getLeftChild().getNodeValue());
		assertEquals(this.answerNodeValue, question.getRightChild().getNodeValue());
		assertEquals("Duck", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it swim?", "Vulture", NodeType.QUESTION, false);
		assertEquals("Vulture", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Can it jump up and down?", "Human", NodeType.QUESTION, false);
		assertEquals("Human", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToParent());
		assertEquals("Can it jump up and down?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToParent());
		assertEquals("Does it swim?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToParent());
		assertEquals("Does it fly?", tree.getCurrentNode().getNodeValue());
	}

}
