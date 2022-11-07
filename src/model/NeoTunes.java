package model;
import java.util.*;

public class NeoTunes {
    //atributes
    //relations
    private ArrayList <User> users;
    private ArrayList <Audio> audios;
    private ArrayList <Playlist> playlists;
    //methods
    /**
     * Constructor class's method NeoTunes (controller)
     */
    public NeoTunes(){
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
    }
    /**
     * This method creates an object consumer user and add it into the arraylist users. Also, depends of the case
     * to save the certain information by type of user (Standard or premium).
     * @param nickname String, nickname of the consumer user to add.
     * @param cc String, number identification card of the consumer user to add.
     * @param iniDate Calendar, the joining date to the platform.
     * @param option int, the option which it will store the consumer user data by its type.
     * @return messsage:String. Verification of the process.
     */
    public String addUser(String nickname, String cc, Calendar iniDate, int option){
        String message="";
        boolean confirm=search(cc);

        if(!confirm & option==1){
            users.add(new Standar(nickname, cc, iniDate));
            message="The standard user was created successfully.";
        }
        else if(!confirm & option==2){
            users.add(new Premium(nickname, cc, iniDate)); 
            message="The premium user was created successfully."; 
        }
        else if(confirm){
            message="It could not be created because there is already someone with this same document.";
        }
        return message;
    }

    /**
     * This method creates an object producer user and add it into the arraylist users. Also, depends of the case
     * to save the certain information by type of user (Artist or creator).
     * @param nickname String, nickname of the producer user to add.
     * @param cc String, number identification card of the producer user to add.
     * @param iniDate Calendar, the joining date to the platform.
     * @param name String, name of the producer user to add.
     * @param url String, url of the profile image of the producer user to add.
     * @param option int, the option which it will store the producer user data by its type.
     * @return messsage:String. Verification of the process.
     */
    public String addUser(String nickname, String cc, Calendar iniDate, String name, String url, int option){
        String message="";
        boolean confirm=search(cc);

        if(!confirm & option==1){
            users.add(new Producer(nickname, cc, iniDate, name, url));
            message="The producer user was created successfully.";
        }
        else if(!confirm & option==2){
            users.add(new Creator(nickname, cc, iniDate, name, url)); 
            message="The content creator user was created successfully."; 
        }
        else if(confirm){
            message="It could not be created because there is already someone with this same document.";
        }
        return message;
    }

    /**
     * Method to add song data to audios arraylist and to a certain Artist to which this content belongs.
     * @param name :String. Song's name.
     * @param url :String. Song's album url cover.
     * @param length :double. Song's length.
     * @param numRep :int. Song's number of visualizations.
     * @param album :String. Song's album name.
     * @param price :double. Song's price.
     * @param numSold :int. Number of sold units.
     * @param genre :int. Song's genre.
     * @param number :int. Position of the artist user which belongs this content.
     * @return register:String. A message about the result of the process.
     */
    public String addContent(String name, String url, double length, int numRep, String album, double price, int numSold, int genre, int number){
        String register= "";
        audios.add(new Song(name, url, length, numRep, album, price, numSold, genre));
        if(users.get(number) instanceof Artist){
            Artist obj= (Artist) users.get(number);
            register=obj.addSong(name, url, length, numRep, album, price, numSold, genre);
        }
        return register;
    }

    /**
     * Method to add podcast data to audios arraylist and to a certain Creator to which this content belongs.
     *@param name :String. Podcast's name.
     * @param url :String. Podcast's url image.
     * @param length :double. Podcast's length.
     * @param numRep :int. Podcast's number of visualizations.
     * @param desc :String. Podcast's description.
     * @param category :int. Podcast's category.
     * @param number :int. Position of the creator user which belongs this content.
     * @return register:String. A message about the result of the process.
     */
    public String addContent(String name, String url, double length, int numRep, String desc, int category, int number){
        String register= "";
        audios.add(new Podcast(name, url, length, numRep, desc, category));
        if(users.get(number) instanceof Creator){
            Creator obj= (Creator) users.get(number);
            register=obj.addPodcast(name, url, length, numRep, desc, category);
        }
        return register;
    }

    /**
     * This method search and obtains a boolean by a given cc(identificacion) as identifier of the user.
     * @param cc :String, identification of the user to find.
     * @return confirmation:boolean. The result (true or false) of the process.
     */
    public boolean search(String cc){
        User objUser=null;
        boolean confirm= false;
        for(int i=0; i<users.size() && !confirm; i++){
            if(users.get(i).getCc().equalsIgnoreCase(cc)){
                objUser=users.get(i);
                confirm=true;
            }
        } 
        return confirm;
    }
    /**
     * Method to show the toString Method (incorporated in every user and daugther user classes) of a certain user .
     * @return message: String. The information of the user.
     */
    public String giveInformationPeople(){
        String message="";
        for(int i=0; i<users.size(); i++){
                message=users.get(i).toString();
        }
        return message;
    }

