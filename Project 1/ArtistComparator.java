import java.util.Comparator;

public class ArtistComparator<T extends MusicTrack> implements Comparator<T>{
	@Override
	public int compare(T arg0, T arg1) {
		// Setting artist's name to variable
		int size = 0;
		String name1 = arg0.getArtistName();
		String name2 = arg1.getArtistName();
		
		// Compare the artists name to see which is bigger to decide loop length
		if(name1.length() > name2.length()){
			size = name1.length();
		}
		else{
			size = name2.length();
		}
		
		/** For loop to iterate through each letter of name to compare
		  * Rant: It took me two hours to realize this, but the requirements state
		  * that this compareTo should sort the artist name alphabetically. So
		  * to any normal human, this means that A is greater than B, because alphabetically
		  * A is at the top, thus the greatest, and Z is at the bottom, the lowest. We sort
		  * from A to Z, not Z to A.
		  * 
		  * Well in Java, if you compare the char A and the char B, you'll find that be is 
		  * greater, which also makes sense if you think of the letters as numbers, with 
		  * A being 1, B being 2, thus B is greater. If you where to look at this with 
		  * Hexadecimals replacing the letters, this still makes sense, as A is 10 and B is
		  * 11, thus B is bigger.
		  * 
		  * So what am I getting at here? Well, we have two different systems. To normal humans,
		  * if you ask, "Which is greater alphabetically, A or B", they would say A, thus expect
		  * a compareTo function sorting alphabetically to return 1, as A is greater. However,
		  * whoever wrote the test for this class decided to go with the Java mindset that
		  * when asked the question "Which is greater alphabetically, A or B", they warrent a
		  * return of -1.
		  * 
		  * For this assignment, beyond having to figure this out, it doesn't mean much. However
		  * if any normal person were to use this, and got a return of -1 for the question of 
		  * "Which is greater alphabetically, A or B", it may drive them a little bonkers and 
		  * add bugs into code. Thus I submit this as a semantic bug to be fixed, in the test,
		  * flip the comp.compare(a,b)<0; to comp.compare(a,b)>0;
		  */
		for(int ii = 0; ii < size; ii++){
			// 
			// Ex. A is less then B, giving a True, thus 1 for name1 being better
			if(name1.charAt(ii) < name2.charAt(ii)){
				return -1;
			}
			else if(name1.charAt(ii) > name2.charAt(ii)){
				return 1;
			}
		}
		
		// Setting album name to variable
		String album1 = arg0.getAlbumName();
		String album2 = arg1.getAlbumName();
		
		// Compare the album name to see which is bigger to decide loop length
		if(album1.length() > album2.length()){
			size = album1.length();
		}
		else{
			size = album2.length();
		}
		
		// Read the four paragraphs above, as the same applies here
		for(int ii = 0; ii < size; ii++){
			// Ex. A is less then B, giving a True, thus 1 for name1 being better
			if(album1.charAt(ii) < album2.charAt(ii)){
				return -1;
			}
			else if(album1.charAt(ii) > album2.charAt(ii)){
				return 1;
			}
		}
		
		// Setting track number to variable
		int track1 = arg0.getTrackNumber();
		int track2 = arg1.getTrackNumber();
		
		// Compare the track number to see which is bigger
		if(track1 > track2){
			return 1;
		}
		else if(track2 > track1){
			return -1;
		}
		
		// If all of the above fail, then both objects are the same
		return 0;
	}

}
