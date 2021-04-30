package viewmodel;

import java.io.File;
import java.io.FileNotFoundException;

import data.io.SaveBinaryTree;

/**
 * The view model to save the binary tree
 * 
 * @author Alex DeCesare
 * @version 30-April-2021
 */

public class SaveBinaryTreeViewModel {

	private SaveBinaryTree binaryTreeSaver;
	
	/**
	 * The constructor for the save binary tree view model
	 * 
	 * @precondition none
	 * @postcondition this.binaryTreeSaver = new SaveBinaryTree()
	 */
	
	public SaveBinaryTreeViewModel() {
		this.binaryTreeSaver = new SaveBinaryTree();
	}
	
	/**
	 * Saves a binary tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param theFileToSave the file to save the binary tree to
	 * @param theBinaryTree the binary tree to save
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	
	public void saveFile(File theFileToSave, BinaryTreeViewModel theBinaryTree) throws FileNotFoundException {
		this.binaryTreeSaver.saveFile(theFileToSave, theBinaryTree);
	}
	
}
