package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BinaryTree;

class TestConstructor {

	@Test
	public void shouldSetInitialValues() {
		BinaryTree tree = new BinaryTree();
		assertNull(tree.getRootNode());
	}

}
