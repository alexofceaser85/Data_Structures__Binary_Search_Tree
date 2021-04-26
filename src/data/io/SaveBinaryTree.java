package data.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import viewmodel.BinaryTreeViewModel;

/**
 * Saves a binary tree
 * 
 * @author Alex DeCesare
 * @version 25-April-2021
 */

public class SaveBinaryTree {

	/**
	 * The constructor for the save binary tree
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public SaveBinaryTree() {
		
	}
	
	/**
	 * Saves the binary tree to a file
	 * 
	 * @precondition theFileToSave != null && theBinaryTree != null && theBinaryTree.getRootNode != null
	 * @postcondition none
	 * 
	 * @param theFileToSave the file to save the binary tree to
	 * @param theBinaryTree the binary tree to save
	 * 
	 * @throws FileNotFoundException throws a file not found exception if the file is not found
	 */
	
	public void saveFile(File theFileToSave, BinaryTreeViewModel theBinaryTree) throws FileNotFoundException {
		
		if (theFileToSave == null) {
			throw new IllegalArgumentException("the file to save cannot be null");
		}
		if (theBinaryTree == null) {
			throw new IllegalArgumentException("the binary tree to save cannot be null");
		}
		if (theBinaryTree.getRootNode() == null) {
			throw new IllegalArgumentException("the binary tree needs a root node");
		}
		
		File theFile = new File(theFileToSave.getAbsolutePath());
		System.out.println(theFile);
		theBinaryTree.setCurrentNode(theBinaryTree.getRootNode());
		String data = theBinaryTree.getCurrentNode().getNodeValue() + System.lineSeparator() + theBinaryTree.getCurrentNode().getNodeType();
		
		PrintWriter savedFile = new PrintWriter(theFile);

		savedFile.write(data);
		savedFile.close();
		
	}
	
}
