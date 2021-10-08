package Adventure;

public class Item {
    private String name;
    private String nameID;
    private int weight;

    public Item(String name, String nameID, int weight){
        this.name=name;
        this.nameID=nameID;
        this.weight=weight;
    }

    public String getName(){
        return name;
    }
    public String getNameID(){
        return nameID;
    }
    public int getWeight() {
        return weight;
    }
}
