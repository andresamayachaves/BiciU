package Classes;

public class Bicycle {
    // Attributes
    private int BIC_num = new int;
    private Color color = new Color(); //enum
    private String BIC = 'BIC-' + 'BIC_num'';
    private Type type = new Type();

    //Constructor
    public Bicycle(int BIC_num, Color color, String BIC) {
        this.BIC_num = BIC_num;
        this.color = color;
        this.BIC = BIC;
    }
        // Getters

    public int getBIC_num () {
        return BIC_num;
    }
    public Color getColor () {
        return color;
    }
    public String getBIC () {
        return BIC;
    }
    public Type getType () {
        return type;
    }

    //Setters
    public void setBIC_num ( int BIC_num){
        this.BIC_num = BIC_num;
    }
    public void setColor (Color color){
        this.color = color;
    }
    public void setBIC (String BIC){
        this.BIC = BIC;
    }
    public void setType (Type type){
        this.type = type;
    }
}