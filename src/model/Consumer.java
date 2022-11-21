package model;

import java.util.*;

public class Consumer extends User{
    //atributes
    private double timeReached;
    private String contentFav;
    private String producerFav;
    //methods
    /**
     * Constructor class's method Consumer(User)
     * @param nickname
     * @param cc
     * @param iniDate
     */
    public Consumer(String nickname, String cc, Calendar iniDate){
        super(nickname, cc, iniDate);
        timeReached=0;
        contentFav=null;
        producerFav=null;
    }

    

    /**
     * A method that collect consumer user information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=super.toString();
        return message;
    }

    //Getters and setters
    public double getTimeReached() {
        return timeReached;
    }

    public void setTimeReached(double timeReached) {
        this.timeReached = timeReached;
    }

    
    public String getContentFav() {
        return contentFav;
    }

    public void setContentFav(String contentFav) {
        this.contentFav = contentFav;
    }

    
    public String getProducerFav() {
        return producerFav;
    }

    public void setProducerFav(String producerFav) {
        this.producerFav = producerFav;
    }

}
