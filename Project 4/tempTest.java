
public class tempTest {
	public static void main(String[] args){
		RedBlackTree<Integer,String> tree = new RedBlackTree<Integer,String>();
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
		//tree.put(7, "Seven");
		//tree.put(8, "Eight");
		//tree.put(9, "Nine");
		/*
		tree.put(6, "Six");
		tree.put(5, "Five");
		tree.put(4, "Four");
		tree.put(3, "Three");
		tree.put(2, "Two");
		tree.put(1, "One");
		tree.put(13, "Thirteen");
		tree.put(11,"Eleven");
		tree.put(10,"Ten");
		tree.put(9, "Nine");
		tree.put(8, "Eight");
		tree.put(7, "Seven");
		
		tree.put(6, "Six");
		tree.put(2, "Two");
		tree.put(13, "Thirteen");
		tree.put(9, "Nine");
		tree.put(10,"Ten");
		*/
		/*
		tree.put(8, "Eight");
	    tree.put(3, "Three");
	    tree.put(10, "Ten");
	    tree.put(1, "One");
	    tree.put(6, "Six");
	    tree.put(14, "Fourteen");
	    tree.put(4, "Four");
	    tree.put(7, "Seven");
	   // tree.put(13, "Thirteen");
	    * 
	    */
		
		//System.out.println(tree.getHeight());
		//System.out.println(tree.getMinimumHeight());
		//System.out.println(tree.getHeight()- tree.getMinimumHeight());
		/*
		tree.put(3, "Three");
		tree.put(1, "One");
		tree.put(2, "Two");
	    */
		//tree.put(5, "Five");
		//tree.put(7, "Seven");
		//tree.put(9, "Nine");
		//tree.put(8, "Eight");
		//tree.put(10,"Ten");
		//tree.put(11,"Eleven");
		
	    //tree.put(4, "Four");
	    /* tree.put(5, "Five");
	    tree.put(6, "Six");
	    tree.put(7, "Seven");
	    tree.put(8, "Eight");
	    tree.put(9, "Nine");*/
	    
	    
	    /*
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
	    */
	    System.out.println(tree.getTreeString());
	    //System.out.println(tree2.getTreeString());
	}
}
