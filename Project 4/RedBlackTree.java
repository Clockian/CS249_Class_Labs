/*
 * Created by Jasque Saydyk
 * Project 04 - Binary Trees
 * CS 249
 * 24 April 2017
 * Description - This class creates a Red Black Tree
*/
import java.util.NoSuchElementException;

public class RedBlackTree<K extends Comparable<K>, E> implements IBinarySearchTree<K, E>{

	private Node<K, E> root;
	private int size = 0;
	
	public RedBlackTree(){
		root = null;
	}
	
	public RedBlackTree(K key, E data){
		root = new Node<>(true, key, data);
		size++;
	}
	
	/**
	 * Adds a node to the tree containing this key element combination, then check the
	 * tree and fixes any problems with. The check and fixes are recursive
	 * Must follow the four rules of a Red Black tree
	 * 1. The root must be Black
	 * 2. Every null leaf is Black
	 * 3. There must be the same number of Black nodes to all leaves
	 * 4. If a node is Red, then both children must be Black
	 * false -> Red, true -> Black
	 */
	@Override
	public void put(K key, E element) {
		Node<K, E> node = placeInitialRedValue(key, element);
		
		if(node == null){
			return;
		}
		else{
			checkPutCase1(node);
		}
	}
	
	/**
	 * Places the value in the tree as a Red value where it belongs
	 */
	private Node<K, E> placeInitialRedValue(K key, E element){
		Node<K, E> currentNode = root;
		Node<K, E> addingNode = new Node<>(false, key, element);
		
		// Root is setup using default constructor making it null
		if(root == null){  
			root = addingNode;
			root.parent = null;
			size++;
			return root;
		}
		else{
			while(true){
				if(key.compareTo(currentNode.key) < 0){
					if(currentNode.left == null){
						currentNode.left = addingNode;
						addingNode.parent = currentNode;
						size++;
						return addingNode;
					}
					else{
						currentNode = currentNode.left;
					}
				}
				else if(key.compareTo(currentNode.key) > 0){
					if(currentNode.right == null){
						currentNode.right = addingNode;
						addingNode.parent = currentNode;
						size++;
						return addingNode;
					}
					else{
						currentNode = currentNode.right;
					}
				}
				// No addition to tree, only change the node
				else if(key.compareTo(currentNode.key) == 0){
					currentNode.data = element;
					return null;
				}
				else{
					System.out.println("Something went wrong when adding the node");
				}
			}
		}
	}
	
	/**
	 * Beginning of a line of recursive functions to fix the tree if there are problems with it
	 * CASE 1: Make root Black if needed
	 */
	private void checkPutCase1(Node<K, E> node){
		if(node.key.compareTo(root.key) == 0){
			root.color = true;
			return;
		}
		else{
			checkPutCase2(node);
		}
	}
		
	/**
	 * CASE 2: Check if node and Parent are Red, and quit if not
	 */
	private void checkPutCase2(Node<K, E> node){
		if(node.parent.color == true || node.color == true){
			return;
		}
		else{
			checkPutCase3(node);
		}
	}
		
	/**
	 * CASE 3: Check if Parent and Uncle are Red, if so, turn Black and turn Grandparent Red
	 */
	private void checkPutCase3(Node<K, E> node){
		Node<K, E> uncle = getUncle(node);
		if(uncle != null && uncle.color == false){
			node.parent.color = true;
			uncle.color = true;
			Node<K, E> grandParent = getGrandParent(node);
			grandParent.color = false;
			checkPutCase1(grandParent);
		}
		else{
			checkPutCase4(node);
		}
	}
	
	/**
	 * CASE 4: Check if the rotation that needs to be performed is going to be on Bent structure
	 */
	private void checkPutCase4(Node<K, E> node){
		Node<K, E> grandParent = getGrandParent(node);
		if(node == node.parent.right && node.parent == grandParent.left){
			rotateLeft_Bent(node.parent);
			node = node.left;
		}
		else if(node == node.parent.left && node.parent == grandParent.right){
			rotateRight_Bent(node.parent);
			node = node.right;
		}
		checkPutCase5(node);
	}
	
	/**
	 * CASE 5: Perform rotation on Straight node structure
	 */
	private void checkPutCase5(Node<K, E> node){
		Node<K, E> grandParent = getGrandParent(node);
		node.parent.color = true;
		grandParent.color = false;
		//System.out.println(node.key);
		if(node == node.parent.left){
			rotateRight_Line(grandParent);
		}
		else{
			rotateLeft_Line(grandParent);
		}
		
		//System.out.println(node.key + "  case 5");
		if(node.parent == root){
			root.color = true;
			return;
		}
		else{
			//node.parent.left.color = true;
			//node.parent.right.color = true;
			checkPutCase1(node.parent);
		}
	}
	
