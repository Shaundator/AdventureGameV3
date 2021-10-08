package Adventure;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<Item> roomItems = new ArrayList<>();

    public Room(String name, String description){
        this.name=name;
        this.description=description;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void addItem(Item item){
        roomItems.add(item);
    }
    public void removeItem(Item item){
        roomItems.remove(item);
    }
    public Item findItem(String item){
        for(int i = 0; i < roomItems.size(); i++){
            if(roomItems.get(i).getNameID().equals(item)){
                return roomItems.get(i);
            }
        }
        return null;
    }
    public ArrayList<Item> getRoomItems(){
        return roomItems;
    }

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
