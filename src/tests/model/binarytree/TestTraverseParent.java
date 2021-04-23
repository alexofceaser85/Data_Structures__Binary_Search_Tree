package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import model.BinaryTree;
import model.QuestionNode;

class TestTraverseParent {

	@Test
	public void shouldReturnFalseForEmptyTree() {
		BinaryTree tree = new BinaryTree();
		assertFalse(tree.traverseToParent());
	}
	
	@Test
	public void shouldReturnFalseForTreeWithParent() {
		BinaryTree tree = new BinaryTree();
		AnswerNode parent = new AnswerNode("node", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("node", tree.getCurrentNode().getNodeValue());
		assertFalse(tree.traverseToParent());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithTwoLevels() {
		BinaryTree tree = new BinaryTree();
		AnswerNode parent = new AnswerNode("Dog", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("Dog", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Bird", NodeType.QUESTION, true);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Bird", question.getLeftChild().getNodeValue());
		assertEquals("Dog", question.getRightChild().getNodeValue());
		assertEquals("Bird",tree.getCurrentNode().getNodeValue());
		assertTrue(tree.traverseToParent());
		assertEquals("Does it fly?", tree.getCurrentNode().getNodeValue());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithThreeLevels() {
		BinaryTree tree = new BinaryTree();
		AnswerNode parent = new AnswerNode("Dog", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("Dog", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Duck", NodeType.QUESTION, true);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Duck", question.getLeftChild().getNodeValue());
		assertEquals("Dog", question.getRightChild().getNodeValue());
		assertEquals("Duck",tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it swim?", "Vulture", NodeType.QUESTION, false);
		assertEquals("Vulture",tree.getCurrentNode().getNodeValue());

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
