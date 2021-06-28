package view;

import musichub.business.*;

import java.util.Iterator;
import java.util.Scanner;

public class AlbumView extends GeneralView {

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;
	String choice = scan.nextLine();
	MusicHub theHub = new MusicHub();


	public void albumOrderedByDate() {

		System.out.println(theHub.getAlbumsTitlesSortedByDate());
		printAvailableCommands();
		choice = scan.nextLine();
	}

	public void albumSongsOrderedByGenre() {

		System.out.println(
				"Songs of an album sorted by genre will be displayed; enter the album name, available albums are:");
		System.out.println(theHub.getAlbumsTitlesSortedByDate());
		albumTitle = scan.nextLine();
		try {
			System.out.println(theHub.getAlbumSongsSortedByGenre(albumTitle));
		} catch (NoAlbumFoundException ex) {
			System.out.println("No album found with the requested title " + ex.getMessage());
		}
		printAvailableCommands();
		choice = scan.nextLine();

	}

	public void albumSongs() {

		System.out.println("Songs of an album will be displayed; enter the album name, available albums are:");
		System.out.println(theHub.getAlbumsTitlesSortedByDate());

		albumTitle = scan.nextLine();
		try {
			System.out.println(theHub.getAlbumSongs(albumTitle));
		} catch (NoAlbumFoundException ex) {
			System.out.println("No album found with the requested title " + ex.getMessage());
		}
		printAvailableCommands();
		choice = scan.nextLine();

	}

	public void showsAlbums() {

		System.out.println("New list of albums: ");
		Iterator<Album> ita = theHub.albums();
		while (ita.hasNext()) System.out.println(ita.next().getTitle());
		System.out.println("Album created!");
		printAvailableCommands();
		choice = scan.nextLine();
	}

	public void newSongToAlbumAdded() {
		System.out.println("Song added to the album!");
		printAvailableCommands();
		choice = scan.nextLine();
	}

	@Override
	protected void tellIfAdded(boolean bool) {
		// TODO Auto-generated method stub

	}

}