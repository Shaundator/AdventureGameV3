package Adventure;

public abstract class Weapon extends Item {
    private final int damage;

    public Weapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight);
        this.damage=damage;
    }

    public abstract boolean weaponCheck();

    public int getDamage(){
        return damage;
    }

}
