package tests.model.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.NodeType;
import model.AnswerNode;
import model.BinaryTree;
import model.QuestionNode;

class TestInsertNode {

	@Test
	public void shouldNotInsertNodeWhenQuestionIsCurrentNode() {
		BinaryTree tree = new BinaryTree();
		
		tree.setRootNode(new AnswerNode("dog", NodeType.ANSWER));
		assertEquals("dog", tree.getCurrentNode().getNodeValue());
		tree.setCurrentNode(new QuestionNode("question", NodeType.QUESTION));
		
		assertThrows(IllegalArgumentException.class, () -> {
			tree.insertNode("question", "answer", NodeType.QUESTION, true);
		});
	}
	
	@Test
	public void shouldInsertOneQuestionIfResponseIsTrue() {
		BinaryTree tree = new BinaryTree();
		
		tree.setRootNode(new AnswerNode("dog", NodeType.ANSWER));
		assertEquals("dog", tree.getCurrentNode().getNodeValue());
		
		tree.insertNode("does it fly", "bird", NodeType.QUESTION, true);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		QuestionNode yesChild = (QuestionNode) tree.getRootNode();
		assertEquals("bird", yesChild.getLeftChild().getNodeValue());
		assertEquals("dog", yesChild.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldInsertOneQuestionIfResponseIsFalse() {
		BinaryTree tree = new BinaryTree();
		
		tree.setRootNode(new AnswerNode("dog", NodeType.ANSWER));
		assertEquals("dog", tree.getCurrentNode().getNodeValue());
		
		tree.insertNode("does it walk", "bird", NodeType.QUESTION, false);
		
		assertEquals("does it walk", tree.getRootNode().getNodeValue());
		QuestionNode root = (QuestionNode) tree.getRootNode();
		assertEquals("dog", root.getLeftChild().getNodeValue());
		assertEquals("bird", root.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldInsertManyQuestionsIfResponseIsTrue() {
		BinaryTree tree = new BinaryTree();
		
		tree.setRootNode(new AnswerNode("dog", NodeType.ANSWER));
		assertEquals("dog", tree.getCurrentNode().getNodeValue());
		
		tree.insertNode("does it fly", "bird", NodeType.QUESTION, true);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		QuestionNode root = (QuestionNode) tree.getRootNode();
		
		assertEquals("bird",root.getLeftChild().getNodeValue());
		assertEquals("dog", root.getRightChild().getNodeValue());
		
		AnswerNode rootYesChild = (AnswerNode) root.getLeftChild();
		AnswerNode rootNoChild = (AnswerNode) root.getRightChild();
		
		tree.setCurrentNode(rootYesChild);
		
		tree.insertNode("does it swim", "whale", NodeType.QUESTION, true);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		assertEquals("does it swim", root.getLeftChild().getNodeValue());
		QuestionNode newRootYesChild = (QuestionNode) root.getLeftChild();
		assertEquals("whale", newRootYesChild.getLeftChild().getNodeValue());
		assertEquals("bird", newRootYesChild.getRightChild().getNodeValue());
		
		
		tree.setCurrentNode(rootNoChild);
		
		tree.insertNode("does it have legs", "snake", NodeType.QUESTION, true);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		assertEquals("does it have legs", root.getRightChild().getNodeValue());
		QuestionNode newRootNoChild = (QuestionNode) root.getRightChild();
		assertEquals("snake", newRootNoChild.getLeftChild().getNodeValue());
		assertEquals("dog", newRootNoChild.getRightChild().getNodeValue());
	}
	
	@Test
	public void shouldInsertManyQuestionsIfResponseIsFalse() {
		BinaryTree tree = new BinaryTree();
		
		tree.setRootNode(new AnswerNode("duck", NodeType.ANSWER));
		assertEquals("duck", tree.getCurrentNode().getNodeValue());
		
		tree.insertNode("does it fly", "dog", NodeType.QUESTION, false);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		QuestionNode root = (QuestionNode) tree.getRootNode();
		
		assertEquals("duck",root.getLeftChild().getNodeValue());
		assertEquals("dog", root.getRightChild().getNodeValue());
		
		AnswerNode rootYesChild = (AnswerNode) root.getLeftChild();
		AnswerNode rootNoChild = (AnswerNode) root.getRightChild();
		
		tree.setCurrentNode(rootYesChild);
		
		tree.insertNode("does it swim", "pigeon", NodeType.QUESTION, false);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		assertEquals("does it swim", root.getLeftChild().getNodeValue());
		QuestionNode newRootYesChild = (QuestionNode) root.getLeftChild();
		assertEquals("duck", newRootYesChild.getLeftChild().getNodeValue());
		assertEquals("pigeon", newRootYesChild.getRightChild().getNodeValue());
		
		
		tree.setCurrentNode(rootNoChild);
		
		tree.insertNode("does it have legs", "snake", NodeType.QUESTION, false);
		
		assertEquals("does it fly", tree.getRootNode().getNodeValue());
		assertEquals("does it have legs", root.getRightChild().getNodeValue());
		QuestionNode newRootNoChild = (QuestionNode) root.getRightChild();
		assertEquals("dog", newRootNoChild.getLeftChild().getNodeValue());
		assertEquals("snake", newRootNoChild.getRightChild().getNodeValue());
	}

}
