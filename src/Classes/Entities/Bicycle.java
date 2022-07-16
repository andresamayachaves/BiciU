package Classes.Entities;

import Enums.BikeColor;
import Enums.BikeType;

public class Bicycle {
    // Attributes
    private int BIC_num; // BIC numeric part
    private BikeColor color; //enum
    private String BIC; // Bicycle Identifier Code

    private BikeType type;

    //Constructor
    public Bicycle(int BIC_num, BikeColor color, String BIC, BikeType type) {
        this.BIC_num = BIC_num;
        this.color = color;
        this.BIC = BIC;
        this.type = type;
    }


    // Getters
    public int getBIC_num () {
        return BIC_num;
    }
    public BikeColor getColor () {
        return color;
    }
    public String getBIC () {
        return BIC;
    }
    public BikeType getType () {
        return type;
    }

    //Setters
    public void setBIC_num ( int BIC_num){
        this.BIC_num = BIC_num;
    }
    public void setColor (BikeColor color){
        this.color = color;
    }
    public void setBIC (String BIC){
        this.BIC = BIC;
    }
    public void setType (BikeType type){
        this.type = type;
    }
}