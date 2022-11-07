package model;

public enum Ads {
    //Enumered constants
    COCACOLA,
    NIKE,
    MYMS;
    //Methods
    /**
     * A constant list to enable the access of the type ads
    */
    public static final String LIST_OF_ADS = "\n"+
            "1. COCACOLA.\n" +
            "2. NIKE\n" +
            "3. M&MS";
    //Getters and Setters
    public Ads getCocacola(){
        return COCACOLA;
    }

    public Ads getNike(){
        return NIKE;
    }

    public Ads getMyms(){
        return MYMS;
    }



}
