package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.BinaryTree;

class TestSetUserQuestion {

	@Test
	public void shouldNotSetNullUserQuestion() {
		BinaryTree tree = new BinaryTree();
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setUserQuestion(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyUserQuestion() {
		BinaryTree tree = new BinaryTree();
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setUserQuestion("");
		});
	}
	
	@Test
	public void shouldSetNewUserQuestion() {
		BinaryTree tree = new BinaryTree();
		tree.setUserQuestion("hello world");
		assertEquals("hello world", tree.getUserQuestion());
	}

}
