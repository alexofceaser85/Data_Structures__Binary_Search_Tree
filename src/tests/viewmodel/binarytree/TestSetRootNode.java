package tests.viewmodel.binarytree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import viewmodel.BinaryTreeViewModel;
import model.QuestionNode;

class TestSetRootNode {

	@Test
	public void shouldNotSetRootNodeToNull() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setRootNode(null);
		});
	}
	
	@Test
	public void shouldSetNewRootToTreeNode() {
		BinaryTreeViewModel tree = new BinaryTreeViewModel();
		tree.setRootNode(new QuestionNode("value", NodeType.ANSWER));
		
		assertEquals("value", tree.getRootNode().getNodeValue());
	}

}
