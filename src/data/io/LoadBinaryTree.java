package data.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

import data.io.SaveBinaryTree.PreOrderIterator;
import enums.NodeType;
import model.AnswerNode;
import model.BinaryTree;
import model.QuestionNode;
import model.TreeNode;
import viewmodel.BinaryTreeViewModel;

public class LoadBinaryTree {

	private ArrayList<String> fileData;
	
	/**
	 * Loads the binary tree
	 * 
	 * @precondition none
	 * @postcondition this.fileData = new ArrayList<String>()
	 */
	
	public LoadBinaryTree() {
		this.fileData = new ArrayList<String>();
	}
	
	/**
	 * Loads the binary tree from a file
	 * 
	 * @precondition theFileToLoad != null
	 * @postcondition none
	 * 
	 * @return theBinaryTree the loaded binary tree
	 * @throws FileNotFoundException 
	 */
	
	public BinaryTreeViewModel loadBinaryTree(File theFileToLoad) throws FileNotFoundException {
		if (theFileToLoad == null) {
			throw new IllegalArgumentException("the file to load cannot be null");
		}
		
		BinaryTreeViewModel theBinaryTree = new BinaryTreeViewModel();
		
		
		File theFile = new File(theFileToLoad.getAbsolutePath());
		Scanner fileScanner = new Scanner(theFile);
		
		String nodeValue = fileScanner.nextLine();
		String nodeType = fileScanner.nextLine();
		
		if (nodeType.equals(NodeType.QUESTION.toString())) {
			theBinaryTree.setRootNode(new QuestionNode(nodeValue, NodeType.QUESTION));
		} else {
			theBinaryTree.setRootNode(new AnswerNode(nodeValue, NodeType.ANSWER));
		}
		
		this.loadSubtree(theBinaryTree, theBinaryTree.getRootNode(), fileScanner, nodeValue, nodeType, true);
//		System.out.println(question.getLeftChild().getNodeValue());
//		System.out.println(question.getRightChild().getNodeValue());
		
		return theBinaryTree;
	}
	
	private void loadSubtree(BinaryTreeViewModel binaryTree, TreeNode node, Scanner fileScanner, String oldNodeValue, String oldNodeType, boolean shouldGetNewNodeValue) {
		
		String nodeValue = null;
		String nodeType = null;
		
		if (shouldGetNewNodeValue) {
			if (fileScanner.hasNextLine()) {
				nodeValue = fileScanner.nextLine();
			} else {
				return;
			}
			if (fileScanner.hasNextLine()) {
				nodeType = fileScanner.nextLine();
			} else {
				return;
			}
		} else {
			nodeValue = oldNodeValue;
			nodeType = oldNodeType;
		}
		
		QuestionNode questionNode = (QuestionNode) node;

		if (nodeType.equals(NodeType.ANSWER.toString())) {
			if (!questionNode.hasLeftChild()) {
				AnswerNode leftChild = new AnswerNode(nodeValue, NodeType.ANSWER);
				questionNode.setLeftChild(leftChild);
				leftChild.setParentNode(questionNode);
				this.loadSubtree(binaryTree, questionNode, fileScanner, nodeValue, nodeType, true);
			} 
			if (!questionNode.hasRightChild()) {
				AnswerNode rightChild = new AnswerNode(nodeValue, NodeType.ANSWER);
				questionNode.setRightChild(rightChild);
				rightChild.setParentNode(questionNode);
			}
			if (questionNode.hasLeftChild() && questionNode.hasRightChild()) {
				
				String newNodeValue = null;
				if (fileScanner.hasNextLine()) {
					newNodeValue = fileScanner.nextLine();
				} else {
					return;
				}
				String newNodeType = null;
				if (fileScanner.hasNextLine()) {
					newNodeType = fileScanner.nextLine();
				} else {
					return;
				}

				this.loadSubtree(binaryTree, questionNode.getParentNode(), fileScanner, newNodeValue, newNodeType, false);
			}
		} else if (nodeType.equals(NodeType.QUESTION.toString())) {
			if (!questionNode.hasLeftChild()) {
				QuestionNode leftChild = new QuestionNode(nodeValue, NodeType.QUESTION);
				questionNode.setLeftChild(leftChild);
				leftChild.setParentNode(questionNode);
				this.loadSubtree(binaryTree, leftChild, fileScanner, nodeValue, nodeType, true);
			} 
			if (!questionNode.hasRightChild()) {
				QuestionNode rightChild = new QuestionNode(nodeValue, NodeType.QUESTION);
				questionNode.setRightChild(rightChild);
				rightChild.setParentNode(questionNode);
				this.loadSubtree(binaryTree, rightChild, fileScanner, nodeValue, nodeType, true);
			} 

			if (questionNode.hasLeftChild() && questionNode.hasRightChild()) {
				
				String newNodeValue = null;
				if (fileScanner.hasNextLine()) {
					newNodeValue = fileScanner.nextLine();
				} else {
					return;
				}
				String newNodeType = null;
				if (fileScanner.hasNextLine()) {
					newNodeType = fileScanner.nextLine();
				} else {
					return;
				}
				
				this.loadSubtree(binaryTree, questionNode.getParentNode(), fileScanner, newNodeValue, newNodeType, false);
			}
		} else {
			System.out.println("wrong value");
		}
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
