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
        playlists = new ArrayList<Playlist>();
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
            users.add(new Artist(nickname, cc, iniDate, name, url) );
            message="The artist user was created successfully.";
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

    public String showStandarOrPremium(int option){
        String position="";
        for(int i=0; i<users.size(); i++){
            if(option==1){
                if(users.get(i) instanceof Standar){
                    Standar obj = (Standar) users.get(i);
                    position+= i+". "+obj.getNickname()+"\n";
                }
            }else if(option==2){
                if(users.get(i) instanceof Premium){
                    Premium obj = (Premium) users.get(i);
                    position+= i+". "+obj.getNickname()+"\n";
                }
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
    public String addPlaylist(String name, String cc, int option, int id){
        String message= "User not found";
        boolean confirm=search(cc);
        if(confirm & option==1){
            for(int i=0; i<users.size(); i++){
                if(users.get(i) instanceof Standar){
                    Standar obj = (Standar) users.get(i);
                    if(obj.getCc().equalsIgnoreCase(cc)){
                        if(searchPlaylist(id)==false){
                            message= obj.addPlaylist(name, id);
                            playlists.add(new Playlist(name, id));
                        }
                    }
                }
            } 
        }else if(confirm & option==2){
            for(int i=0; i<users.size(); i++){
                if(users.get(i) instanceof Premium){
                    Premium obj = (Premium) users.get(i);
                    if(obj.getCc().equalsIgnoreCase(cc)){
                        if(searchPlaylist(id)==false){
                            message= obj.addPlaylist(name, id);
                            playlists.add(new Playlist(name, id));
                        }
                    }
                }
            }
        }
        return message;
    }

    public boolean searchPlaylist(int id) {
        boolean confirm = false;
        for (int i = 0; i < playlists.size() && !confirm; i++) {
            if (playlists.get(i).getId() == id) {
                confirm = true;
            }
        }
        return confirm;
    }

    /**
     * Method to modify certain things of a created playlist.
     * @param name :String, name of the playlist.
     * @param option :int, the option that will define the process to be performed on that playlist.
     * @param id :int, the id of the playlist.
     * @return message: String, verification of the process.
     */
    public String editPlaylist(String name, int optionUser, int options, int playlist, int user, int audio){
        String message="";
        if(optionUser==1){
            if(users.get(user) instanceof Standar){
                Standar obj = (Standar) users.get(user);
                if(options==1){
                    obj.searchPosition(playlist).setName(name);
                    message="Changes ocurred.";
                }else if(options==2){
                    obj.addAudioToPlaylist(playlist, audios.get(audio));
                    message="Audio added to playlist";
                }else if(options==3){
                    obj.removeAudioToPlaylist(playlist, audio);
                }
            }
        }else if(optionUser==2){
            if(users.get(user) instanceof Premium){
                Premium obj = (Premium) users.get(user);
                if(options==1){
                    obj.searchPosition(playlist).setName(name);
                    message="Changes ocurred.";
                }else if(options==2){
                    obj.addAudioToPlaylist(playlist, audios.get(audio));
                    message="Audio added to playlist";
                }else if(options==3){
                    obj.removeAudioToPlaylist(playlist, audio);
                }
            }
        }
        return message;
    }

    public String playAudio(int consumerSelection, int chosenAudio){
        Double duration=0.0;
        int count=1;
        int rp=0;
        String message="";
        if(audios.get(chosenAudio) instanceof Song){
            Song obj = (Song) audios.get(chosenAudio);
            duration= obj.getLength();
            rp= obj.getNumRep()+count;
            count++;
            obj.setNumRep(rp);
            message="The song is played";
        }else if(audios.get(chosenAudio) instanceof Song){
            Song obj = (Song) audios.get(chosenAudio);
            duration= obj.getLength();
            rp= obj.getNumRep()+count;
            count++;
            obj.setNumRep(rp);
            message="The podcast is played";
        }
        return message;
    }


    public String genreMoreListened() {
        int countPop = 0, countRock = 0, countHouse = 0, countTrap = 0;
        Song objaudio = null;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        String mesagge = "";
        int[] storeCounters = new int [4];
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objaudio = (Song) audios.get(i);
                if (objaudio.getGenreType() == GenreType.POP) {
                    count1++;
                    countPop += objaudio.getNumRep();
                } else if (objaudio.getGenreType() == GenreType.ROCK) {
                    count2++;
                    countRock += objaudio.getNumRep();

                } else if (objaudio.getGenreType() == GenreType.HOUSE) {
                    count3++;
                    countHouse += objaudio.getNumRep();

                } else if (objaudio.getGenreType() == GenreType.TRAP) {
                    count4++;
                    countTrap += objaudio.getNumRep();
                }
            }
        }
        storeCounters[0]=count1;
        storeCounters[1]=count2;
        storeCounters[2]=count3;
        storeCounters[3]=count4;

        double max=0.0; 
        int posMax=0;
        for (int i=0; i<storeCounters.length; i++){
            if (max<storeCounters[i]){
                max=storeCounters[i];
                posMax = i;
            }
        }
        if(posMax==storeCounters[0]){
            mesagge = "the most listened genre is Pop with: " + countPop + "reproductions";
        }else if(posMax==storeCounters[1]){
            mesagge = "the most listened genre is Rock with: " + countRock + "reproductions";
        }else if(posMax==storeCounters[2]){
            mesagge = "the most listened genre is House with: " + countHouse + "reproductions";
        }else if(posMax==storeCounters[4]){
            mesagge = "the most listened genre is Trap with: " + countTrap + "reproductions";
        }
        return mesagge;
    }

    public String categoryMoreListened() {
        int countEnt = 0, countFashion = 0, countPol = 0, countVgames = 0;
        Podcast objaudio = null;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        String mesagge = "";
        int[] storeCounters = new int [4];
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Podcast) {
                objaudio = (Podcast) audios.get(i);
                if (objaudio.getPdType() == PdType.ENTERTEINMENT) {
                    count1++;
                    countEnt += objaudio.getNumRep();
                } else if (objaudio.getPdType() == PdType.FASHION) {
                    count2++;
                    countFashion += objaudio.getNumRep();

                } else if (objaudio.getPdType() == PdType.POLITICISM) {
                    count3++;
                    countPol += objaudio.getNumRep();

                } else if (objaudio.getPdType() == PdType.VIDEOGAMES) {
                    count4++;
                    countVgames += objaudio.getNumRep();
                }
            }
        }
        storeCounters[0]=count1;
        storeCounters[1]=count2;
        storeCounters[2]=count3;
        storeCounters[3]=count4;

        double max=0.0; 
        int posMax=0;
        for (int i=0; i<storeCounters.length; i++){
            if (max<storeCounters[i]){
                max=storeCounters[i];
                posMax = i;
            }
        }
        if(posMax==storeCounters[0]){
            mesagge = "the most listened category is Enterteinment with: " + countEnt + "reproductions";
        }else if(posMax==storeCounters[1]){
            mesagge = "the most listened category is Fashion with: " + countFashion + "reproductions";
        }else if(posMax==storeCounters[2]){
            mesagge = "the most listened category is Politicism with: " + countPol + "reproductions";
        }else if(posMax==storeCounters[4]){
            mesagge = "the most listened category is Videogames with: " + countVgames + "reproductions";
        }
        return mesagge;
    }

    public String totalNumRep() {
        int countSong = 0, countPodcast = 0;
        Song objsong = null;
        Podcast objpodcast = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);
                countSong += objsong.getNumRep();
            } else if (audios.get(i) instanceof Podcast) {
                objpodcast = (Podcast) audios.get(i);
                countPodcast = objpodcast.getNumRep();
            }
        }
        return "the number of reproductions for Songs are: " + countSong + " the number of reproductions for Podcast are: "
                + countPodcast;
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

    public String top5Artist() {
        String message = "Top | Name | Plays\n";
        String[] names = new String[5];
        double[] plays = new double[5];
        int producerPlays;
        String name;
        int position;
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Artist) {
                Artist obj = (Artist) users.get(i);
                producerPlays = obj.getNumVisualization();
                name = obj.getName();
                position = -1;
                for (int j = 0; j < 5; j++) {
                    if (producerPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = producerPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 4; i >= 0; i--) {
            message += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return message;
    }

    public String top5Creators() {
        String message = "Top | Name | Plays\n";
        String[] names = new String[5];
        double[] plays = new double[5];
        int producerPlays;
        String name;
        int position;
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song obj = (Song) audios.get(i);
                producerPlays = obj.getNumRep();
                name = obj.getName();
                position = -1;
                for (int j = 0; j < 10; j++) {
                    if (producerPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = producerPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 4; i >= 0; i--) {
            message += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return message;
    }

    public String top5ArtistAndCreators() {
        String message = "Top 5 artists:\n";
        message += top5Artist() + "\n" + "Top 5 content creators:\n";
        message += top5Creators();
        return message;
    }

    public String top10Songs() {
        String message = "Top | Name | Plays\n";
        String[] names = new String[10];
        double[] plays = new double[10];
        int audioPlays;
        String name;
        int position;
        for (int i = 0; i < 10; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song obj = (Song) audios.get(i);
                audioPlays = obj.getNumRep();
                name = obj.getName();
                position = -1;
                for (int j = 0; j < 10; j++) {
                    if (audioPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = audioPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 9; i >= 0; i--) {
            message += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return message;
    }

    public String top10Podcast() {
        String message = "Top | Name | Plays\n";
        String[] names = new String[10];
        double[] plays = new double[10];
        int audioPlays;
        String name;
        int position;
        for (int i = 0; i < 10; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Podcast) {
                Podcast obj = (Podcast) audios.get(i);
                audioPlays = obj.getNumRep();
                name = obj.getName();
                position = -1;
                for (int j = 0; j < 10; j++) {
                    if (audioPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = audioPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 9; i >= 0; i--) {
            message += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return message;
    }

    public String top10SongsAndPodcasts() {
        String message = "Top 10 songs:\n";
        message += top10Songs() + "\n" + "Top 10 podcasts:\n";
        message += top10Podcast();
        return message;
    }

    public String soldSong() {
        double value = 0.0;
        Song objsong = null;
        Song rich = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);
                rich = objsong;
                if (objsong.getNumSold()> rich.getNumSold()) {
                    rich = objsong;
                }
            }
        }
        value = rich.getNumSold() * rich.getPrice();

        return "the song with more units solds is: " + rich.getName() + "with: " + rich.getNumSold()
                + " units sold and total value earned is $" + value;
    }

    public String genreEarn() {
        double value = 0.0;
        Song objsong = null;
        Song rich = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);
                rich = objsong;
                if (objsong.getNumSold()> rich.getNumSold()) {
                    rich = objsong;
                }
            }
        }
        value = rich.getNumSold() * rich.getPrice();

        return "the song with more units solds is: " + rich.getName() + "with: " + rich.getNumSold()
                + " units sold and total value earned is $" + value;
    }

    public String showConsumers(){
        String message = "";
        for (int i = 0; i< users.size(); i++){
            if (users.get(i) instanceof Consumer){
                message  += (i+". "+ users.get(i).getNickname()+"\n");
            }
        }
        return message;
    }

    public String showSongOrPodcast(int option){
        String message = "";
        for (int i = 0; i< audios.size(); i++){
            if(option==1){
                if (audios.get(i) instanceof Song){
                    message  += (i+". "+ audios.get(i).getName()+"\n");
                }
            }else if(option==2){
                if (audios.get(i) instanceof Podcast){
                    message  += (i+". "+ audios.get(i).getName()+"\n");
                }
            }
            
        }
        return message;
    }

    public String showPlaylist(int option, int position){
        String message = "";
            if(option==1){
                if(users.get(position) instanceof Standar){
                    Standar obj = (Standar) users.get(position);
                    message=obj.showPlaylist();
                }
            }else if(option==2){
                if(users.get(position) instanceof Premium){
                    Premium obj = (Premium) users.get(position);
                    message=obj.showPlaylist();
                }
            }
        return message;
    }
    public String showAudiosPlaylist(int option, int position, int indexPlaylist) {
        String message = "";
            if(option==1){
                if(users.get(position) instanceof Standar){
                    Standar obj = (Standar) users.get(position);
                    for(int i=0; i<obj.searchPosition(indexPlaylist).getAudios().size(); i++){
                        message+= i + " ." + audios.get(indexPlaylist).getName();
                    }
                }
            }else if(option==2){
                if(users.get(position) instanceof Premium){
                    Premium obj = (Premium) users.get(position);
                    for(int i=0; i<obj.searchPosition(indexPlaylist).getAudios().size(); i++){
                        message+= i + " ." + audios.get(indexPlaylist).getName();
                    }
                }
            }
        return message;
    }
    
    public String sharePlaylist(int consumerPosition, int playlistPosition, int option) {
        String message = "";
            if(option==1){
                if(users.get(consumerPosition) instanceof Standar){
                    Standar obj = (Standar) users.get(consumerPosition);
                    message=obj.sharePlaylist(playlistPosition);
                }
            }else if(option==2){
                if(users.get(consumerPosition) instanceof Premium){
                    Premium obj = (Premium) users.get(consumerPosition);
                    message=obj.sharePlaylist(playlistPosition);
                }
            }
        return message;
    }

    public String unitsSoldForGenre() {
        int units1 = 0, units2 = 0, units3 = 0, units4 = 0;
        Song objsong = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);

                if (objsong.getGenreType()== GenreType.HOUSE) {
                    units1 += objsong.getNumSold();
                } else if (objsong.getGenreType()== GenreType.POP) {
                    units2 += objsong.getNumSold();

                } else if (objsong.getGenreType()== GenreType.ROCK) {
                    units3 += objsong.getNumSold();

                } else if (objsong.getGenreType()== GenreType.TRAP) {
                    units4 += objsong.getNumSold();
                }
            }
        }

        return "the number of units sold for genre House are: " + units1
                + " the number of units sold for genre pop are: " + units2 + "the number of units sold for rock are: "
                + units3 + "the numeber of units sold for trap are: " + units4;
    }

    public String buySong(int indexSong){
        int count =1;
        int newValue=0;
        String message="";
        if(audios.get(indexSong) instanceof Song){
            Song obj = (Song) audios.get(indexSong);
            newValue= obj.getNumSold()+count;
            obj.setNumSold(newValue);
            message="Canción comprada";
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
