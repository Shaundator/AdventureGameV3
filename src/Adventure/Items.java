package Adventure;

public abstract class Items {
    private String name;
    private String nameID;
    private int weight;

    public Items(String name, String nameID, int weight){
        this.name=name;
        this.nameID=nameID;
        this.weight=weight;
    }
    public abstract String useItem(Game game);
    public abstract boolean checkValid();
    public abstract void useWeapon();
    public abstract boolean useCheck();
    public abstract boolean foodCheck();
    public abstract boolean weaponCheck();
    public abstract int consumeFood();
    public abstract int getDamage();

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
        return "Item: " + nameID + "(" + nameID + ")" +
                "\nWeight: " + weight + "\n";
    }
}