package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import model.BinaryTree;

class TestConstructor {

	@Test
	public void shouldSetInitialValuesForAnswerType() {
		BinaryTree tree = new BinaryTree();
		assertNull(tree.getRootNode());
	}
	
	@Test
	public void shouldSetInitialValuesForQuestionType() {
		BinaryTree tree = new BinaryTree();
		assertNull(tree.getRootNode());
	}

}
