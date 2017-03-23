
/**
 *The "Start" class.
 *Instructor: Mr. Sayed
 *Assignment Name: Slewify Program
 *Class: ICS 4U0-B
 *@Author Yusra Irfan 
 *@Version 1.1 
 *Date of Submission: 9th May 2016
 */
public class Slewify
{
	Playlist[] playlists; //Playlist Array
	int currentPlaylistNo; //number of Playlists added
	public Slewify ()
	{
		// TODO Auto-generated constructor stub
		//initializing the variables
		playlists = new Playlist [10];//max number of playlist is 10
		currentPlaylistNo = 0;
	}


	/**
	 * Adds Playlist 
	 * @param - p1 Playlist
	 * @return returns String
	 */
	public String addPlaylist (Playlist p1)
	{ //adds the playlist
		if (currentPlaylistNo==10){//checking if the maximum limit is reached 
			return "Playlist Full";	
		}
		if (p1.getName().equals("")){//if ther is no name enetered 
			return "Enter Playlist Name";
		}
		playlists [currentPlaylistNo] = p1; //adding Playlist to Slewify
		currentPlaylistNo++; //adds the current number of playlists
		return "Playlist Added";
	}

	/** 
	 * Finds the playlist by name
	 * @param PlaylistN String
	 * @return Playlist
	 */
	public Playlist findPlaylistName (String playlistN)
	{ 
		for (int i = 0 ; i < currentPlaylistNo ; i++) //goes through the playlist array
		{
			if (playlistN.equalsIgnoreCase (playlists [i].getName ())) //finds the playlist
			{
				return playlists [i]; // returns the playlist
			}
		}
		return null;
	}

	/**
	 * Displays Playlist Order
	 * @return returns String
	 */
	public String displayPlaylistOrder()
	{
		String displayOrder = "";
		for (int i = 0 ; i < currentPlaylistNo ; i++) //goes through the playlists
		{
			displayOrder = displayOrder + "\n" + playlists [i].getName (); //adds the playlist names to displayOrder
		}

		return displayOrder;//returns the names of the playlist 
	}
}

