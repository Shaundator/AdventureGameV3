package Adventure;

public class ShootingWeapon extends Weapon{
    private int ammo;

    public ShootingWeapon(String name, String nameID, int weight, int damage, int ammo){
        super(name, nameID, weight, damage);
        this.ammo=ammo;
    }

    @Override
    public void useItem() {
        ammo--;
    }
    @Override
    public int getDamage() {
        return super.getDamage();
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
