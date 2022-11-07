package model;

public class Song extends Audio{
    //atributes
    private String album;
    private double price;
    private int numSold;
    //relations
    private GenreType genreType;
    //methods
    /**
     * Constructor class's method Song (Audio)
     * @param name
     * @param url
     * @param length
     * @param numRep
     * @param album
     * @param price
     * @param numSold
     * @param genre
     */
    public Song(String name, String url, double length, int numRep, String album, double price, int numSold, int genre){
        super(name, url, length, numRep);
        this.album=album;
        this.price=price;
        this.numSold=numSold;
        genreType= genreTypeChoose(genre);
    }

    /**
     * This method put a genreType to a given num genre(related to GenreType).
     * @param genre: A number that is related to obtain a genre of song.
     * @return genreType:GenreType. The constant obtained from summoning enum class GenreType.
     */ 
    public GenreType genreTypeChoose(int genre){
        switch (genre) {
            case 1:
                genreType= GenreType.ROCK;
                break;
            case 2:
                genreType= GenreType.POP;
                break;
            case 3:
                genreType= GenreType.TRAP;
                break;
            case 4:
                genreType= GenreType.HOUSE;
                break;
            default:
                break;
        }
        return genreType;
    }

    /**
     * A method that collect song (Audio) information.
     * @return message: String. The data compiled of the audio.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString()+"\n"+
        album+"\n"+
        price+"\n"+
        numSold+"\n"+
        getGenreType();
        return message;
    }

    //Getters and setters


    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumSold() {
        return numSold;
    }

    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }


    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }

}
