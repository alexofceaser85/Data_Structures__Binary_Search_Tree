package tests.data.io.savebinarytree;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import data.filepaths.FilePaths;
import data.io.SaveBinaryTree;
import enums.NodeType;
import model.AnswerNode;
import viewmodel.BinaryTreeViewModel;

class TestSaveFile {

	private final String filePathForRootNodeSaveTests = FilePaths.TEST_FILE_FOR_SAVE_FILE_UNIT_TESTS + "\\shouldSaveFileWithRootNode";
	
	@Test
	public void shouldSaveFileWithRootNode() throws FileNotFoundException {
		File newFile = new File(this.filePathForRootNodeSaveTests);
		BinaryTreeViewModel theTree = new BinaryTreeViewModel();
		theTree.setRootNode(new AnswerNode("answer", NodeType.ANSWER));
		SaveBinaryTree saveBinaryTree = new SaveBinaryTree();
		saveBinaryTree.saveFile(newFile, theTree);
	}

}
