package Adventure;

public class Item extends Items {
    String use;

    public Item(String name, String nameID, int weight, String use) {
        super(name, nameID, weight);
        this.use=use;
    }

    public String useItem(Game game){
        return "uses";
    }

    @Override
    public String toString() {
        return "Item";
    }
}
