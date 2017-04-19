import java.util.NoSuchElementException;

/*
 * Created by Jasque Saydyk
 * Project 04 - Binary Search Trees
 * CS 249
 * 16 April 2017
 * Description - This class creates a Binary Search Tree
*/
public class BinarySearchTree<K extends Comparable<K>, E> implements IBinarySearchTree<K, E>{

	public Node<K, E> root;
	private int size = 0;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(K key, E data){
		root = new Node<>(key, data);
		size++;
	}
	
	/**
	 * Adds a node to the tree containing this key element combination
	 * @param key - Comparable object that is the external portion of the node
	 * @param element - The data the node will hold
	 */
	@Override
	public void put(K key, E element){
		Node<K, E> addingNode = new Node<>(key, element);
		Node<K, E> currentNode = root;
		while(true){
			if(currentNode == null){  // Root is setup using default constructor making it null
				root = new Node<>(key, element);
				size++;
				break;
			}
			else if(key.compareTo(currentNode.key) < 0){
				if(currentNode.left == null){
					currentNode.left = addingNode;
					size++;
					break;
				}
				else{
					currentNode = currentNode.left;
				}
			}
			else if(key.compareTo(currentNode.key) > 0){
				if(currentNode.right == null){
					currentNode.right = addingNode;
					size++;
					break;
				}
				else{
					currentNode = currentNode.right;
				}
			}
			else if(key.compareTo(currentNode.key) == 0){
				currentNode.data = element;
				break;
			}
			else{
				System.out.println("Something went wrong when adding the node");
			}
		}
	}
	
	/**
	 * Retrieves an element from the tree based on the key. Throws a
     * NoSuchElementException if no such key exists.
     * @param key - Comparable object that locates the node that contains the data
     * @return Data stored inside of the node
     * @throws NoSuchElementException - If the key is not found in the tree
	 */
	@Override
	public E get(K key){
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
	 * @return The number of elements in the tree
	 */
	@Override
	public int size(){
		return size;
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
	 * 
	 * @param root
	 * @param s
	 * @return
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
	 * Returns the highest distance from the root to a leaf node in the entire tree.
     * @return Highest distance from the root to a leaf node in the entire tree
	 */
	@Override
	public int getHeight(){
		if(root == null){
			return 0;
		}
		// Subtract one as it includes the root in the height
		return getRecursiveHeight(root) - 1;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private int getRecursiveHeight(Node<K, E> root){
		// Terminates branch and sends it back up
		if(root == null){
			return 0;
		}
		
		int left = getRecursiveHeight(root.left);
		int right = getRecursiveHeight(root.right);
		
		if(left > right){
			return left + 1;
		}
		else{
			return right + 1;
		}
	}
	
	/**
	 * @return String description of this BST as a tree.  Each node is depicted
     * as [Key, LeftBranch, RightBranch] where LeftBranch and RightBranch are
     * either null or another node. Should the tree be empty return [].
	 */
	@Override
	public String getTreeString(){
		if(root == null){
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s = treeStringBuilder(root, s, 0, true);
		s.delete(s.length() - 2, s.length());
		if(getHeight() > 0){
			s.append("]");
		}
		String result = s.toString();
		return result;
	}
	
	/**
	 * 
	 * @param root
	 * @param s
	 * @return
	 */
	public StringBuilder treeStringBuilder(Node<K, E> root, StringBuilder s, int curHeight, boolean curTreeSide){
		s.append("[" + root.key + ", ");
		
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
			// Put in as many ] as height of tree, minus one cause left side, right most node doesn't need
			// final ] to close it in with will right side, right most node gets it in getTreeString()
			else{
				for(int ii = 0; ii <= getHeight() - 1; ii++){
					s.append("]");
				}
			}
			s.append(", ");		
		}
		return s;
	}
	
	/**
	 * Node class for use by Binary Search Tree
	 */
	public class Node<Key, D>{
		public Node<Key, D> left;
		public Node<Key, D> right;
		public Key key;
		public D data;
		
		/**
		 * Default Constructor to create a node
		 * @param data - The data to be stored in the node
		 */
		public Node(Key key, D data){
			this.key = key;
			this.data = data;
		}
	}
}
