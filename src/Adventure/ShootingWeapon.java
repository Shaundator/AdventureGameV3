package Adventure;

public class ShootingWeapon extends Weapon{
    private final int fullAmmo;
    private boolean usable = true;
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
        if(!usable){
            return "this weapon is empty, it is of no use to you";
        }
        ammo--;
        if(ammo == 0){
            super.setDamage(0);
            usable=false;
            return "you shoot your last ammo...";
        }
        return "you shoot your weapon! Ammo: " + ammo + "/" + fullAmmo;
    }

    @Override
    public boolean usable() {
        return usable;
    }

    public String ammo(){
        if(!usable){
            return "This Weapon is Empty";
        } else {
            return ammo + "/" + fullAmmo;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Shooting Weapon" +
                "\nAmmo: " + ammo();
    }
}
