package Adventure;

public class Enemy {
    private String name;
    private String nameID;
    private String description;
    private int health;
    private Items weapon;

    public Enemy(String name,String nameID, String description, int health, Items weapon){
        this.name=name;
        this.nameID=nameID;
        this.description=description;
        this.health=health;
        this.weapon=weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public Items getWeapon(){
        return weapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
