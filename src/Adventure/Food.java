package Adventure;

public class Food extends Items {
    private final int healthPoints;
    private int bonusDamage = 0;

    public Food(String name, String nameID, int weight, int healthPoints){
        super(name, nameID, weight);
        this.healthPoints=healthPoints;
    }
    public Food(String name, String nameID, int weight, int healthPoints,int bonusDamage){
        super(name, nameID, weight);
        this.healthPoints=healthPoints;
        this.bonusDamage=bonusDamage;
    }


    @Override
    public void useWeapon() {
    }
    @Override
    public boolean checkValid() {
        return false;
    }
    @Override
    public String useItem(Game game) {
        return "null";
    }
    @Override
    public int consumeFood() {
        return healthPoints;
    }
    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public boolean useCheck() {
        return false;
    }
    @Override
    public boolean weaponCheck() {
        return false;
    }
    @Override
    public boolean foodCheck() {
        return true;
    }

    @Override
    public String toString() {
        return "Food{" +
                "healthPoints=" + healthPoints +
                ", bonusDamage=" + bonusDamage +
                '}';
    }
}