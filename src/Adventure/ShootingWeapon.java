package Adventure;

public class ShootingWeapon extends Weapon{
    private final int fullAmmo;
    private int ammo;

    public ShootingWeapon(String name, String nameID, int weight, int damage, int ammo){
        super(name, nameID, weight, damage);
        this.ammo=ammo;
        fullAmmo=ammo;
    }

    @Override
    public int getDamage() {
        shootWeapon();
        return super.getDamage();
    }

    private void shootWeapon(){
        ammo--;
    }
    @Override
    public String toString() {
        return super.toString() + "Shooting Weapon" +
                "\nAmmo: " + ammo + "/" + fullAmmo;
    }
}