	/**
	 * Performs a left rotation on a line structure
	 */
	private void rotateLeft_Line(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedRightChild_Left = node.right.left;
		Node<K, E> savedRightChild = node.right;
		
		savedRightChild.parent = savedParent;
		if(savedParent != null){
			savedParent.right = savedRightChild;
		}
		node.right = savedRightChild_Left;
		if(savedRightChild_Left != null){
			savedRightChild_Left.parent = node;
		}
		node.parent = savedRightChild;
		savedRightChild.left = node;
		if(savedRightChild.parent == null){
			root = savedRightChild;
		}
	}
	
	/**
	 * Performs a left rotation on a bent structure
	 */
	private void rotateLeft_Bent(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedRightChild_Left = node.right.left;
		Node<K, E> savedRightChild = node.right;
		
		savedRightChild.parent = savedParent;
		if(savedParent != null){
			savedParent.left = savedRightChild;
		}
		node.right = savedRightChild_Left;
		if(savedRightChild_Left != null){
			savedRightChild_Left.parent = node;
		}
		node.parent = savedRightChild;
		savedRightChild.left = node;
		if(savedRightChild.parent == null){
			root = savedRightChild;
		}
	}
	
	/**
	 * Performs a right rotation on a line structure
	 */
	private void rotateRight_Line(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedLeftChild_Right = node.left.right;
		Node<K, E> savedLeftChild = node.left;
		
		savedLeftChild.parent = savedParent;
		if(savedParent != null){
			savedParent.left = savedLeftChild;
		}
		node.left = savedLeftChild_Right;
		if(savedLeftChild_Right != null){
			savedLeftChild_Right.parent = node;
		}
		node.parent = savedLeftChild;
		savedLeftChild.right = node;
		if(savedLeftChild.parent == null){
			root = savedLeftChild;
		}
	}
	
	/**
	 * Performs a right rotation on a bent structure
	 */
	private void rotateRight_Bent(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedLeftChild_Right = node.left.right;
		Node<K, E> savedLeftChild = node.left;
		
		savedLeftChild.parent = savedParent;
		if(savedParent != null){
			savedParent.right = savedLeftChild;
		}
		node.left = savedLeftChild_Right;
		if(savedLeftChild_Right != null){
			savedLeftChild_Right.parent = node;
		}
		node.parent = savedLeftChild;
		savedLeftChild.right = node;
		if(savedLeftChild.parent == null){
			root = savedLeftChild;
		}
	}
	
