package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;
import model.QuestionNode;

class TestTraverseToRightChild {

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
		assertFalse(tree.traverseToRightChild());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithTwoLevels() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode("Bird", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("Bird", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Dog", NodeType.QUESTION, false);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Bird", question.getLeftChild().getNodeValue());
		assertEquals("Dog", question.getRightChild().getNodeValue());
		assertEquals("Dog",tree.getCurrentNode().getNodeValue());
		
		tree.setCurrentNode(tree.getRootNode());
		assertTrue(tree.traverseToRightChild());
		assertEquals("Dog", tree.getCurrentNode().getNodeValue());
	}
	
	@Test
	public void shouldReturnTrueForTreeWithThreeLevels() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		AnswerNode parent = new AnswerNode("Vulture", NodeType.ANSWER);
		tree.setRootNode(parent);
		assertEquals("Vulture", tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it fly?", "Dog", NodeType.QUESTION, false);
		assertEquals("Does it fly?", tree.getRootNode().getNodeValue());
		QuestionNode question = (QuestionNode) tree.getRootNode();
		assertEquals("Vulture", question.getLeftChild().getNodeValue());
		assertEquals("Dog", question.getRightChild().getNodeValue());
		assertEquals("Dog",tree.getCurrentNode().getNodeValue());

		tree.insertNode("Does it walk?", "Python", NodeType.QUESTION, false);
		assertEquals("Python", tree.getCurrentNode().getNodeValue());
		QuestionNode doesItWalk = (QuestionNode) tree.getCurrentNode().getParentNode();
		assertEquals("Dog", doesItWalk.getLeftChild().getNodeValue());

		tree.insertNode("Is it deadly to humans?", "Garden Snake", NodeType.QUESTION, false);
		assertEquals("Garden Snake", tree.getCurrentNode().getNodeValue());
		QuestionNode isItDeadly = (QuestionNode) tree.getCurrentNode().getParentNode();
		assertEquals("Python", isItDeadly.getLeftChild().getNodeValue());
		
		tree.setCurrentNode(tree.getRootNode());
		assertEquals("Does it fly?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToRightChild());
		assertEquals("Does it walk?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToRightChild());
		assertEquals("Is it deadly to humans?", tree.getCurrentNode().getNodeValue());
		
		assertTrue(tree.traverseToRightChild());
		assertEquals("Garden Snake", tree.getCurrentNode().getNodeValue());
	}

}
