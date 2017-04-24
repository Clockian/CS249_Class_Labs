import java.util.NoSuchElementException;

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
	
	/*private void checkPut(Node<K, E> node){
		while(node.key.compareTo(root.key) != 0 && node.parent.color == false){
			// There is a Red Red violation
			if(node.parent.key.compareTo(node.parent.parent.left.key) == 0){
				// Check if Uncle is Red
				if(node.parent.parent.right == null || node.parent.parent.right.color == true){
					// Uncle is black
					if(node.key.compareTo(node.parent.right.key) == 0){
						// make addingNode a left child
						node = node.parent;
						rotateLeft(node);
					}
					// recolor and rotate
					node.parent.color = true;
					node.parent.parent.color = false;
					rotateRight(node.parent.parent);
					
				}
				else{
					node.parent.color = true;
					node.parent.parent.right.color = true;
					node.parent.parent.color = false;
					node = node.parent.parent;
				}
			}
			else{
				// mirror image of above code on other side of the tree
				if(node.parent.parent.left.color == false){
					// Uncle is red
					node.parent.color = true;
					node.parent.parent.left.color = true;
					node.parent.parent.color = false;
					node = node.parent.parent;
				}
				else{
					// Uncle is black
					if(node.key.compareTo(node.parent.left.key) == 0){
						node = node.parent;
						rotateRight(node);
					}
					node.parent.color = true;
					node.parent.parent.color = false;
					rotateLeft(node.parent.parent);
				}
			}
		}
		// out of loop, last thing to do
		root.color = true;
	}
	
	private void rotateLeft(Node<K, E> node){
		Node<K, E> nodeRight = node.right;
		
		// Establish right link
		node.right = nodeRight.left;
		if(nodeRight.left != null){
			nodeRight.parent = node;
		}
		
		// Establish right parent link
		if(nodeRight != null){
			nodeRight.parent = node.parent;
		}
		if(node.parent != null){
			if(node.key.compareTo(node.parent.left.key) == 0){
				node.parent.left = nodeRight;
			}
			else{
				node.parent.right = nodeRight;
			}
		}
		else{
			root = nodeRight;
		}
		
		// link x and y
		nodeRight.left = node;
		if(node != null){
			node.parent = nodeRight;
		}
	}
	
	private void rotateRight(Node<K, E> node){
		
		// establish left link
		Node<K, E> nodeLeft = node.left;
		System.out.println("root.key:" + root.key);
		System.out.println("node.key:" + node.key);
		System.out.println("nodeLeft:" + nodeLeft);
		System.out.println("node.left:" + node.left.key);
		node.left = nodeLeft.right;
		if(nodeLeft.right != null){
			nodeLeft.right.parent = node;
		}
		
		// Establish left parent link
		if(nodeLeft != null){
			nodeLeft.parent = node.parent;
		}
		if(node.parent != null){
			if(node.key.compareTo(node.parent.right.key) == 0){
				node.parent.right = nodeLeft;
			}
			else{
				node.parent.left = nodeLeft;
			}
		}
		else{
			root = nodeLeft;
		}
		
		// Link node and left
		nodeLeft.right = node;
		if(node != null){
			node.parent = nodeLeft;
		}
	}*/
	
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
		// PlaceInitialRedValue should return node created
		Node<K, E> node = placeInitialRedValue(key, element);
		if(node == null){
			return;
		}
		else{
			checkPutCase1(node);
		}
	}
	
	private Node<K, E> getGrandParent(Node<K, E> node){
		if(node != null && node.parent != null){
			return node.parent.parent;
		}
		else{
			return null;
		}
	}
	
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
	
	private void checkPutCase1(Node<K, E> node){
		// CASE 1: Make root Black if needed
		if(node.key.compareTo(root.key) == 0){
			root.color = true;
			return;
		}
		else{
			checkPutCase2(node);
		}
	}
		
	private void checkPutCase2(Node<K, E> node){
		// CASE 2: Check if node and Parent are Red, and quit if not
		if(node.parent.color == true || node.color == true){
			return;
		}
		else{
			checkPutCase3(node);
		}
	}
		
	private void checkPutCase3(Node<K, E> node){
		// CASE 3: Check if Parent and Uncle are Red, if so, turn Black and turn Grandparent Red
		Node<K, E> uncle = getUncle(node);
		if(uncle != null && uncle.color == false){
			//System.out.println("here");
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
	
	private void rotateLeft_Line(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedRightChild_Left = node.right.left;
		Node<K, E> savedRightChild = node.right;
		
		savedRightChild.parent = savedParent;
		if(savedParent != null){
			savedParent.right = savedRightChild;
			//savedParent.right = savedRightChild;
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
	
	private void rotateLeft_Bent(Node<K, E> node){
		Node<K, E> savedParent = node.parent;
		Node<K, E> savedRightChild_Left = node.right.left;
		Node<K, E> savedRightChild = node.right;
		
		savedRightChild.parent = savedParent;
		if(savedParent != null){
			savedParent.left = savedRightChild;
			//savedParent.right = savedRightChild;
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
	 * Places the value in the tree as a Red value where it belongs
	 * @param key
	 * @param element
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
				// No addition to graph, only change
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

	@Override
	public int size() {
		return size;
	}

	@Override
	public int getHeight() {
		if(root == null){
			return 0;
		}
		// Subtract one as it includes the root in the height
		return getRecursiveHeight(root);
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
	 * 
	 * @param root
	 * @return
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
	
	
	public int getMinimumHeight() {
		if(root == null){
			return 0;
		}
		// Subtract one as it includes the root in the height
		return this.getRecursiveMinHeight(root) - 1;
	}
	
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

	@Override
	public String getTreeString() {
		if(root == null){
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s = treeStringBuilder(root, s, 0, true);
		s.delete(s.length() - 2, s.length());
		
		if(getHeight() > 0){
			//s.append("]");
			//s.append("]");
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
			
			else if(getHeight() - getMinimumHeight() == 0){
				for(int ii = 0; ii <= getHeight() - 3; ii++){
					s.append("]");
				}
				s.append("]");
			}
			else if(getHeight() - getMinimumHeight() == 1){
				for(int ii = 0; ii <= getHeight() - 3; ii++){
					s.append("]");
				}
			}
			
			// Put in as many ] as height of tree, minus one cause left side, right most node doesn't need
			// final ] to close it in with will right side, right most node gets it in getTreeString()
			else{
				
					for(int ii = 0; ii <= getHeight() - getMinimumHeight(); ii++){
						s.append("]");
					}
					//s.append("]");
			}
			s.append(", ");		
		}
		return s;
	}
	
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
		 * @param key
		 * @param data - The data to be stored in the node
		 */
		public Node(boolean color, Key key, D data){
			this.key = key;
			this.data = data;
		}
	}

}
