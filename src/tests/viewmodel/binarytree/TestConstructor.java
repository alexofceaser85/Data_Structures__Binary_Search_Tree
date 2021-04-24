package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import viewmodel.BinaryTreeViewModel;

class TestConstructor {

	@Test
	public void shouldInstantiateValues() {
		BinaryTreeViewModel binaryTree = new BinaryTreeViewModel();
		assertNotNull(binaryTree.getBinaryTree());
	}

}
