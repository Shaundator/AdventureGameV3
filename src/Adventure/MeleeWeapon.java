package Adventure;

public class MeleeWeapon extends Weapon {

    private final int ammo = 1;

    public MeleeWeapon(String name, String nameID, int weight, int damage){
        super(name, nameID, weight, damage);
    }

    @Override
    public boolean checkValid() {
        return true;
    }

    @Override
    public void useWeapon() {
    }
    @Override
    public String useItem(Player player) {
        return null;
    }
    @Override
    public int consumeFood() {
        return 0;
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
