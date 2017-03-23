/**
 *The "Node" class.
 *Instructor: Mr. Sayed
 *Assignment Name: Slewify Program
 *Class: ICS 4U0-B
 *@Author Yusra Irfan 
 *@Version 1.1 
 *Date of Submission: 9th May 2016
 */
public class Node
{
	//Stores the reference to this nodes song
	Song currentSong;
	//Stores the reference to the node that follows this one in the list
	Node next;


	//The constructor
	public Node (Song s, Node n)
	{
		currentSong = s;
		next = n;
	}

	public Node ()
	{ 

	}

	public Node (Song s)
	{
		currentSong = s;

	}

	public Node ( Node n)
	{
		next = n;
	}

	/**
	 * Returns the reference to this node's song
	 * @return returns the song 
	 */
	public Song getSong ()
	{
		return currentSong;
	}


	/**
	 * Returns the reference to the next node in the list
	 * @return next
	 */
	public Node getNext ()
	{
		
		System.out.println(next);
		return next;
	}


	/**
	 * Set a new next node in the list
	 * @param n
	 */
	public void setNext (Node n)
	{
		next = n;
	}
	 
	/**
	 * Gets the Song Name
	 * @return returns the song name
	 */
	public String displayName() 
	{
		return currentSong.getTitle();
	}

	/**
	 * Gets the Song Artist
	 * @return returns the song artist
	 */
	public String displayArtist() 
	{
		return currentSong.getArtist();
	}

	/**
	 * Gets the Song Year
	 * @return returns the song Year
	 */
	public String displayYear() 
	{
		return currentSong.getYear();
	}
	
	/**
	 * Gets the Song Ratings
	 * @return returns the song ratings 
	 */
	public int displayRating() 
	{
		return currentSong.getRatings();
	}
	
	/**
	 * Gets the Song Genre
	 * @return returns song genre 
	 */
	public String displayGenre() 
	{
		return currentSong.getGenre();
	}
}


