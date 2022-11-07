package model;

import java.util.Calendar;

public class User{
    //atributes
    private String nickname;
    private String cc;
    private Calendar iniDate;
    //Relations
    
    //methods
    /**
     * Constructor class's method User
     * @param nickname
     * @param cc
     * @param iniDate
     */
    public User(String nickname, String cc, Calendar iniDate){
        this.nickname=nickname;
        this.cc=cc;
        this.iniDate= iniDate;
    }
    /**
     * A method that collect user information.
     * @return message: String. The data compiled of the user.
     */
    @Override
    public String toString(){
        String message="";
        message=nickname+"\n"+
        cc+"\n"+
        iniDate.getTime();
        return message;
    }

    //Getters and Setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }


    public Calendar getIniDate() {
        return iniDate;
    }

    public void setIniDate(Calendar iniDate) {
        this.iniDate = iniDate;
    }

}