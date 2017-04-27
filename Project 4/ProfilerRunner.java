public class ProfilerRunner {
	public static void main(String[] args){
		ProfilerMethods test = new ProfilerMethods();
		
		BinarySearchTree<Integer, Integer> tree1 = new BinarySearchTree<>();
		BinarySearchTree<Integer, Integer> tree2 = new BinarySearchTree<>();
		RedBlackTree<Integer, Integer> tree3 = new RedBlackTree<>();
		RedBlackTree<Integer, Integer> tree4 = new RedBlackTree<>();
		
		//test.BSTrandTest10_000(tree1);
		//test.BSTinOrderTest10_000(tree2);
		
		//test.RBTrandTest10_000(tree3); //Doesn't work for some reason I cannot fathom
		//test.RBTinOrderTest10_000(tree4);
		//System.out.println("The height of this Red Black Tree is: " + tree2.getHeight());
	}
}
