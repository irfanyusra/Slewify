public class Song
{
	//Stores the value for the information on the song.
	private String title;
	private String artist;
	private String year;
	private String genre;
	private int rating;
	
	//The constructor
	public Song (String name, String art, String yr, String type,int starR)
	{
		title = name;//Stores the Title of the song
		artist = art;//Stores the Artist of the song
		year = yr;//Stores the Year of the song
		genre = type;//Stores the Genre of the song
		rating=starR;//Stores the Ratings of the song
	}


	/**
	 * Gets the title 
	 * @return returns the songs title
	 */
	public String getTitle ()
	{
		return title;
	}


	/**
	 * Gets the Artist 
	 * @return returns the songs artist
	 */
	public String getArtist ()
	{
		return artist;
	}


	/**
	 * Gets the year
	 * @return returns the songs year
	 */
	public String getYear ()
	{
		return year;
	}

	/**
	 * Gets the Genre
	 * @return Returns the songs genre
	 */
	public String getGenre ()
	{
		return genre;

	}

	/**
	 * Gets the rating 
	 * @return Returns the songs ratings
	 */
	public int getRatings ()
	{
		return rating;

	}

	/**
	 * Changes the title
	 * @param t
	 * @return returns the songs new title
	 */
	public String changeTitle (String t)
	{
		title=t;
		return title;
	}


	/**
	 * Changes the Artist 
	 * @param newA
	 * @return Returns the songs new artist
	 */
	public String changeArtist (String newA)
	{
		artist=newA;
		return artist;
	}


	/**
	 * Changes the Year 
	 * @param y
	 * @return Returns the songs new year
	 */ 
	public String changeYear (String y)
	{
		year=y;
		return year;
	}

	/**
	 * Change the Genre
	 * @param g
	 * @return Returns the songs new genre
	 */
	public String changeGenre (String g)
	{
		genre=g;
		return genre;

	}

	/**
	 * Changes the rating of the song
	 * @param r
	 * @return Returns the songs new ratings
	 */
	public int changeRatings (int r)
	{
		rating = r;
		return rating;

	}
}

