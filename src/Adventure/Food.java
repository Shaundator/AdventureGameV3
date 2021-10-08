package Adventure;

public class Food extends Item {
    private int healthPoints;

    public Food(String name, String nameID, int weight, int healthPoints){
        super(name, nameID, weight);
        this.healthPoints=healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
