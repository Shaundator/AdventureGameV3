package Adventure;

public class Food extends Items {
    private final int healthPoints;

    public Food(String name, String nameID, int weight, int healthPoints){
        super(name, nameID, weight);
        this.healthPoints=healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
        return super.toString() + "Food\n" +
                "HealthPoints: " + healthPoints;
    }
}