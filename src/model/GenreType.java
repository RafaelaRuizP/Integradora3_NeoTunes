package model;

public enum GenreType {
    //Enumered constants
    ROCK,
    POP,
    TRAP,
    HOUSE;
    //Getters and setters
    public GenreType getROCK(){
        return ROCK;
    }
    public GenreType getPOP(){
        return POP;
    }
    public GenreType getTRAP(){
        return TRAP;
    }
    public GenreType getHOUSE(){
        return HOUSE;
    }
    /**
     * A constant list to enable the access of song genres
    */
    public static final String LIST_OF_GENRE = "\n"+
            "1. ROCK.\n" +
            "2. POP\n" +
            "3. TRAP\n" +
            "4. HOUSE";
}
