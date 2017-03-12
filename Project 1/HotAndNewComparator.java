import java.util.Comparator;

public class HotAndNewComparator<T extends MusicTrack> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		// Song Rating descending
		int rating1 = o1.getRating();
		int rating2 = o2.getRating();
		
		if(rating1 < rating2){
			return 1;
		}
		else if(rating2 < rating1){
			return -1;
		}
		
		// Year Descending
		int year1 = o1.getYear();
		int year2 = o2.getYear();
		
		if(year1 < year2){
			return 1; 
		}
		else if(year2 < year1){
			return -1;
		}
		
		
		// Artist Name Alphabetically
		// Setting artist's name to variable
		int size = 0;
		String name1 = o1.getArtistName();
		String name2 = o2.getArtistName();
		
		// Compare the artists name to see which is bigger to decide loop length
		if(name1.length() > name2.length()){
			size = name1.length();
		}
		else{
			size = name2.length();
		}
		
		// Read the four paragraphs in ArtistComparator to understand the code below
		for(int ii = 0; ii < size; ii++){
			// Ex. A is less then B, giving a True, thus 1 for name1 being better
			if(name1.charAt(ii) < name2.charAt(ii)){
				return -1;
			}
			else if(name1.charAt(ii) > name2.charAt(ii)){
				return 1;
			}
		}
		
		// Album Name Alphabetically
		// Setting album name to variable
		String album1 = o1.getAlbumName();
		String album2 = o2.getAlbumName();
		
		// Compare the album name to see which is bigger to decide loop length
		if(album1.length() > album2.length()){
			size = album1.length();
		}
		else{
			size = album2.length();
		}
		
		// Read the four paragraphs in ArtistComparator to understand the below
		for(int ii = 0; ii < size; ii++){
			// Ex. A is less then B, giving a True, thus 1 for name1 being better
			if(album1.charAt(ii) < album2.charAt(ii)){
				return -1;
			}
			else if(album1.charAt(ii) > album2.charAt(ii)){
				return 1;
			}
		}
		
		// Track Ascending
		// Setting track number to variable
		int track1 = o1.getTrackNumber();
		int track2 = o2.getTrackNumber();
		
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
