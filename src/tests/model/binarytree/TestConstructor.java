package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.BinaryTree;

class TestConstructor {

	@Test
	public void shouldSetInitialValuesForAnswerType() {
		BinaryTree tree = new BinaryTree(NodeType.ANSWER);
		assertNull(tree.getRootNode());
		assertEquals(NodeType.ANSWER, tree.getNodeType());
	}
	
	@Test
	public void shouldSetInitialValuesForQuestionType() {
		BinaryTree tree = new BinaryTree(NodeType.QUESTION);
		assertNull(tree.getRootNode());
		assertEquals(NodeType.QUESTION, tree.getNodeType());
	}

}
