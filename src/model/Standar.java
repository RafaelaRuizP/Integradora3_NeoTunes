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
    public String addPlaylist(String name, int id){
        String message="";
        boolean stop = false;
        for (int i = 0;i<myPlaylist.length && !stop; i++){
                if(myPlaylist[i] == null){
                        myPlaylist[i] = new Playlist(name, id);
                        message="Playlist created successfully";
                        stop = true;
                }message="Already exist a playlist with that id.";
        }
        return message;
    }

    public String sharePlaylist(int playlistPosition) {
        return myPlaylist[playlistPosition].generateMatrix();
    }

    public boolean addAudioToPlaylist(int playlistChosen, Audio newPlaylistSong) {
        return myPlaylist[playlistChosen].addAudios(newPlaylistSong);
    }

    public boolean removeAudioToPlaylist(int playlistChosen, int badPlaylistSong) {
        return myPlaylist[playlistChosen].removeAudios(badPlaylistSong);
    }
    public Playlist search(int id){
        Playlist obj=null;
        boolean confirm= false;
        for(int i=0; i<myPlaylist.length && !confirm; i++){
            if(myPlaylist[i]!=null && myPlaylist[i].getId()==id){
                    obj=myPlaylist[i];
                    confirm=true;
                }
            } 
        return obj;
    }

    public Playlist searchPosition(int index){
        Playlist obj=null;
        boolean confirm= false;
        for(int i=0; i<myPlaylist.length && !confirm; i++){
            if(myPlaylist[i]!=null && (myPlaylist[i]==myPlaylist[index])){
                    obj=myPlaylist[i];
                    confirm=true;
                }
            } 
        return obj;
    }

    public String showPlaylist(){
        String message = "";
        for (int i = 0; i< myPlaylist.length; i++){
            if (myPlaylist[i]!=null){
                message  += (i+". "+ myPlaylist[i].getName()+"\n");
            }
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
