package model;

import java.util.*;

public class Premium extends Consumer{
    //relations
    private ArrayList <Playlist> playlists;
    //methods
    /**
     * Constructor class's method Premium (Consumer User)
     * @param nickname
     * @param cc
     * @param iniDate
     */
    public Premium(String nickname, String cc, Calendar iniDate){
        super(nickname, cc, iniDate);
        playlists= new ArrayList<Playlist>();
    }

    /**
     * Method to add a playlist into a premium user account
     * @param name :String. Name of the playlist
     * @return message:String. A message about the result of the process.
     */
    public String addPlaylist(String name){
        String message="";
        boolean stop = false;
        for (int i = 0;i<playlists.size() && !stop; i++){
            playlists.add(new Playlist(name));
            message="Playlist created successfully";
            stop = true;
            }
        return message;
    }

    /**
     * A method that collect premium user (consumer) information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString();
        return message;
    }
    //Getters and Setters
    public ArrayList <Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList <Playlist> playlists) {
        this.playlists = playlists;
    }

}
