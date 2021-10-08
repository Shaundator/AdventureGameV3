package Adventure;

public class MeleeWeapon extends Weapon {
    int strength;
    public MeleeWeapon(String name, String nameID, int weight, int damage,int strength){
        super(name, nameID, weight, damage);
        this.strength=strength;
    }

    @Override
    public boolean foodCheck() {
        return false;
    }

    @Override
    public boolean weaponCheck() {
        return true;
    }
}
