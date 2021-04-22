package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.BinaryTree;
import model.QuestionNode;
import model.TreeNode;

class TestSetRootNode {

	@Test
	public void shouldNotSetRootNodeToNull() {
		BinaryTree tree = new BinaryTree();
		
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setRootNode(null);
		});
	}
	
	@Test
	public void shouldSetNewRootToTreeNode() {
		BinaryTree tree = new BinaryTree();
		tree.setRootNode(new QuestionNode("value", NodeType.ANSWER));
		
		assertEquals("value", tree.getRootNode().getNodeValue());
	}

}
