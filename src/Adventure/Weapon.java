package Adventure;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight);
        this.damage=damage;
    }

}
