package model;

import java.util.*;

public class Producer extends User{
    //atributes
    private String name;
    private String url;
    private int numVisualization;
    //methods
    /**
     * Constructor class's method Producer (User)
     * @param nickname
     * @param cc
     * @param iniDate
     * @param name
     * @param url
     */
    public Producer(String nickname, String cc, Calendar iniDate, String name, String url){
        super(nickname, cc, iniDate);
        this.name=name;
        this.url=url;
        numVisualization=0;
    }
    /**
     * A method that collect producer user information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString()+"\n"+
        name+"\n"+
        url+"\n"+
        numVisualization;
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

    public int getNumVisualization() {
        return numVisualization;
    }

    public void setNumVisualization(int numVisualization) {
        this.numVisualization = numVisualization;
    }

}
