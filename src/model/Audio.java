package model;

public class Audio {
    //atributes
    private String name;
    private String url;
    private double length;
    private int numRep;
    //methods
    /**
     * Constructor class's method Audio
     * @param name
     * @param url
     * @param length
     * @param numRep
     */
    public Audio(String name, String url, double length, int numRep){
        this.name=name;
        this.url=url;
        this.length=length;
        this.numRep=numRep;
    }

    /**
     * A method that collect podcast (Audio) information.
     * @return message: String. The data compiled of the audio.
     */
    @Override
    public String toString(){
        String message="";
        message = name+"\n"+
        url+"\n"+
        length+"\n"+
        numRep;
        return message;
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public int getNumRep() {
        return numRep;
    }

    public void setNumRep(int numRep) {
        this.numRep = numRep;
    }

}
