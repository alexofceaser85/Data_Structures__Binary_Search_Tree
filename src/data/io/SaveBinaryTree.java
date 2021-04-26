package data.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.graalvm.compiler.nodes.calc.BinaryNode;

import enums.NodeType;
import model.BinaryTree;
import model.QuestionNode;
import model.TreeNode;
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
		String data = "";
		
		PreOrderIterator iterator = new PreOrderIterator(theBinaryTree);
		while(iterator.hasNext()) {
			TreeNode nextNode = iterator.next();
			data += nextNode.getNodeValue() + System.lineSeparator() + nextNode.getNodeType() + System.lineSeparator();
		}

		PrintWriter savedFile = new PrintWriter(theFile);

		savedFile.write(data);
		savedFile.close();
		
	}
	
	protected class PreOrderIterator implements Iterator<TreeNode> {
		
        private Stack<TreeNode> preOrderStack;

		/**
		 * The constructor for the pre order iterator
		 * 
		 * @precondition none
		 * @postcondition none
		 */
        
        public PreOrderIterator(BinaryTreeViewModel theBinaryTreeToIterate) {
            this.preOrderStack = new Stack<TreeNode>();
            this.preOrderStack.add(theBinaryTreeToIterate.getRootNode());
        }

        @Override
        public boolean hasNext() {
            return !this.preOrderStack.isEmpty();
        }

        @Override
        public TreeNode next() {
            if (!this.hasNext()) {
            	throw new NoSuchElementException("No more nodes remain to iterate");
            }

            final TreeNode node = this.preOrderStack.pop();           

            if (node.getNodeType().equals(NodeType.QUESTION)) {
            	QuestionNode questionNode = (QuestionNode) node;
                if (questionNode.hasRightChild()) {
                	this.preOrderStack.push(questionNode.getRightChild());
                }
                if (questionNode.hasLeftChild()) {
                	this.preOrderStack.push(questionNode.getLeftChild());
                }
            }

            return node;
        }

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
}
