package Adventure;

import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<Items> roomItems = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Room(String name, String description){
        this.name=name;
        this.description=description;
    }

    public Items findItem(String item){
        for(int i = 0; i < roomItems.size(); i++){
            if(roomItems.get(i).getNameID().equals(item)){
                return roomItems.get(i);
            }
        }
        return null;
    }
    public void enemyDeath(Enemy deadEnemy){
        roomItems.add(deadEnemy.getLoot());
        int enemy = enemies.indexOf(deadEnemy);
        enemies.get(enemy).resetHealth();
        enemies.remove(deadEnemy);
    }

    //Get&Set
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void addItem(Items item){
        roomItems.add(item);
    }
    public void removeItem(Items item){
        roomItems.remove(item);
    }
    public ArrayList<Items> getRoomItems(){
        return roomItems;
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public Enemy getEnemy(String enemy){
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getNameID().equals(enemy)||enemies.get(i).getName().toLowerCase().equals(enemy)){
                return enemies.get(i);
            }
        }
        return null;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    //Directions
    public Room getNorth(){
        return north;
    }
    public Room getEast(){
        return east;
    }
    public Room getSouth(){
        return south;
    }
    public Room getWest(){
        return west;
    }
    public void setNorth(Room north){
        if(this.north==north){
            return;
        }
        if(north!=null) {
            this.north = north;
            north.setSouth(this);
        }
    }
    public void setEast(Room east){
        if(this.east==east){
            return;
        }
        if(east!=null) {
            this.east = east;
            east.setWest(this);
        }
    }
    public void setSouth(Room south){
        if(this.south==south){
            return;
        }
        if(south!=null) {
            this.south = south;
            south.setNorth(this);
        }
    }
    public void setWest(Room west){
        if(this.west==west){
            return;
        }
        if(west!=null) {
            this.west = west;
            west.setEast(this);
        }
    }

}
