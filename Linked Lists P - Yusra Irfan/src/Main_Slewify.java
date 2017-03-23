
/**
 *The "Main_Slewify" class.
 *Instructor: Mr. Sayed
 *Assignment Name: Slewify Program
 *Class: ICS 4U0-B
 *@Author Yusra Irfan
 *@Version 1.1
 *Date of Submission: 9th May 2016
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Main_Slewify extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
	Color color=new Color(255,255,255);
	Color color1=new Color(42,26,53);//can see name... cannot see suggestions
	Color pList=new Color(58,33,69);

	AudioClip song1;
	AudioClip song2; 
	AudioClip song3;
	AudioClip song4;
	AudioClip song5; 
	AudioClip song6;	
	AudioClip song7;
	AudioClip song8; 
	AudioClip song9;
	
	AudioClip[] sArray=new AudioClip [9];
	int sNum=0;
	//variables
	Button addSong; //Add Song to Playlist
	Button deleteSong; //Delete Song to Playlist
	Button clearPlaylist; //Clear all songs from the Playlist
	Button numTimesS; //Number of times a song title appears in the Playlist
	Button hrSongs; //Highest Rated Songs in the Playlist

	Button changeSongT; //Change Song Title
	Button changeSongI; //Change Song Rating
	Button changeS; //Change Song
	Button changeP; //Change Playlist
	Button next;
	Button cancel;
	Button back;

	TextField addPlaylistName; //Playlist Name
	TextField addSongName; //Song Name
	TextField addSongArtist; //Song Artist
	TextField addSongYear; //Song Year
	TextField addSongGenre; //Song Genre
	TextField addSongRating; //Song Rating
	TextField addSongIndex; //Song Index

	Slewify sl1 = new Slewify (); //initializing to Slewify
	String get = ""; //returns from methods from other classes

	Font fontP = new Font ("Roboto", 1, 30);
	Font font1 = new Font ("Roboto", 1, 17);
	//declaring and initializing booleans
	boolean screen2 = true;
	boolean screen3 = false;
	boolean screen4 = false;
	boolean screen5 = false;
	boolean screen6 = false;
	boolean screen7 = false;
	boolean screen8 = false;
	boolean screen9 = false;
	boolean screen10 = false;
	boolean screen11 = false;
	boolean screen12 = false;
	boolean screen13 = false;
	boolean screen14 = false;
	boolean screen15 = false;
	Playlist foundP = null; //found playlist
	Song foundS = null; //found playlist

	//declaring String
	String PlaylistName; //Playlist Name
	String SongName; //Song Name
	String SongArtist; //Song Artist
	String SongYear; //Song Year
	String SongGenre; //Song Genre

	//declaring integers
	int width = 1366;
	int height = 640;
	int SongRating; //Song Rating
	int xpos; // The X-coordinate of the Mouse Position
	int ypos; // The  Y-coordinate of the Mouse Position
	int  input;
	MediaTracker tracker;
	Image img;
	private Image dbImage;
	private Graphics dbg;
	Node node = null;
	Node node1 = new Node ();
	Node songN=node1;
	//songN=foundP.getListHead();
	public void init ()
	{
		resize (width, height);
		setLayout (null);

		img = getImage (getDocumentBase (), getParameter ("Image1"));
		addSong = new Button ("+ Add Song");
		deleteSong = new Button ("- Delete Song");
		clearPlaylist = new Button ("Clear Playlist");
		numTimesS = new Button ("Song Occurance");
		hrSongs = new Button ("High Rated Songs");
		next = new Button ("Next");
		back = new Button ("Back");
		cancel = new Button ("Cancel");
		changeSongT = new Button ("Song Name");
		changeSongI= new Button ("Song Index");
		changeP = new Button ("Change Playlist");
		changeS = new Button ("Change Song");

		addPlaylistName = new TextField ("", 35);
		addSongName = new TextField ("", 35);
		addSongArtist = new TextField ("", 35);
		addSongYear = new TextField ("", 35);
		addSongGenre = new TextField ("", 35);
		addSongRating = new TextField ("", 35);
		addSongIndex = new TextField ("", 35);

		addPlaylistName.setBounds (1100, 285, 150, 30);
		addSongName.setBounds (1130, 225, 100, 30);
		addSongArtist.setBounds (1130, 285, 100, 30);
		addSongGenre.setBounds (1130, 345, 100, 30);
		addSongYear.setBounds (1130, 405, 100, 30);
		addSongRating.setBounds (1130, 465, 100, 30);
		addSongIndex.setBounds (1130, 525, 100, 30);

		addSong.setBounds (1130, 150, 100, 30);
		deleteSong.setBounds (1130, 200, 100, 30);
		clearPlaylist.setBounds (1130, 250, 100, 30);
		numTimesS.setBounds (1130, 300, 100, 30);
		changeS.setBounds (1130, 350, 100, 30);
		changeP.setBounds (1130, 400, 100, 30);
		hrSongs.setBounds (1130, 450, 105, 30);
		changeSongT.setBounds (1130, 225, 100, 30);
		changeSongI.setBounds (1130, 285, 100, 30);

		next.setBounds (1250, 370, 50, 30);
		cancel.setBounds (1060, 370, 50, 30);
		back.setBounds (1160, 370, 50, 30);

		addSong.addActionListener (this);
		deleteSong.addActionListener (this);
		clearPlaylist.addActionListener (this);
		numTimesS.addActionListener (this);
		changeP.addActionListener (this);
		changeS.addActionListener (this);
		hrSongs.addActionListener (this);
		changeSongT.addActionListener (this);
		changeSongI.addActionListener (this);

		addPlaylistName.addActionListener (this);
		addSongName.addActionListener (this);
		addSongArtist.addActionListener (this);
		addSongYear.addActionListener (this);
		addSongGenre.addActionListener (this);
		addSongRating.addActionListener (this);
		addSongIndex.addActionListener (this);
		next.addActionListener (this);
		cancel.addActionListener (this);
		back.addActionListener (this);

		song1 = getAudioClip (getCodeBase (), "You and I.wav");
		song2 = getAudioClip (getCodeBase (), "Smoke and Fire.wav");
		song3 = getAudioClip (getCodeBase (), "Loud.wav");
		song4 = getAudioClip (getCodeBase (), "Ghost.wav");
		song5 = getAudioClip (getCodeBase (), "Hide Away.wav");
		song6 = getAudioClip (getCodeBase (), "I Want To Write You A Song.wav");
		song7 = getAudioClip (getCodeBase (), "Lush Life.wav");
		song8 = getAudioClip (getCodeBase (), "Permanent Vacation.wav");
		song9 = getAudioClip (getCodeBase (), "Photograph.wav");

		sArray [0] =song1;
		sArray [1] =song2;
		sArray [2] =song3;
		sArray [3] =song4;
		sArray [4] =song5;
		sArray [5] =song6;
		sArray [6] =song7;
		sArray [7] =song8;
		sArray [8] =song9;

		img = getToolkit ().getImage ("Capture1.JPG");
		prepareImage (img, this);
		tracker = new MediaTracker (this);
		tracker.addImage (img, 0);
		try
		{
			tracker.waitForAll ();
		}
		catch (InterruptedException e)
		{
		}
		// If there were any errors loading the image, then abort the program with a message.
		if (tracker.isErrorAny ())
		{
			showStatus ("Couldn't load ");
			return;
		}
		addMouseListener (this);
		addMouseMotionListener (this);
	}


	// Here we will show the results of our actions
	public void paint (Graphics g)
	{
		if (screen2)
		{ //slewify screen
			g.drawImage (img, 0, 0, this);
			g.setColor (pList);
			g.setFont (fontP);
			int y = 120;

			for (int i = 0 ; i < sl1.currentPlaylistNo ; i++)
			{
				g.drawString (sl1.playlists [i].getName (), 15, y);
				y += 45;
			}
			g.drawString (""+sl1.currentPlaylistNo,210,584); 
			if (foundP != null)
			{
				g.setFont (fontP);
				g.setColor (color1);//or white
				g.drawString (""+foundP.getListSize(),870,95); 
				g.drawString (foundP.getName(),355,95); 

				node = foundP.getListHead ();
				y = 190;
				while (node != null)
				{
					g.setFont (font1);
					g.setColor (color);
					g.drawString (node.displayName (), 295, y);
					g.drawString (node.displayArtist (), 465, y);
					g.drawString (node.displayYear (), 640, y);
					g.drawString (node.displayGenre (), 745, y);
					g.drawString (""+node.displayRating (), 895, y);

					y += 30;
					node = node.next;
					g.setColor (color1);
				}
				g.setColor (color);
				if (songN!=null){
					g.drawString (songN.displayName (), 30,620);
				}

			}
			g.setFont (font1);
			g.setColor (color);

		}
		if (screen3)
		{ //add playlist
			g.drawString ("ADD PLAYLIST", 1105, 225);
			g.drawString ("Name", 1100, 275);

		}
		if (screen4)
		{ //after an action like adding, deleting ad more

			g.drawString (get, 1120,330);
		}
		if (screen5)
		{ //when clicking on the  playlists
			g.drawString ("Suggestions", 1130, 110);

		}

		if (screen6)
		{ //add playlist
			g.drawString ("ADD PLAYLIST", 1100, 225);
			g.drawString ("Name", 1130, 275);
		}

		if (screen7)
		{ //after adding  playlist
			g.drawString ("ADD SONG", 1130, 170);
			g.drawString ("Title", 1130, 215);
			g.drawString ("Artist", 1130, 275);
			g.drawString ("Genre", 1130, 335);
			g.drawString ("Year", 1130, 395);
			g.drawString ("Rating", 1130, 455);
			g.drawString ("Index", 1130, 515);
	
		}
		if (screen8)
		{ //after an action like adding, deleting ad more

			//	g.setColor (color);
			g.drawString (get, 1120,330);
		}


		if (screen9)
		{ //Delete song from the playlist
			g.drawString ("DELETE SONG ", 1090, 170);
			g.drawString ("Title", 1130, 215);
			g.drawString ("Index", 1130, 275);
	
		}

		if (screen10)
		{ //Delete song from the playlist
			g.drawString ("SONG OCCURANCE ", 1090, 170);
			g.drawString ("Title", 1130, 215);
			g.drawString ("Artist", 1130, 275);
		
		}
		if (screen11)
		{ //Delete song from the playlist
			g.drawString ("Change Playlist ", 1090, 170);
			g.drawString ("New Name", 1130, 215);
	
		}

		if (screen12)
		{
			g.drawString ("Change Song ", 1130, 170);
			g.drawString ("Choose", 1137, 215);
		}

		if (screen13)
		{
			g.drawString ("Find Song ", 1130, 170);
			g.drawString ("Title", 1130, 215);
		}

		if (screen14)
		{
			g.drawString ("Find Song ", 1130, 170);
			g.drawString ("Index", 1130, 215);
		
		}

		if (screen15)
		{
			g.drawString ("Change Song ", 1130, 170);
			if (foundS != null)
			{
				g.drawString ("Title", 1130, 215);
				g.drawString ("Artist", 1130, 275);
				g.drawString ("Genre", 1130, 335);
				g.drawString ("Year", 1130, 395);
				g.drawString ("Rating", 1130, 455);

			}

			g.drawString (get, 1125, 540);
		}

		g.drawString ("(" + xpos + "," + ypos + ")", xpos, ypos); //LISTS COORDINATES

	}


	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource () == next)
		{
			if (screen3)
			{
				screen3 = false;
				screen4 = true;
				remove (addPlaylistName);
				remove (next);
				remove (cancel);
				add (back);
				Playlist p1 = new Playlist (addPlaylistName.getText ());
				get = sl1.addPlaylist (p1);

			}
			if (screen7)
			{
				screen7 = false;
				screen8 = true;
				remove (addSongName);
				remove (addSongArtist);
				remove (addSongGenre);
				remove (addSongRating);
				remove (addSongYear);
				remove (addSongIndex);

				remove (next);
				remove (cancel);
				add (back);

				try
				{
					input = Integer.parseInt (addSongRating.getText().trim());
				} 
				catch (NumberFormatException e) {
					addSongRating.setText ("0");
				}

				//create an exception
				if (addSongRating.getText ().trim ().equals (""))
				{
					addSongRating.setText ("0");
				}
				Song s1 = new Song (addSongName.getText (), addSongArtist.getText (),
						addSongYear.getText (), addSongGenre.getText (), Integer.parseInt (addSongRating.getText ().trim ()));

				try
				{
					input = Integer.parseInt (addSongIndex.getText().trim());
				} 
				catch (NumberFormatException e) {
					addSongIndex.setText ("");
				}
				if (addSongIndex.getText ().trim ().equals (""))
					get = foundP.addSongToPlaylist (s1);
				else
					get = foundP.addSongToPlaylist (s1, Integer.parseInt (addSongIndex.getText ().trim ()));
				//display=sl1.displayPlaylistOrder();
			}

			if (screen15)
			{
				screen15 = false;
				remove (next);
				remove (cancel);
				back.setBounds (1010, 580, 50, 30);
				add (back);
				remove (addSongName);
				remove (addSongArtist);
				remove (addSongGenre);
				remove (addSongRating);
				remove (addSongYear);

				try
				{
					input = Integer.parseInt (addSongRating.getText().trim());
				} 
				catch (NumberFormatException e) {
					addSongRating.setText ("0");
				}

				foundS.changeArtist (addSongArtist.getText ());
				foundS.changeTitle (addSongName.getText ());
				foundS.changeGenre (addSongGenre.getText ());
				foundS.changeYear (addSongYear.getText ());
				foundS.changeRatings (Integer.parseInt (addSongRating.getText ().trim ()));
				get = "Song Information changed";
				screen8 = true;
			}
			if (screen9)
			{
				screen9 = false;
				screen8 = true;
				remove (addSongName);
				remove (addSongIndex);

				remove (next);
				remove (cancel);
				add (back);
				//create an exception

				try
				{
					input = Integer.parseInt (addSongIndex.getText().trim());
				} 
				catch (NumberFormatException e) {
					addSongIndex.setText ("0");
				}

				if (addSongIndex.getText ().trim ().equals (""))
					get = foundP.deleteSong (addSongName.getText ());
				else
					get = foundP.deleteSong (Integer.parseInt (addSongIndex.getText ().trim ()));

			}

			if (screen10)
			{

				remove (addSongName);
				remove (addSongArtist);

				screen8 = true;
				screen10 = false;

				remove (next);
				remove (cancel);
				add (back);
				//create an exception

				get = "" + foundP.numTimes (addSongName.getText (), addSongArtist.getText ());
			}


			if (screen11)
			{
				remove (addPlaylistName);

				screen8 = true;
				screen11 = false;

				remove (next);
				remove (cancel);
				add (back);
				//create an exception
				get = "New Name: " + foundP.changeName (addPlaylistName.getText ());
			}

			if (screen13)
			{
				remove (addSongName);
				screen13 = false;
				foundS = foundP.findSongName (addSongName.getText ());
				if (foundS != null)
				{
					addSongName.setText (foundS.getTitle ());
					addSongArtist.setText (foundS.getArtist ());
					addSongGenre.setText (foundS.getGenre ());
					addSongRating.setText ("" + foundS.getRatings ());
					addSongYear.setText (foundS.getYear ());
					next.setBounds (1250, 580, 50, 30);
					cancel.setBounds (1060, 580, 50, 30);

					addSongName.setBounds (1130, 225, 100, 30);
					addSongArtist.setBounds (1130, 285, 100, 30);
					addSongGenre.setBounds (1130, 345, 100, 30);
					addSongYear.setBounds (1130, 405, 100, 30);
					addSongRating.setBounds (1130, 465, 100, 30);

					//create an exception
					add (addSongName);
					add (addSongArtist);
					add (addSongGenre);
					add (addSongRating);
					add (addSongYear);
					get = "Song Found";

					screen15 = true;
					//screen16=true;
				}
				else
				{
					get = "Song Not Found";
					remove (next);
					remove (cancel);
					add (back);
					screen8 = true;
				}
				//try empty list and stuff
				//getSongFromTitle
			}

			if (screen14)
			{
				remove (addSongIndex);
				screen14 = false;
				try
				{
					input = Integer.parseInt (addSongIndex.getText().trim());
				} 
				catch (NumberFormatException e) {
					addSongIndex.setText ("0");
				}

				if (addSongIndex.getText ().trim ().equals (""))
					addSongIndex.setText ("0");


				foundS = foundP.getFromIndex (Integer.parseInt (addSongIndex.getText ().trim ())).getSong ();

				if (foundS != null)
				{
					addSongName.setText (foundS.getTitle ());
					addSongArtist.setText (foundS.getArtist ());
					addSongGenre.setText (foundS.getGenre ());
					addSongRating.setText ("" + foundS.getRatings ());
					addSongYear.setText (foundS.getYear ());
					next.setBounds (1250, 580, 50, 30);
					cancel.setBounds (1060, 580, 50, 30);

					addSongName.setBounds (1130, 225, 100, 30);
					addSongArtist.setBounds (1130, 285, 100, 30);
					addSongGenre.setBounds (1130, 345, 100, 30);
					addSongYear.setBounds (1130, 405, 100, 30);
					addSongRating.setBounds (1130, 465, 100, 30);

					//create an exception
					add (addSongName);
					add (addSongArtist);
					add (addSongGenre);
					add (addSongRating);
					add (addSongYear);
					get = "Song Found";
					screen15 = true;
					//screen16=true;
				}
				else
				{
					get = "Song Not Found";
					screen8 = true;
					remove (next);
					remove (cancel);
					add (back);
				}
			}
			repaint ();
		}


		if (evt.getSource () == cancel)
		{
			get = "";
			screen3 = false;
			remove (next);
			remove (cancel);
			remove (addPlaylistName);
			//add other stuff
			if (screen7 || screen9 || screen10 || screen11 || screen12 || screen13 || screen14 || screen15 /*||screen16*/)
			{
				remove (addSongName);
				remove (addPlaylistName);
				remove (addSongArtist);
				remove (addSongGenre);
				remove (addSongRating);
				remove (addSongYear);
				remove (addSongIndex);
				remove (changeSongI);
				remove (changeSongT);

				remove (addSongName);
				remove (addSongArtist);
				remove (addSongGenre);
				remove (addSongRating);
				remove (addSongYear);

				add (addSong);
				add (deleteSong);
				add (clearPlaylist);
				add (numTimesS);
				add (changeS);
				add (changeP);
				add (hrSongs);

				screen7 = false;
				screen9 = false;
				screen10 = false;
				screen11 = false;
				screen12 = false;
				screen13 = false;
				screen14 = false;
				screen15 = false;
				screen5 = true;



			}

		}

		if (evt.getSource () == back)
		{
			remove (back);
			screen4 = false;

			if (screen8 || screen12 /*||screen16*/)
			{

				add (addSong);
				add (deleteSong);
				add (clearPlaylist);
				add (numTimesS);
				add (changeS);
				add (changeP);
				add (hrSongs);
				screen8 = false;
				screen5 = true;
				remove (changeSongI);
				remove (changeSongT);
				screen12 = false;
				get = "";
			}
		}

		if (evt.getSource () == addSong)
		{
			next.setBounds (1250, 580, 50, 30);
			cancel.setBounds (1060, 580, 50, 30);
			//back.setBounds(1200,460,50,30);
			addSongName.setBounds (1130, 225, 100, 30);
			addSongArtist.setBounds (1130, 285, 100, 30);
			addSongGenre.setBounds (1130, 345, 100, 30);
			addSongYear.setBounds (1130, 405, 100, 30);
			addSongRating.setBounds (1130, 465, 100, 30);
			addSongIndex.setBounds (1130, 525, 100, 30);

			add (addSongName);
			add (addSongArtist);
			add (addSongGenre);
			add (addSongYear);
			add (addSongRating);
			add (addSongIndex);
			add (next);
			add (cancel);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = "";
			screen7 = true;
			screen3 = false;
			screen8 = false;
			screen5 = false;
		}

		if (evt.getSource () == deleteSong)
		{
			next.setBounds (1250, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);
			//back.setBounds(1200,460,50,30);
			addSongIndex.setBounds (1130, 285, 100, 30);

			add (addSongName);
			add (addSongIndex);
			add (next);
			add (cancel);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = "";
			screen9 = true;
			screen3 = false;
			screen8 = false;
			screen5 = false;
		}
		if (evt.getSource () == clearPlaylist)
		{
			//back.setBounds(1200,460,50,30);

			add (back);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = foundP.clearList ();
			screen8 = true;
			screen3 = false;
			screen5 = false;

		}

		if (evt.getSource () == numTimesS)
		{
			//back.setBounds(1200,460,50,30);
			addSongName.setBounds (1130, 225, 100, 30);
			addSongArtist.setBounds (1130, 285, 100, 30);
			next.setBounds (1250, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);


			add (addSongName);
			add (addSongArtist);

			add (cancel);
			add (next);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = "";
			screen10 = true;
			screen3 = false;
			screen5 = false;
		}

		if (evt.getSource () == changeP) //change Playlist Name
		{
			//back.setBounds(1200,460,50,30);
			addPlaylistName.setBounds (1100, 225, 100, 30);
			next.setBounds (1250, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);
			addPlaylistName.setText (foundP.getName ());
			add (addPlaylistName);

			add (cancel);
			add (next);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = "";
			screen11 = true;
			screen3 = false;
			screen5 = false;
		}

		if (evt.getSource () == changeS)
		{
			next.setBounds (1250, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);
			//back.setBounds(1200,460,50,30);
			addSongIndex.setBounds (1130, 285, 100, 30);

			add (back);
			add (changeSongT);
			add (changeSongI);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = "";
			screen12 = true; //choose
			screen3 = false;
			screen8 = false;
			screen5 = false;
		}

		if (evt.getSource () == changeSongT)
		{
			next.setBounds (1250, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);

			add (addSongName);
			add (next);
			add (cancel);
			remove (back);
			remove (changeSongT);
			remove (changeSongI);

			get = "";
			screen13 = true; //change song using name
			screen3 = false;
			screen8 = false;
			screen5 = false;
			screen12 = false;
		}

		if (evt.getSource () == changeSongI)
		{
			next.setBounds (1200, 340, 50, 30);
			cancel.setBounds (1060, 340, 50, 30);
			//back.setBounds(1200,460,50,30);
			addSongIndex.setBounds (1130, 225, 100, 30);


			add (addSongIndex);
			add (next);
			add (cancel);
			remove (back);
			remove (changeSongT);
			remove (changeSongI);

			get = "";
			screen14 = true; //change song using index
			screen3 = false;
			screen8 = false;
			screen5 = false;
			screen12 = false;
		}



		if (evt.getSource () == hrSongs)
		{
			//back.setBounds(1200,460,50,30);

			add (back);
			remove (addSong);
			remove (deleteSong);
			remove (clearPlaylist);
			remove (numTimesS);
			remove (changeS);
			remove (changeP);
			remove (hrSongs);
			get = foundP.sortByRating ();
			screen8 = true;
			screen3 = false;
			screen5 = false;

		}
		repaint ();


	}


	public void mouseClicked (MouseEvent me)
	{
		//Saves the coordinates of the clicks
		xpos = me.getX ();
		ypos = me.getY ();

		if (screen2)
		{
			if (xpos >= 0 && xpos <= 140 && ypos >= 542 && ypos <= 590) //add Playlist
			{
				next.setBounds (1250, 370, 50, 30);
				cancel.setBounds (1060, 370, 50, 30);
				back.setBounds (1160, 370, 50, 30);
				add (addPlaylistName);
				add (next);
				add (cancel);
				remove (addSong);
				remove (deleteSong);
				remove (clearPlaylist);
				remove (numTimesS);
				remove (changeS);
				remove (changeP);
				remove (hrSongs);
				remove (changeSongI);
				remove (changeSongT);
				remove (addSongName);
				remove (addSongArtist);
				remove (addSongGenre);
				remove (addSongRating);
				remove (addSongYear);
				remove (addSongIndex);
				remove (back);

				screen6 = false;
				screen7 = false;
				screen8 = false;
				screen9 = false;
				screen10 = false;
				screen11 = false;
				screen3 = true;
				screen4 = true;
				screen5 = false;
				screen12 = false;
				screen14 = false;
				screen13 = false;
				get="";


			}
			if (xpos >= 215 && xpos <= 250 && ypos >= 600 && ypos <= 630) //add Playlist
			{
				if (sl1.currentPlaylistNo >= 1&&foundP!=null&&foundP.getListSize()>0)
				{
					if (songN==null) 
					{
						songN=foundP.getListHead();
						sArray[0].play();
					}	
					else if (songN==foundP.getLastSong())
					{
						songN=foundP.getListHead();
						sArray[sNum].stop();
						if (sNum>=8)
							sNum=0;
						else 
							
							sNum++;
						
						sArray[sNum].play();
					//	song1.play();
					}
					else if (songN.getNext()==null) 
					{
						songN=foundP.getListHead();
						sArray[sNum].stop();
						if (sNum>=8)
							sNum=0;
						else 
							
							sNum++;
						
						sArray[sNum].play();
					//	song1.play();
					}	
					else 
					{
						songN=songN.getNext();
						sArray[sNum].stop();
						if (sNum>=8)
							sNum=0;
						else 
							
							sNum++;
						
						sArray[sNum].play();
				
					}
					
				}
			}
			if (sl1.currentPlaylistNo >= 1)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 83 && ypos <= 133) //play
				{
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;

					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);
					remove (changeSongI);
					remove (changeSongT);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen12 = false;
					screen13 = false;
					screen14 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [0];
					songN=foundP.getListHead();
					//add bunch of stuff
					sNum=0;
				}
			}

			if (sl1.currentPlaylistNo >= 2)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 133 && ypos <= 183) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen12 = false;
					screen11 = false;

					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [1];
					songN=foundP.getListHead();
				}
			}

			if (sl1.currentPlaylistNo >= 3)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 183 && ypos <= 213) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen12 = false;
					screen11 = false;

					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;

					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [2];
					songN=foundP.getListHead();

				}
			}

			if (sl1.currentPlaylistNo >= 4)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 213 && ypos <= 243) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen12 = false;

					screen11 = false;

					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [3];
					songN=foundP.getListHead();

				}
			}

			if (sl1.currentPlaylistNo >= 5)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 243 && ypos <= 273) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);
					screen12 = false;
					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;

					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [4];
					songN=foundP.getListHead();

				}
			}
			if (sl1.currentPlaylistNo >= 6)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 273 && ypos <= 303) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen12 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [5];
					songN=foundP.getListHead();

				}
			}
			if (sl1.currentPlaylistNo >= 7)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 303 && ypos <= 333) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen12 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [6];
					songN=foundP.getListHead();

				}
			}
			if (sl1.currentPlaylistNo >= 8)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 333 && ypos <= 363) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen11 = false;
					screen12 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [7];
					songN=foundP.getListHead();

				}
			}

			if (sl1.currentPlaylistNo >= 9)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 363 && ypos <= 393) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);
					screen13 = false;
					screen14 = false;
					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen12 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [8];
					songN=foundP.getListHead();

				}
			}
			if (sl1.currentPlaylistNo >= 10)
			{
				if (xpos >= 0 && xpos <= 270 && ypos >= 393 && ypos <= 413) //play
				{
					//playlist1=true;
					remove (next);
					remove (cancel);
					remove (back);
					remove (addPlaylistName);
					screen3 = false;
					screen4 = false;
					screen5 = true;
					remove (changeSongI);
					remove (changeSongT);
					screen13 = false;
					screen14 = false;
					//add bunch of stuff
					remove (addSongName);
					remove (addSongArtist);
					remove (addSongGenre);
					remove (addSongRating);
					remove (addSongYear);
					remove (addSongIndex);
					remove (back);

					screen6 = false;
					screen7 = false;
					screen8 = false;
					screen9 = false;
					screen10 = false;
					screen11 = false;
					screen12 = false;
					add (addSong);
					add (deleteSong);
					add (clearPlaylist);
					add (numTimesS);
					add (changeS);
					add (changeP);
					add (hrSongs);
					foundP = sl1.playlists [9];
					songN=foundP.getListHead();

				}
			}
		}
		repaint ();
	}


	public void update (Graphics g)
	{
		// initialize buffer
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize ().width, this.getSize ().height);
			dbg = dbImage.getGraphics ();
		}

		// clear screen in background
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize ().width, this.getSize ().height);

		// draw elements in background
		dbg.setColor (getForeground ());
		paint (dbg);

		// draw image on the screen
		g.drawImage (dbImage, 0, 0, this);
	}


	public void mouseMoved (MouseEvent me)
	{
		xpos = me.getX (); //checks x - position of the mouse
		ypos = me.getY (); //checks y - position of the mouse

		repaint ();
	}


	public void mouseDragged (MouseEvent me)
	{
	}


	public void mousePressed (MouseEvent me)
	{
	}


	public void mouseReleased (MouseEvent me)
	{
	}


	public void mouseEntered (MouseEvent me)
	{
	}


	public void mouseExited (MouseEvent me)
	{
	}
}
