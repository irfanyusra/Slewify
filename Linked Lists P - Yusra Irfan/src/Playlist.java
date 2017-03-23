/**
 *The "Playlist" class.
 *Instructor: Mr. Sayed
 *Assignment Name: Slewify Program
 *Class: ICS 4U0-B
 *@Author Yusra Irfan 
 *@Version 1.1 
 *Date of Submission: 9th May 2016
 */
public class Playlist
{ 
	String playlistName; //Stores the name of the playlist
	int currentSongNo; //Stores the number of songs
	private Node head;//Stores the reference to a playlists head
	private Node tail;//Stores the reference to a playlists tail
	private Node current;//Stores the reference to the current node

	public Playlist (String name)
	{
		// TODO Auto-generated constructor stub
		//initializing the variables
		playlistName = name;
		currentSongNo = 0;
	}


	/**
	 * Gets Playlist Name
	 * @return returns Playlist Name
	 */
	public String getName () 
	{
		return playlistName;
	}

	/**
	 * Change Playlist Name
	 * @param - newName String
	 * @return returns Playlist Name
	 */

	public String changeName (String newName)  
	{
		playlistName = newName;
		return playlistName;
	}

	/**
	 * Add Song to the Playlist
	 * @param - song1 Song
	 * @return returns String
	 */
	public String addSongToPlaylist (Song song1)
	{ 
		Node s1 = new Node(song1);//creates a new node
		s1.next = null;
		if(head == null) {//checks if there is only one node
			head = s1;//Stores as head
			tail = s1;//Stores as tail
			currentSongNo++;//increases the number of songs 
			return "Song Added";
		}
		else if (head != null){//if there is more than one node
			tail.next = s1;
			tail = s1;
			return "Song Added";
		}
		return "Song Not Added";
	}


	/**
	 * Display Song  in the playlist
	 * @return returns String
	 */
	public void displaySongName ()
	{
		Node node = head;//stores node as head
		System.out.println("List of node:");

		while(node != null) //while loop runs till no elements found
		{
			System.out.println(node.displayName());//prints out the song name 
			node = node.next;//store the next node 
		}
	}

	/**
	 * Find songs in the playlist
	 * @param - int songName
	 * @return returns Songs
	 */
	public Song findSongName (String songName)//returns the song object 
	{ 
		Node curr = head;//stores curr as head
		while(curr!=null)//while loop runs till no elements found
		{
			if(curr.getSong().getTitle().equals(songName))//song's title equals the song name 
				return curr.getSong();//returns the current song
			else curr = curr.next;//store the next node 
		}
		return null; //element not found
	}


	/**
	 * Gets the song from the title
	 * @param title
	 * @return
	 */
	public Song getSongFromTitle(String title)
	{
		if (head == null) //throw new IndexOutOfBoundsException();
			return null;//if no elements are found 
		Node tmp = head;//Stores tmp as head
		for (int k = 0; k < getListSize(); k++) //goes through the nodes
		{	  
			if (tmp.currentSong.getTitle().equalsIgnoreCase(title)) //checks if the song title is equal to the title given 
			{
				return tmp.currentSong;	//returns the song
			}
			else 
				tmp = tmp.next;//goes to the next 
		}
		return null;//if no elements are found 
	}
	
	/**
	 * Gets the Song from the Index
	 * @param index
	 * @return Song 
	 */
	public Node getFromIndex(int index)
	{
		if (index>=getListSize()||index<0)//if index out of range 
			return null;

		Node tmpNode = head;//sets tmpNode as head 
		for(int i = 0; i < index; i++)//goes through the for loop till index 
		{
			tmpNode = tmpNode.getNext();//sets tempNode as next 
		}
		return tmpNode;//returns the song at the index 
	}

	/**
	 * Deletes song from the playlist using index
	 * @param index - Integer 
	 * @return String "Deleted" or "Out Of Range"
	 */
	public String deleteSong (int index)
	{
		if (index==0){//checks if the index is zero 
			if (current==tail||getListSize()==0){//if there are no songs  
				return "Playlist is empty";
			}
			if (current == head) //if current is the 1st song
			{
				head = current.next;//sets head to the next node
			}
			head = head.next;//sets heed to next 
			currentSongNo--;//decrease the number of current songs 
			return "Deleted";
			
		}

		else if(index < 0 || index > getListSize()-1)// if the index is out of range
			return "Out Of range";
		else 
		{
			Node current = head;//sets current as head 
			for(int i = 1; i < index; i++)
			{
				current = current.getNext();//sets current as next 
			}
			current.setNext(current.next.next);//sets current.
				
			currentSongNo--; // decrement the number of elements variable
			return " Deleted";
		}
	}


	/**
	 * Deletes songs with same names
	 * @param name
	 * @return String - "Deleted" OR "Does Not Exist"
	 */
	public String deleteSong(String name) 
	{
		Node previous = null;
		Node current = head;
		boolean deleted=false;
		while(current != null) //goes through the list 
		{
			if (current.currentSong.getTitle().equals(name)) 
			{
				currentSongNo--;//decreases the number of songs 
				deleted = true;
				if (current == head) 
				{
					head = current.next;//sets head as next node
				} 
				else 
				{
					previous.next = current.next;
				}
			} 
			else 
			{
				previous = current;//sets previous to current 
			}

			current = current.next;//sets current to next
		}
		if (deleted)
			return "Deleted";
		return "Does not exist";
	}



