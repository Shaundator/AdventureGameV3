package Adventure;

public class Food extends Items {
    private final int healthPoints;

    public Food(String name, String nameID, int weight, int healthPoints){
        super(name, nameID, weight);
        this.healthPoints=healthPoints;
    }

    @Override
    public int consumeFood() {
        return healthPoints;
    }
    @Override
    public boolean weaponCheck() {
        return false;
    }

    @Override
    public boolean foodCheck() {
        return true;
    }
}
