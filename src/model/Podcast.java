package model;

public class Podcast extends Audio{
    //atributes
    private String desc;
    //relations
    private PdType pdType;
    //methods
    /**
     * Constructor class's method Podcast (Audio)
     * @param name
     * @param url
     * @param length
     * @param numRep
     * @param desc
     * @param category
     */
    public Podcast(String name, String url, double length, int numRep, String desc, int category){
        super(name, url, length, numRep);
        this.desc=desc;
        pdType=categoryChoose(category);
    }

    /**
     * This method put a pdType to a given num category(related to PdType).
     * @param category: A number that is related to obtain a category of podcast.
     * @return pdType:PdType. The constant obtained from summoning enum class PdType.
     */ 
    public PdType categoryChoose(int category){
        switch (category) {
            case 1:
                pdType= PdType.POLITICISM;
                break;
            case 2:
                pdType= PdType.ENTERTEINMENT;
                break;
            case 3:
                pdType= PdType.VIDEOGAMES;
                break;
            case 4:
                pdType= PdType.FASHION;
                break;
            default:
                break;
        }
        return pdType;
    }

    public String toString(){
        String message="";
        message=super.toString()+"\n"+
        desc+"\n"+
        getPdType();
        return message;
    }

    //Getters and setters
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public PdType getPdType() {
        return pdType;
    }

    public void setPdType(PdType pdType) {
        this.pdType = pdType;
    }

}
