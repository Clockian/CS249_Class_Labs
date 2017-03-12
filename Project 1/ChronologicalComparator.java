import java.util.Comparator;

public class ChronologicalComparator<T extends MusicTrack> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		// Years Ascending
		int year1 = o1.getYear();
		int year2 = o2.getYear();
		
		if(year1 > year2){
			return 1; 
		}
		else if(year2 > year1){
			return -1;
		}
		
		// Album Name Alphabetically
		// Setting album name to variable
		int size = 0;
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
		
		// Track Number Ascending
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
