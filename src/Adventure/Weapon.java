package Adventure;

public abstract class Weapon extends Items {
    private final int damage;

    public Weapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight);
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + "Weapon\nDamage: " + damage + ", Type: ";
    }
}