	/**
	 * Gets the GrandParent of the current node
	 */
	private Node<K, E> getGrandParent(Node<K, E> node){
		if(node != null && node.parent != null){
			return node.parent.parent;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Gets the Uncle of the current node
	 */
	private Node<K, E> getUncle(Node<K, E> node){
		Node<K, E> grandParent = getGrandParent(node);
		if(grandParent == null){
			return null;
		}
		if(node.parent == grandParent.left){
			return grandParent.right;
		}
		else{
			return grandParent.left;
		}
	}
	
	/**
	 * Retrieves an element from the tree based on the key.
	 * Throws a NoSuchElementException if no such key exists.
	 */
	@Override
	public E get(K key) {
		Node<K, E> currentNode = root;
		while(true){
			if(currentNode == null){  // Root is setup using default constructor making it null
				throw new NoSuchElementException();
			}
			if(key.compareTo(currentNode.key) < 0){
				if(currentNode.left == null){
					throw new NoSuchElementException();
				}
				else{
					currentNode = currentNode.left;
				}
			}
			else if(key.compareTo(currentNode.key) > 0){
				if(currentNode.right == null){
					throw new NoSuchElementException();
				}
				else{
					currentNode = currentNode.right;
				}
			}
			else if(key.compareTo(currentNode.key) == 0){
				return currentNode.data;
			}
			else{
				System.out.println("Something went wrong when getting the node");
			}
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the highest distance from the root to a leaf node in the entire
     * tree.
	 */
	@Override
	public int getHeight() {
		if(root == null){
			return 0;
		}
		// Subtract one as it includes the root in the height
		return getRecursiveHeight(root);
	}
	
	/**
	 * Obtains the height of the tree using recursion
	 */
	private int getRecursiveHeight(Node<K, E> node){
		// Terminates branch and sends it back up
		if(node == null || node.left == null || node.right == null){
			return 0;
		}
		
		int left = getRecursiveHeight(node.left);
		int right = getRecursiveHeight(node.right);
		
		if(left > right){
			return left + 1;
		}
		else{
			return right + 1;
		}
	}
	
	/**
	 * Gets the height of the shortest branch of the tree
	 */
	public int getMinimumHeight() {
		if(root == null){
			return 0;
		}
		// Subtract one as it includes the root in the height
		return this.getRecursiveMinHeight(root) - 1;
	}
	
	/**
	 * Recursive implementation to obtain the height of the tree
	 */
	private int getRecursiveMinHeight(Node<K, E> node){
		// Terminates branch and sends it back up
		if(node == null){
			return 0;
		}
		
		int left = getRecursiveHeight(node.left);
		int right = getRecursiveHeight(node.right);
		
		if(left < right){
			return left + 1;
		}
		else{
			return right + 1;
		}
	}
	
	/**
	 * Returns this map in string form, surrounded by [] brackets and with each
     * items separated by a comma and space. each key element pair should be
     * written as key: element.  For example:
     * [1: Dog, 2: Cat, 3: Bird, 4: Cow]
     * the order of pairs should be in ascending key order.
     * @return String representing the tree formated to look similar to an array
     * Ex. [1: Dog, 2: Cat, 3: Bird, 4: Cow]
	 */
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		
		if(root == null){
			return "[]";
		}
		else{
			s = (inOrder(root, s));
			s.delete(s.length() - 2, s.length());
			s.insert(0, "[");
			s.append("]");
			
			String result = s.toString();
			return result;
		}
	}
	
	/**
	 * Performs an inOrder() recursion on the tree
	 */
	private StringBuilder inOrder(Node<K, E> root, StringBuilder s){
		if(root.left != null){
			inOrder(root.left, s);
		}
		
		s.append(root.key + ": " + root.data + ", ");
		
		if(root.right != null){
			inOrder(root.right, s);
		}
		return s;
	}

	/**
	 * Returns a string depiction of this BST as a tree.  Each node is depicted
     * as [Key, LeftBranch, RightBranch] where LeftBranch and RightBranch are
     * either null or another node.  In a Red-Black tree use [Color, Key,
     * LeftBranch, RightBranch] instead.  Should the tree be empty return [].
	 */
	@Override
	public String getTreeString() {
		if(root == null){
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s = treeStringBuilder(root, s, 0, true);
		s.delete(s.length() - 2, s.length());
		
		String result = s.toString();
		return result;
	}
	
	/**
	 * Recursive tree builder
	 */
	public StringBuilder treeStringBuilder(Node<K, E> root, StringBuilder s, int curHeight, boolean curTreeSide){
		s.append("[" + boolToColor(root.color) + ", " + root.key + ", ");
		
		if(root.left != null){
			treeStringBuilder(root.left, s, curHeight++, true);
		}
		else{
			s.append("null, ");
		}
		
		if(root.right != null){
			treeStringBuilder(root.right, s, curHeight++, false);
		}
		else{
			s.append("null");
			// All nodes to the left side of the tree only need one bracket
			if(curTreeSide == true){
				s.append("]");
			}
			// If a node to the right side has a child to the left, but not right, adjust ] count
			else if(root.left != null){
				for(int ii = 0; ii <= curHeight - 1; ii++){
					s.append("]");
				}
			}
			
			else if(curHeight - getMinimumHeight() == 0){
				for(int ii = 0; ii <= getHeight() - 3; ii++){
					s.append("]");
				}
				s.append("]");
			}
			
			// Put in as many ] as height of tree, minus one cause left side, right most node doesn't need
			// final ] to close it in with will right side, right most node gets it in getTreeString()
			else{
				
					for(int ii = 0; ii <= curHeight - getMinimumHeight(); ii++){
						s.append("]");
					}
					s.append("]");
			}
			s.append(", ");		
		}
		return s;
	}
	
	/**
	 * Converts a boolean value to a String description of it's color
	 * TRUE = Black, FALSE = Red
	 */
	private String boolToColor(boolean color){
		if(color == false){
			return "Red";
		}
		else{
			return "Black";
		}
	}
	
	/**
	 * Node class for use by Binary Search Tree
	 * Has Parent connection to make Red Black Tree manipulations easier
	 */
	public class Node<Key, D>{
		public Node<Key, D> left = null;
		public Node<Key, D> right = null;
		public Node<Key, D> parent = null;
		public Key key;
		public D data;
		public boolean color;
		
		/**
		 * Default Constructor to create a node
		 * @param color - False is red, true is black
		 * @param key - Identifier of the node
		 * @param data - The data to be stored in the node
		 */
		public Node(boolean color, Key key, D data){
			this.key = key;
			this.data = data;
		}
	}

}
