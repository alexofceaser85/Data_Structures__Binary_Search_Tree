package tests.data.io.loadbinarytree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import data.filepaths.FilePaths;
import data.io.LoadBinaryTree;
import enums.NodeType;
import model.QuestionNode;
import viewmodel.BinaryTreeViewModel;

class TestLoadBinaryTree {

	private final String filePathForQuestionRootNodeLoadTests = FilePaths.TEST_FILE_FOR_LOAD_FILE_UNIT_TESTS + "\\MockTestLoadSingleQuestion";
	private final String filePathForAnswerRootNodeLoadTests = FilePaths.TEST_FILE_FOR_LOAD_FILE_UNIT_TESTS + "\\MockTestLoadSingleAnswer";
	private final String filePathForIncompatableRootNode = FilePaths.TEST_FILE_FOR_LOAD_FILE_UNIT_TESTS + "\\MockTestLoadIncompatibleRootNode";
	private final String filePathForFullBinaryTree = FilePaths.TEST_FILE_FOR_LOAD_FILE_UNIT_TESTS + "\\MockTestLoadFullBinaryTree";
	private final String filePathForIncompatableChildNode = FilePaths.TEST_FILE_FOR_LOAD_FILE_UNIT_TESTS + "\\MockTestLoadIncompatibleChildNode";
	
	@Test
	public void shouldNotLoadBinaryTreeWithNullFile() {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		
		assertThrows(IllegalArgumentException.class, () -> {
			treeLoader.loadBinaryTree(null);
		});
	}
	
	@Test
	public void shouldNotLoadIncompatibleRootNode() throws FileNotFoundException {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		File theFileToLoad = new File(this.filePathForIncompatableRootNode);
		
		assertThrows(IllegalArgumentException.class, () -> {
			treeLoader.loadBinaryTree(theFileToLoad);
		});
	}
	
	@Test
	public void shouldNotLoadBinaryTreeWithIncompatibleChildNode() throws FileNotFoundException {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		File theFileToLoad = new File(this.filePathForIncompatableChildNode);
		
		assertThrows(IllegalArgumentException.class, () -> {
			treeLoader.loadBinaryTree(theFileToLoad);
		});
	}

	@Test
	public void shouldLoadSingleQuestion() throws FileNotFoundException {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		File theFileToLoad = new File(this.filePathForQuestionRootNodeLoadTests);
		BinaryTreeViewModel tree = treeLoader.loadBinaryTree(theFileToLoad);
		
		assertEquals(tree.getRootNode().getNodeValue(), "Does it fly?");
		assertEquals(tree.getRootNode().getNodeType(), NodeType.QUESTION);
	}
	
	@Test
	public void shouldLoadSingleAnswer() throws FileNotFoundException {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		File theFileToLoad = new File(this.filePathForAnswerRootNodeLoadTests);
		BinaryTreeViewModel tree = treeLoader.loadBinaryTree(theFileToLoad);
		
		assertEquals(tree.getRootNode().getNodeValue(), "Bird");
		assertEquals(tree.getRootNode().getNodeType(), NodeType.ANSWER);
	}
	
	@Test
	public void shouldLoadFullBinaryTree() throws FileNotFoundException {
		LoadBinaryTree treeLoader = new LoadBinaryTree();
		File theFileToLoad = new File(this.filePathForFullBinaryTree);
		BinaryTreeViewModel tree = treeLoader.loadBinaryTree(theFileToLoad);
		
		assertEquals("Does it live in water?", tree.getRootNode().getNodeValue());
		assertEquals(NodeType.QUESTION, tree.getRootNode().getNodeType());
		tree.traverseToLeftChild();
		QuestionNode mammalQuestion = (QuestionNode) tree.getCurrentNode();
		
		assertEquals("Is it a mammal?", mammalQuestion.getNodeValue());
		assertEquals(NodeType.QUESTION, mammalQuestion.getNodeType());
		assertEquals("whale", mammalQuestion.getLeftChild().getNodeValue());
		assertEquals("goldfish", mammalQuestion.getRightChild().getNodeValue());
		
		tree.setCurrentNode(tree.getRootNode());
		
		tree.traverseToRightChild();
		QuestionNode carnivoreQuestion = (QuestionNode) tree.getCurrentNode();
		
		assertEquals("Is it a carnivore?", carnivoreQuestion.getNodeValue());
		assertEquals(NodeType.QUESTION, carnivoreQuestion.getNodeType());
		assertEquals("horse", carnivoreQuestion.getRightChild().getNodeValue());
		
		tree.traverseToLeftChild();
		QuestionNode flyQuestion = (QuestionNode) tree.getCurrentNode();
		
		assertEquals("Can it fly?", flyQuestion.getNodeValue());
		assertEquals(NodeType.QUESTION, flyQuestion.getNodeType());
		assertEquals("eagle", flyQuestion.getLeftChild().getNodeValue());
		assertEquals("dog", flyQuestion.getRightChild().getNodeValue());
	}
}
