package Adventure;

public class Item extends Items {

    public Item(String name, String nameID, int weight) {
        super(name, nameID, weight);
    }

    @Override
    public int consumeFood() {
        return 0;
    }





    @Override
    public boolean foodCheck() {
        return false;
    }
    @Override
    public boolean weaponCheck() {
        return false;
    }
}
