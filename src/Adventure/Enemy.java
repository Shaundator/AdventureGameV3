package Adventure;

public class Enemy {
    private final String name;
    private final String nameID;
    private String description;
    private int health;
    private Items weapon;

    public Enemy(String name, String nameID, String description, int health, Items weapon){
        this.name=name;
        this.nameID=nameID;
        this.description=description;
        this.health=health;
        this.weapon=weapon;
    }


    //Get&Set
    public String getName() {
        return name;
    }
    public String getNameID() {
        return nameID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public Items getWeapon(){
        return weapon;
    }
    public void setWeapon(Items weapon) {
        this.weapon = weapon;
    }
}
