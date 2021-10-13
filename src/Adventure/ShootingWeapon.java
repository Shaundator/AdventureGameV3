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
        return super.getDamage();
    }

    @Override
    public String use() {
        ammo--;
        if(ammo <= 0){
            super.setDamage(0);
            return "you shoot your last ammo...";
        }
        return "you shoot your weapon, Ammo: " + ammo + "/" + fullAmmo;
    }

    @Override
    public String toString() {
        return super.toString() + "Shooting Weapon" +
                "\nAmmo: " + ammo + "/" + fullAmmo;
    }
}
