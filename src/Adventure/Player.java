package Adventure;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health;
    private int currentHealth;

    public Player(String name, int health){
        this.name=name;
        this.health=health;
        currentHealth=health;
    }

    public void takeItem(Item item){
        inventory.add(item);
        currentRoom.removeItem(item);
    }
    public void dropItem(Item item){
        inventory.remove(item);
        currentRoom.addItem(item);
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }
    public Item findItem(String item){
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

    public int getCurrentHealth() {
        return currentHealth;
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
