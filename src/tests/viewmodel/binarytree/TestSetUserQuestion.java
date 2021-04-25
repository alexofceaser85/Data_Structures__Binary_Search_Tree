package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import viewmodel.BinaryTreeViewModel;

class TestSetUserQuestion {

	@Test
	public void shouldNotSetNullUserQuestion() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setUserQuestion(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyUserQuestion() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setUserQuestion("");
		});
	}
	
	@Test
	public void shouldSetNewUserQuestion() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		tree.setUserQuestion("hello world");
		assertEquals("hello world", tree.getUserQuestion());
	}
}
