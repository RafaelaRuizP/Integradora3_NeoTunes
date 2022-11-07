package model;
import java.util.*;

public class Artist extends Producer {
    //Relations
    private ArrayList <Song> songs;
    //method
    /**
     * Constructor class's method Producer (User)
     * @param nickname
     * @param cc
     * @param iniDate
     * @param name
     * @param url
     */
    public Artist(String nickname, String cc, Calendar iniDate, String name, String url){
        super(nickname, cc, iniDate, name, url);
        songs = new ArrayList<Song>();
    }

    /**
     * Method to add a podcast into a creator user account 
     * @param name :String. Song's name.
     * @param url :String. Song's album url cover.
     * @param length :double. Song's length.
     * @param numRep :int. Song's number of visualizations.
     * @param album :String. Song's album name.
     * @param price :double. Song's price.
     * @param numSold :int. Number of sold units.
     * @param genre :int. Song's genre.
     * @return message:String. A message about the result of the process.
     */
    public String addSong(String name, String url, double length, int numRep, String album, double price, int numSold, int genre){
        String message="";
        songs.add(new Song(name, url, length, numRep, album, price, numSold, genre));
        message="Song created succesfully";
        return message;
    }

    /**
     * A method that collect artist user (producer) information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString();
        return message;
    }

    
    //Getters and setters
    public ArrayList <Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList <Song> songs) {
        this.songs = songs;
    }

}
