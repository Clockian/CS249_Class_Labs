
public class tempTest {
	public static void main(String[] args){
		BinarySearchTree<Integer,String> tree = new BinarySearchTree<Integer,String>();
		BinarySearchTree<Integer,String> tree2 = new BinarySearchTree<Integer,String>();
		
		/*
		tree.put(1, "One");
		tree.put(2, "Two");
	    tree.put(3, "Three");
	    */
		
		
	    tree.put(1, "One");
	    tree.put(2, "Two");
	    tree.put(3, "Three");
	    tree.put(4, "Four");
	    tree.put(5, "Five");
	    tree.put(6, "Six");
	    tree.put(7, "Seven");
	    tree.put(8, "Eight");
	    tree.put(9, "Nine");
	    
	    
	    
		tree2.put(8, "Eight");
	    tree2.put(3, "Three");
	    tree2.put(10, "Ten");
	    tree2.put(1, "One");
	    tree2.put(6, "Six");
	    tree2.put(14, "Fourteen");
	    tree2.put(4, "Four");
	    tree2.put(7, "Seven");
	    tree2.put(13, "Thirteen");
	    //tree2.put(12, "Twelve");
	    
	    System.out.println(tree.getTreeString());
	    System.out.println(tree2.getTreeString());
	}
}
