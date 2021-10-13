package Adventure;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight, damage);
    }

    @Override
    public String use() {
        return "you use a melee weapon";
    }

    @Override
    public String toString() {
        return super.toString() + "Melee";
    }
}
