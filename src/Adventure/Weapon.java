package Adventure;

public abstract class Weapon extends Items {
    private int damage;

    public Weapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight);
        this.damage=damage;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public abstract String use();
    public abstract boolean usable();
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage=damage;
    }

    @Override
    public String toString() {
        return super.toString() + "Weapon\nDamage: " + damage + ", Type: ";
    }
}
