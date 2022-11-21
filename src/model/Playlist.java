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
    public Playlist(String name, int id){
        this.name=name;
        this.id=id;
        audios = new ArrayList<Audio>();
    }
    public boolean addAudios(Audio audio){
        audios.add(audio);
        return true;
    }

    public boolean removeAudios(int audio){
        audios.remove(audio);
        return true;
    }
    

    public String generateMatrix(){
        int[][] matrix = new int[6][6];
        String message="";
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
                if (matrix[i][j] < 10) {
                    message+= " " + matrix[i][j] + " ";
                } else {
                    message+= matrix[i][j] + " ";
                }
            }
            message += "\n";
        }

        switch (typePlaylist()) {
            case 1:
                message+= "This is the code: "+ idOnlySongs(matrix);
                break;
            case 2:
                message+= "This is the code: "+ idOnlyPodcasts(matrix);
            break;
            case 3:
                message+= "This is the code: "+ idBothAudios(matrix);
            break;
        
            default:
                break;
        }
        return message;
    }

    public int typePlaylist(){
        boolean hasSongs = false;
        boolean hasPodcast = false;
        for(int i=0; i<audios.size() && (!hasPodcast||!hasSongs); i++){
            if(audios.get(i) instanceof Song){
                hasSongs= true;
            }
            if(audios.get(i) instanceof Podcast){
                hasPodcast= true;
            }
        }

        if(hasSongs && hasPodcast){
            return 3;
        } else if(hasPodcast){
            return 2;
        } else{
            return 1;
        }
    }

    public String idOnlySongs(int[][] matrix){
        String message = "";

        for (int i = matrix.length-1; i >= 0; i--) {
            message += matrix[i][0];
        }

        for (int i = 1; i<matrix.length-1; i++) {
            message += matrix[i][i];
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            message += matrix[i][5];
        }

        return message;
    }

    public String idOnlyPodcasts(int[][] matrix){
        String message = "";

        for (int i = 0; i<3; i++) {
            message += matrix[0][i];
        }

        for (int i = 1; i<matrix.length-1; i++) {
            message += matrix[i][2];
        }

        for (int i = 2; i > 4; i++) {
            message += matrix[5][i];
        }

        for (int i = matrix.length-2; i<=1; i++) {
            message += matrix[i][3];
        }

        for (int i = 3; i< matrix.length; i++) {
            message += matrix[0][i];
        }

        return message;
    }

    public String idBothAudios(int[][] matrix){
        String message = "";
        int count = 0;

        for (int i = matrix.length-1; i >= 0; i--) {

            if (i<= 2) {
                count++;
            }

            for (int j = matrix.length-1; j >= (0+count); j--) {
                if(i % 2 == 0) {
                    if (!(j % 2 == 0)) {
                        message += matrix[i][j];
                    }
                } else {
                    if (j % 2 == 0) {
                        message += matrix[i][j];
                    }
                }

            }
        }

        return message;
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
