package Adventure;

public class ShootingWeapon extends Weapon{
    private int ammo;

    public ShootingWeapon(String name, String nameID, int weight, int damage, int ammo){
        super(name, nameID, weight, damage);
        this.ammo=ammo;
    }
    public int getAmmo() {
        return ammo;
    }


    @Override
    public boolean checkValid() {
        if(ammo<=0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void useWeapon() {
        ammo--;
    }
    @Override
    public int consumeFood() {
        return 0;
    }

    @Override
    public String useItem(Player player) {
        return null;
    }
    @Override
    public int getDamage() {
        return super.getDamage();
    }
    pub
}
