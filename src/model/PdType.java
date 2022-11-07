package model;

public enum PdType {
    //Enumered constants
        POLITICISM,
        ENTERTEINMENT,
        VIDEOGAMES,
        FASHION;
    //Getters and setters
    public PdType getPOLITICISM(){
        return POLITICISM;
    }
    public PdType getENTERTEINMENT(){
        return ENTERTEINMENT;
    }
    public PdType getVIDEOGAMES(){
        return VIDEOGAMES;
    }
    public PdType getFASHION(){
        return FASHION;
    }
    /**
     * A constant list to enable the access of podcast categories
    */
    public static final String LIST_OF_CATEGORY = "\n"+
            "1. POLITICISM.\n" +
            "2. ENTERTEINMENT\n" +
            "3. VIDEOGAMES\n" +
            "4. FASHION";
}