    /**
     * Method to show the toString Method (incorporated in every audio and daugther audio classes) of a certain audio.
     * @return message: String. The information of the audio.
     */
    public String giveInformationAudios(){
        String message="";
        for(int i=0; i<audios.size(); i++){
                message=audios.get(i).toString();
        }
        return message;
    }


    /**
     * Method to show the Artist user that are created in the platform.
     * @return position: String. The position with a few atributes of an user of every created artist user.
     */
    public String showArtists(){
        String position="";
        for(int i=0; i<users.size(); i++){
            if(users.get(i) instanceof Artist){
                Artist obj = (Artist) users.get(i);
                position+= i+". "+obj.getName()+" (Nickname: "+obj.getNickname()+")."+"\n";
            }
        }   
        return position;
    }

    /**
     * Method to show the Creator user that are created in the platform.
     * @return position: String. The position with a few atributes of an user of every created creator user.
     */
    public String showCreators(){
        String position="";
        for(int i=0; i<users.size(); i++){
            if(users.get(i) instanceof Creator){
                Creator obj = (Creator) users.get(i);
                position+= i+". "+obj.getName()+" (Nickname: "+obj.getNickname()+")."+"\n";
            }
        }   
        return position;
    }

    /**
     * This method search and obtains an user by a given cc(identificacion) as identifier of the user.
     * @param cc :String, identification of the user to find.
     * @return objUser:User. The object User found.
     */
    public User searchU(String cc){
        User objUser=null;
        boolean confirm= false;
        for(int i=0; i<users.size() && !confirm; i++){
            if(users.get(i).getCc().equalsIgnoreCase(cc)){
                objUser=users.get(i);
                confirm=true;
            }
        } 
        return objUser;
    }

    /**
     * Method to add a playlist that is created for Standard or Premium user.
     * @param name :String, name of the playlist.
     * @param cc :String, identification of the user that belongs this playlist.
     * @param option int, the option which it will store the playlist data by its consumer user type.
     * @return message: String, verification of the process.
     */
    public String addPlaylist(String name, String cc, int option){
        String message="";
        boolean confirm=search(cc);
        if(!confirm & option==1){
            for(int i=0; i<users.size(); i++){
                if(users.get(i) instanceof Standar){
                    Standar obj = (Standar) users.get(i);
                    if(obj.getCc().equalsIgnoreCase(cc)){
                        message= obj.addPlaylist(name);
                        playlists.add(new Playlist(name));
                    }
                }
            } 
        }else if(!confirm & option==2){
            for(int i=0; i<users.size(); i++){
                if(users.get(i) instanceof Premium){
                    Premium obj = (Premium) users.get(i);
                    if(obj.getCc().equalsIgnoreCase(cc)){
                        message= obj.addPlaylist(name);
                        playlists.add(new Playlist(name));
                    }
                }
            }
        }
        return message;
    }

    /**
     * Method to modify certain things of a created playlist.
     * @param name :String, name of the playlist.
     * @param option :int, the option that will define the process to be performed on that playlist.
     * @param id :int, the id of the playlist.
     * @return message: String, verification of the process.
     */
    public String editPlaylist(String name, int option, int id){
        String message="";
        Playlist obj = search(id);
        if(obj!=null){
            if(option==1){
                obj.setName(name);
            }else if(option==2){
            }
        }
        return message;
    }

    /**
     * This method search and obtains a Playlist by a given number as identifier of the playlist.
     * @param id int, identification of the playlist to find.
     * @return obj:Playlist. The object Playlist found.
     */
    public Playlist search(int id){
        Playlist obj=null;
        boolean confirm= false;
        for(int i=0; i<playlists.size() && !confirm; i++){
            if(playlists.get(i).getId()==id){
                    obj=playlists.get(i);
                    confirm=true;
                }
            } 
        return obj;
    }

    /**
     * Show a list where, inside of it, are genres of a song.
     * @return a list as a constant that provides the genres of a song.
     */
    public String showListGenres(){
        return GenreType.LIST_OF_GENRE;
    }

    /**
     * Show a list where, inside of it, are categories of a podcast.
     * @return a list as a constant that provides the categories of a podcast.
     */
    public String showListCategories(){
        return PdType.LIST_OF_CATEGORY;
    }


    //Getters and setters
    public ArrayList <User> getUsers(){
        return users;
    }

    public void setUsers(ArrayList <User> users) {
        this.users = users;
    }


    public ArrayList <Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList <Audio> audios) {
        this.audios = audios;
    }

    public ArrayList <Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList <Playlist> playlists) {
        this.playlists = playlists;
    }

}
