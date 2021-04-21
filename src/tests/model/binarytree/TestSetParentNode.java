package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BinaryTree;
import model.TreeNode;

class TestSetParentNode {

	@Test
	public void shouldSetNewRootToTreeNode() {
		BinaryTree tree = new BinaryTree();
		tree.setRootNode(new TreeNode("value"));
		
		assertEquals("value", tree.getRootNode().getNodeValue());
	}

}
