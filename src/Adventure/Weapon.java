package Adventure;

public abstract class Weapon extends Items {
    private final int damage;

    public Weapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight);
        this.damage=damage;
    }

    public abstract void useWeapon();
    public abstract boolean checkValid();
    @Override
    public boolean useCheck() {
        return false;
    }
    @Override
    public boolean weaponCheck() {
        return true;
    }
    @Override
    public boolean foodCheck() {
        return false;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                '}';
    }
}
