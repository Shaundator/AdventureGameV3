package Adventure;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Items> inventory = new ArrayList<>();
    private int health;
    private int currentHealth;
    private Weapon currentWeapon;

    public Player(String name, int health){
        this.name=name;
        this.health=health;
        currentHealth=health;
    }

    public void takeItem(Items item){
        inventory.add(item);
        currentRoom.removeItem(item);
    }
    public void dropItem(Items item){
        inventory.remove(item);
        currentRoom.addItem(item);
    }
    public void equipWeapon(Weapon item){
        if(currentWeapon==null) {
            currentWeapon = item;
            inventory.remove(item);
        } else {
            inventory.add(currentWeapon);
            currentWeapon=item;
        }
    }
    public void destroyItem(Items item){
        inventory.remove(item);
    }

    public Items getCurrentWeapon() {
        return currentWeapon;
    }

    public ArrayList<Items> getInventory(){
        return inventory;
    }
    public Items findItem(String item){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getNameID().equals(item)){
                return inventory.get(i);
            }
        }
        return null;
    }

    public int getHealth(){
        return health;
    }
    public void attack(Enemy enemy){
        currentWeapon.
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
    public boolean eatItem(Items item){
        return item.foodCheck();
    }
    public void eatFood(Items item){
        currentHealth += item.consumeFood();
        if(currentHealth>health){
            currentHealth=health;
        }
    }

    public void setCurrentRoom(Room room){
        this.currentRoom=room;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

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
}
