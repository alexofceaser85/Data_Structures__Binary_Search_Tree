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
		BinaryTree tree = new BinaryTree(NodeType.ANSWER);
		
		assertThrows(IllegalArgumentException.class, () -> {
			tree.setRootNode(null);
		});
	}
	
	@Test
	public void shouldSetNewRootToTreeNode() {
		BinaryTree tree = new BinaryTree(NodeType.ANSWER);
		tree.setRootNode(new QuestionNode("value"));
		
		assertEquals("value", tree.getRootNode().getNodeValue());
	}

}
