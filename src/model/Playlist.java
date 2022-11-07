package model;
import java.util.*;

public class Playlist {
    //atributes
    private String name;
    private int id;
    //Relations
    private ArrayList <Audio> audios;
    //methods
    /**
     * Constructor class's method Playlist
     * @param name
     */
    public Playlist(String name){
        this.name=name;
        id=0;
        audios = new ArrayList<Audio>();
    }    

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList <Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList <Audio> audios) {
        this.audios = audios;
    }

}
