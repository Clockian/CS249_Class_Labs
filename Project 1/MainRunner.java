import java.util.Comparator;

public class MainRunner {
	public static void main(String[] args){
		MainTester test = new MainTester();
		
		ISorter bubble = new BubbleSorter();
		ISorter selection = new SelectionSorter();
		ISorter insertion = new InsertionSorter();
		
		System.out.println("Bubble Sort");
		//test.sampleTest(bubble);
		test.randTest20(bubble);
		test.randTest100(bubble);
		test.randTest500(bubble);
		test.randTest2500(bubble);
		
		System.out.println("\nSelection Sort");
		//test.sampleTest(selection);
		test.randTest20(selection);
		test.randTest100(selection);
		test.randTest500(selection);
		test.randTest2500(selection);
		
		System.out.println("\nInsertion Sort");
		//test.sampleTest(insertion);
		test.randTest20(insertion);
		test.randTest100(insertion);
		test.randTest500(insertion);
		test.randTest2500(insertion);
		
		Comparator artist = new ArtistComparator();
		Comparator chronological = new ChronologicalComparator();
		Comparator hotAndNew = new HotAndNewComparator();
		
		System.out.println("\nBubble Comparator Sort Test");
		System.out.print("artist        - ");
		test.musicLibrary(bubble, artist);
		System.out.print("chronological - ");
		test.musicLibrary(bubble, chronological);
		System.out.print("hotAndNew     - ");
		test.musicLibrary(bubble, hotAndNew);
		
		System.out.println("\nSelection Comparator Sort Test");
		System.out.print("artist        - ");
		test.musicLibrary(selection, artist);
		System.out.print("chronological - ");
		test.musicLibrary(selection, chronological);
		System.out.print("hotAndNew     - ");
		test.musicLibrary(selection, hotAndNew);
		
		System.out.println("\nInsertion Comparator Sort Test");
		System.out.print("artist        - ");
		test.musicLibrary(insertion, artist);
		System.out.print("chronological - ");
		test.musicLibrary(insertion, chronological);
		System.out.print("hotAndNew     - ");
		test.musicLibrary(insertion, hotAndNew);
	}
}