	/**
	 * Gets the Playlist size
	 * @return returns the Number of songs in the playlist - int
	 */
	public int getListSize ()
	{
		current=head;
		currentSongNo=0;
		while(current != null) //goes through the list 
		{
			current = current.next;//sets current to next
			currentSongNo++;
		}
		
		return currentSongNo;
	}

	/**
	 * Clears the Songs from the Playlist
	 * @return returns String - "Playlist Cleared" or " Playlist is Empty" 
	 */
	public String clearList ()
	{
		if (getListSize()==0)//if there is no song 
			return "Playlist is Empty";

		currentSongNo=0;//sets the number to 0
		head = null;//sets head to null
		return "Playlist Cleared";
	}


	/**
	 * Return the number of times a song occurs in a given list
	 * @param song
	 * @return
	 */
	public int numTimes (String songT, String  songA)
	{
		int numTimesS=0;
		Node tmpNode = head;//sets tmpNode as head 
		for(int i = 0; i < getListSize(); i++)
		{
			if(tmpNode.getSong().getArtist().equals(songA)&&tmpNode.getSong().getTitle().equals(songT))//checks song's title and artist equal to the one's given  
				numTimesS++;//increases the number of times the song occurs 

			tmpNode = tmpNode.getNext();//sets the tmpNode to next node
		}
		return numTimesS;//returns the number of times the song occurs 
	}

	/**
	 * Add Song at a specific index
	 * @param s1
	 * @param index
	 * @return returns String - "Out Of Range" OR "Song Added"
	 */
	public String addSongToPlaylist(Song s1, int index)
	{
		Node temp = new Node(s1);//creates a temp node
		Node current = head;//sets current as head
		Node previous = null;//sets previous as null 
		if(index < 0 || index > getListSize())//if out of range 
			return "Out Of range";

		else if(index==0)
		{
			temp.next = null;
			if(head == null) {//if nothing in the playlist
				head = temp;//sets head as the temp node
				tail = temp;//sets tail as the temp node
			}
			else //if the index is 0 and there are other things in the list
			{
				temp.next = head;//sets next as head 
				head = temp;//sets head as temp node 
			}
			currentSongNo++;
			return "Song Added";
		}

		if(index==getListSize())//if index is adding the song at the end of the list as a tail 
		{
			return addSongToPlaylist(s1);//going to the method that adds song at the end
		}

		for(int i = 0; i < index ; i++)
		{
			previous = current;
			current = current.getNext();
		}
		// set the new node's next-node reference to current node reference
		temp.next = current;
		// now set the previous node's next-node reference to the temp node
		previous.next = temp;
		currentSongNo++;// increment the number of elements variable
		return "Song Added";
	}


	/**
	 * Gets the head of the list
	 *@return Returns a reference to the head of the playlist
	 */
	public Node getListHead ()
	{
		return head;
	}
	/**
	 * Gets the current node of the list 
	 * @return returns the current Node in the list here
	 */
	public Node currentSong ()
	{
		return current;
	}

	/**
	 * Gets the last Node in the playlist 
	 * @return returns the last Node
	 */
	public Node getLastSong ()
	{
		return tail; //return the last Node in the list
	}

	/**
	 * Gets the next node in the list 
	 * @return returns the next node
	 */
	public Node nextSong ()
	{
		return current.next;
	}

	



	/**
	 * Sort Songs by Ratings
	 * @return String - "Playlist Sorted" 
	 */
	public String sortByRating() {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for(int i = 0; i < getListSize()-1; i++) 
			{
				if (getFromIndex(i).getSong().getRatings() < getFromIndex(i).getNext().getSong().getRatings()) 
				{//comapares the current song with the next song
					swapPairs(i);//method swapPairs
					swapped = true;
				}
			}
		}
		return "Playlist Sorted";

	}

	/**
	 * Swaps Nodes
	 * @param tempIndex
	 */
	public void swapPairs(int tempIndex) {

		if (tempIndex > 0) {
			Node firstNode = getFromIndex(tempIndex - 1);//storing the node before the node to swap
			Node secondNode = getFromIndex(tempIndex);//storing the node to swap
			Node thirdNode = getFromIndex(tempIndex + 1);//storing the node after the node to swap
			Node fourthNode = getFromIndex(tempIndex + 2);//storing the node 2 after the node to swap

			firstNode.setNext(thirdNode);//setting the second node as the third node
			thirdNode.setNext(secondNode);//setting the fourth node as the second node
			secondNode.setNext(fourthNode);//setting the third node fourth node

			getFromIndex(tempIndex + 1).setNext(fourthNode);
			getFromIndex(tempIndex).setNext(secondNode);
			getFromIndex(tempIndex - 1).setNext(thirdNode);
		} 
		else
		{
			if (getListSize() > 2) 
			{
				Node firstNode = head;
				Node secondNode = head.getNext();
				Node thirdNode = head.getNext().getNext();

				firstNode.setNext(thirdNode);
				secondNode.setNext(firstNode);

				head = secondNode;
			}
			else if (getListSize() == 2) 
			{//swaps both songs with each other
				Node firstNode = head;

				head = head.getNext();
				head.setNext(firstNode);

			}

		}

	}
}



