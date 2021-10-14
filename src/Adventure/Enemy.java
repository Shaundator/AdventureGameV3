package Adventure;

public class Enemy {
    private final String name;
    private final String nameID;
    private final String description;
    private String enemyAttackLine;
    private final String enemyFleeLine;
    private final String enemyDeathLine;
    private final int maxHealth;
    private int health;
    private final Items weapon;
    private final Items loot;

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
    public String getEnemyAttackLine() {
        return enemyAttackLine;
    }
    public void setEnemyAttackLine(String newLine){
        enemyAttackLine=newLine;
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
    public Items getWeapon(){
        return weapon;
    }
    public Items getLoot() {
        return loot;
    }

    @Override
    public String toString() {
        return name + "(" + nameID + ")" +
                "\n'" + description + "'";
    }
}
