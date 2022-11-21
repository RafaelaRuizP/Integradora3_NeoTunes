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
    public String addPlaylist(String name, int id){
        String message="";
        boolean stop = false;
        for (int i = 0;i<playlists.size() && !stop; i++){
            playlists.add(new Playlist(name, id));
            message="Playlist created successfully";
            stop = true;
            }
        return message;
    }

    public String sharePlaylist(int playlistPosition) {
        return playlists.get(playlistPosition).generateMatrix();
    }

    public String showPlaylist(){
        String message = "";
        for (int i = 0; i< playlists.size(); i++){
            message  += (i+". "+ playlists.get(i).getName()+"\n");
        }
        return message;
    }

    public Playlist searchPosition(int index){
        Playlist obj=null;
        boolean confirm= false;
        for(int i=0; i<playlists.size() && !confirm; i++){
            if(playlists.get(i)==playlists.get(index)){
                obj=playlists.get(i);
                confirm=true;
            }   
        } 
        return obj;
    }

    public boolean addAudioToPlaylist(int playlistChosen, Audio newPlaylistSong) {
        return playlists.get(playlistChosen).addAudios(newPlaylistSong);
    }

    public boolean removeAudioToPlaylist(int playlistChosen, int badPlaylistSong) {
        return playlists.get(playlistChosen).removeAudios(badPlaylistSong);
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
