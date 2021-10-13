package Adventure;

public class Enemy {
    private final String name;
    private final String nameID;
    private final String description;
    private final String enemyAttackLine;
    private final String enemyFleeLine;
    private final String enemyDeathLine;
    private int health;
    private int maxHealth;
    private Items weapon;
    private Items loot;

    public Enemy(String name, String nameID, String description, String enemyAttackLine,String enemyFleeLine, String enemyDeathLine, int health, Items weapon, Items loot){
        this.name=name;
        this.nameID=nameID;
        this.description=description;
        this.enemyAttackLine=enemyAttackLine;
        this.enemyFleeLine=enemyFleeLine;
        this.enemyDeathLine=enemyDeathLine;
        this.health=health;
        this.weapon=weapon;
        this.loot=loot;
        maxHealth=health;
    }

    public void addHealth(int health){
        this.health+=health;
    }
    public void resetHealth(){
        health=maxHealth;
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
    public String getEnemyAttackLine() {
        return enemyAttackLine;
    }
    public String getEnemyFleeLine() {
        return enemyFleeLine;
    }
    public String getEnemyDeathLine() {
        return enemyDeathLine;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Items getWeapon(){
        return weapon;
    }
    public void setWeapon(Items weapon) {
        this.weapon = weapon;
    }
    public Items getLoot() {
        return loot;
    }
    public void setLoot(Items loot) {
        this.loot = loot;
    }

    @Override
    public String toString() {
        return name + "(" + nameID + ")" +
                "\n'" + description + "'";
    }
}
