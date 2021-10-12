package Adventure;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private int health;
    private int currentHealth;
    private Items currentWeapon;
    private final ArrayList<Items> inventory = new ArrayList<>();

    public Player(String name, int health){
        this.name=name;
        this.health=health;
        currentHealth=health;
    }

    //General
    public void takeItem(Items item){
        inventory.add(item);
        currentRoom.removeItem(item);
    }
    public void dropItem(Items item){
        inventory.remove(item);
        currentRoom.addItem(item);
    }
    public void equipWeapon(Items item){
        if(currentWeapon==null) {
            setCurrentWeapon(item);
            inventory.remove(item);
        } else {
            inventory.add(currentWeapon);
            currentWeapon=item;
            destroyItem(currentWeapon);
        }
    }
    public void destroyItem(Items item){
        inventory.remove(item);
    }
    public Items findItem(String item){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getNameID().equals(item)){
                return inventory.get(i);
            }
        }
        return null;
    }
    public void addHealth(int health){
        this.health+=health;
    }

    //Battle
    public void attack(Enemy enemy) {
        int attackResult = enemy.getHealth() - ((Weapon) currentWeapon).getDamage();
        enemy.setHealth(attackResult);
    }
    public void takeDamage(Enemy enemy){
        int attackResult = currentHealth - ((Weapon) enemy.getWeapon()).getDamage();
        setCurrentHealth(attackResult);
    }

    //Food
    public void eatFood(Items item){
        currentHealth += (((Food) item).getHealthPoints());
        if(currentHealth>health){
            currentHealth=health;
        }
    }

    //Movement
    public void moveRoom(Room nextRoom){
        currentRoom=nextRoom;
    }
    public boolean goNorth(){
        if(currentRoom.getNorth()!=null){
            moveRoom(currentRoom.getNorth());
            return true;
        }
        else{
            return false;
        }
    }
    public boolean goEast(){
        if(currentRoom.getEast()!=null){
            moveRoom(currentRoom.getEast());
            return true;
        }
        else{
            return false;
        }
    }
    public boolean goSouth(){
        if(currentRoom.getSouth()!=null){
            moveRoom(currentRoom.getSouth());
            return true;
        }
        else{
            return false;
        }
    }
    public boolean goWest(){
        if(currentRoom.getWest()!=null){
            moveRoom(currentRoom.getWest());
            return true;
        }
        else {
            return false;
        }
    }

    //Get&Set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Room room){
        this.currentRoom=room;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public Items getCurrentWeapon() {
        return currentWeapon;
    }
    public void setCurrentWeapon(Items currentWeapon){
        this.currentWeapon=currentWeapon;
    }
    public ArrayList<Items> getInventory(){
        return inventory;
    }
}
