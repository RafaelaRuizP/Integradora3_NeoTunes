package model;
import java.util.*;

public class Creator extends Producer{
    //Relations
    private ArrayList <Podcast> podcasts;
    //method
    /**
     * Constructor class's method Creator (Producer user)
     * @param nickname
     * @param cc
     * @param iniDate
     * @param name
     * @param url
     */
    public Creator(String nickname, String cc, Calendar iniDate, String name, String url){
        super(nickname, cc, iniDate, name, url);
        podcasts = new ArrayList<Podcast>();
    }

    /**
     * A method that collect creator user (producer) information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString();
        return message;
    }

    /**
     * Method to add a podcast into a creator user account
     * @param name :String. Podcast's name.
     * @param url :String. Podcast's url image.
     * @param length :double. Podcast's length.
     * @param numRep :int. Podcast's number of visualizations.
     * @param desc :String. Podcast's description.
     * @param category :int. Podcast's category.
     * @return message:String. A message about the result of the process.
     */
    public String addPodcast(String name, String url, double length, int numRep, String desc, int category){
        String message="";
        podcasts.add(new Podcast(name, url, length, numRep, desc, category));
        message="Podcast created succesfully";
        return message;
    }
    //Getters and setters
    public ArrayList <Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList <Podcast> podcasts) {
        this.podcasts = podcasts;
    }

}
