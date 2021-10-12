package Adventure;

public abstract class Items {
    private final String name;
    private final String nameID;
    private final int weight;

    public Items(String name, String nameID, int weight){
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

    public String toString(){
        return name + "(" + nameID + "), Weight: " + weight + ", Type: ";
    }
}