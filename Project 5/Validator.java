/*
 * Created by Jasque Saydyk
 * Project 05 - Hash Tables
 * CS 249
 * 30 April 2017
 * Description - This class validates scrabble words as stated in assignment
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Validator {
	public static void main(String[] args){
		// Read from file 357382
		HashSet<String> dictionary = new HashSet<>(10000000);
		String fileName = "C:\\Users\\Zegar\\workspace\\CS 249 - Project 5 - Hash Tables\\src\\wordlist.txt";
		
	    try {
	    	FileReader fileReader = new FileReader(fileName);
	    	
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	
	    	// Insert into HashSet
	    	String line = bufferedReader.readLine();
	    	while(line != null) {
	    		dictionary.add(line);
                line = bufferedReader.readLine();
            }   

            // Always close files.
            bufferedReader.close();  
		}
	    catch(FileNotFoundException ex) {
	    	System.out.println("Normally you would do something more, but I don't wanna");
	    }
	    catch(IOException ex) {
	    	System.out.println("Normally you would do something more, but I don't wanna");
	    }

		// Hand enter necessary input and print result
	    boolean word1 = dictionary.has("QUEUE");
	    boolean word2 = dictionary.has("NAVIENT");
	    boolean word3 = dictionary.has("AA");
	    boolean word4 = dictionary.has("POSSUM");
	    boolean word5 = dictionary.has("PHONEY");
	    boolean word6 = dictionary.has("BB");
	    boolean word7 = dictionary.has("WERD");
	    boolean word8 = dictionary.has("TITI");
	    
	    System.out.println("Word 1: " + word1);
	    System.out.println("Word 2: " + word2);
	    System.out.println("Word 3: " + word3);
	    System.out.println("Word 4: " + word4);
	    System.out.println("Word 5: " + word5);
	    System.out.println("Word 6: " + word6);
	    System.out.println("Word 7: " + word7);
	    System.out.println("Word 8: " + word8);
	}
}
