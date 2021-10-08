package Adventure;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight, damage);
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
