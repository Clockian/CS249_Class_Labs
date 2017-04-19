import BinarySearchTree.Node;

public class RedBlackTree<K extends Comparable<K>, E> implements IBinarySearchTree<K, E>{

	public Node<K, E> root;
	private int size = 0;
	
	public RedBlackTree(){
		root = null;
	}
	
	public RedBlackTree(K key, E data){
		root = new Node<>(true, key, data);
		size++;
	}
	
	/**
	 * Adds a node to the tree containing this key element combination.
	 * Must follow the four rules of a Red Black tree
	 * 1. The root must be Black
	 * 2. Every null leaf is Black
	 * 3. There must be the same number of Black nodes to all leaves
	 * 4. If a node is Red, then both children must be Black
	 * false -> Red, true -> Black
	 * @param key
	 * @param element
	 */
	@Override
	public void put(K key, E element) {
		// First, add node to tree and make it Red
		Node<K, E> addingNode = new Node<>(false, key, element);
		Node<K, E> currentNode = root;
		int putHeight = this.placeInitialRedValue(key, element);
		
		checkPut(putHeight, addingNode);
		
		
		
	}
	
	private boolean checkPut(int putHeight, Node<K, E> addingNode){
		// Check if node is root, if so, make it Black, then done
		if(root.color == false){
			root.color = true;
		}
		
		// Check if it's parent is red, thus double red problem
		if(parentOf(putHeight - 1, addingNode) == false){
			// Check if sibling is Black or null
			if()
			
		}
		
			
			
				// If yes, then rotate, recolor, then check again
		
			// Else, recolor and check again
		
		// Else, then parent is black, tree is good, done
		return false;
	}
	
	private boolean siblingOf(){
		return false;
	}
	
	private boolean parentOf(int parentHeight, Node<K, E> addingNode){
		Node<K, E> currentNode = root;
		int height = 0;
		while(true){
			if(height == parentHeight){
				break;
			}
			else if(addingNode.key.compareTo(currentNode.key) < 0){
				currentNode = currentNode.left;
				height++;
			}
			else if(addingNode.key.compareTo(currentNode.key) > 0){
				currentNode = currentNode.right;
				height++;
			}
			else{
				System.out.println("Something went wrong when trying to find the parent");
			}
		}
		return currentNode.color;
	}
	
	/**
	 * Places the value in the tree as a Red value where it belongs
	 * @param key
	 * @param element
	 */
	private int placeInitialRedValue(K key, E element){
		Node<K, E> addingNode = new Node<>(false, key, element);
		Node<K, E> currentNode = root;
		int height = 0;
		while(true){
			if(currentNode == null){  // Root is setup using default constructor making it null
				root = new Node<>(false, key, element);
				size++;
				break;
			}
			else if(key.compareTo(currentNode.key) < 0){
				if(currentNode.left == null){
					currentNode.left = addingNode;
					size++;
					height++;
					break;
				}
				else{
					currentNode = currentNode.left;
					height++;
				}
			}
			else if(key.compareTo(currentNode.key) > 0){
				if(currentNode.right == null){
					currentNode.right = addingNode;
					size++;
					height++;
					break;
				}
				else{
					currentNode = currentNode.right;
					height++;
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
		return height;
	}

	@Override
	public E get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTreeString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Node class for use by Binary Search Tree
	 */
	public class Node<Key, D>{
		public Node<Key, D> left;
		public Node<Key, D> right;
		public Key key;
		public D data;
		public boolean color;
		
		/**
		 * Default Constructor to create a node
		 * @param color - False is red, true is black
		 * @param key
		 * @param data - The data to be stored in the node
		 */
		public Node(boolean color, Key key, D data){
			this.key = key;
			this.data = data;
		}
	}

}
