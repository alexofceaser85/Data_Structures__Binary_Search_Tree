package viewmodel;

import java.io.File;
import java.io.FileNotFoundException;

import data.io.LoadBinaryTree;

/**
 * The view model for the load binary tree
 * 
 * @author Alex DeCesare
 * @version 30-April-2021
 */

public class LoadBinaryTreeViewModel {

	private LoadBinaryTree binaryTreeLoader;
	
	/**
	 * The constructor for the load binary tree view model
	 * 
	 * @precondition none
	 * @postcondition this.binaryTreeLoader = new LoadBinaryTree()
	 */
	
	public LoadBinaryTreeViewModel() {
		this.binaryTreeLoader = new LoadBinaryTree();
	}
	
	/**
	 * loads the binary tree
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param theFileToLoad the file to load into a binary tree
	 * 
	 * @return the loaded binary tree
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	
	public BinaryTreeViewModel loadBinaryTree(File theFileToLoad) throws FileNotFoundException {
		return this.binaryTreeLoader.loadBinaryTree(theFileToLoad);
	}
	
}
