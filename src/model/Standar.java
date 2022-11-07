package model;

import java.util.Calendar;

public class Standar extends Consumer{
    //atributes
    private int purshasedSongs;
    private int createdAlbum;
    //relations
    private Playlist[] myPlaylist;
    private Ads ads;
    //methods
    /**
     * Constructor class's method Standar (Consumer user)
     * @param nickname
     * @param cc
     * @param iniDate
     */
    public Standar(String nickname, String cc, Calendar iniDate){
       super(nickname, cc, iniDate);
        myPlaylist = new Playlist[20];
    }

    /**
     * Method to add a playlist into a standar user account
     * @param name :String. Name of the playlist
     * @return message:String. A message about the result of the process.
     */
    public String addPlaylist(String name){
        String message="";
        boolean stop = false;
        for (int i = 0;i<myPlaylist.length && !stop; i++){
                if(myPlaylist[i] == null){
                        myPlaylist[i] = new Playlist(name);
                        message="Playlist created successfully";
                        stop = true;
                }message="Already exist a playlist with that id.";
        }
        return message;
    }

    /**
     * A method that collect standard user (consumer) information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString();
        return message;
    }
    //Getters and setters
    public Playlist[] getMyPlaylist() {
        return myPlaylist;
    }

    public void setMyPlaylist(Playlist[] myPlaylist) {
        this.myPlaylist = myPlaylist;
    }

}
