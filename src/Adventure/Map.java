package Adventure;

public class Map {
    public Map(){
    }

    public void createWorld(){
        createMap();
        putItems();
    }
    public Room getStartRoom(){
        return room1;
    }

    //Items:
    private final Item item1 = new Item("Item 1","item1",5);
    private final Item item2 = new Item("Item 2","item2",5);
    private final Item item3 = new Item("Item 3","item3",5);
    //Rooms:
    //  1 = 2 = 3 = 10
    //  |   X   |
    //  4 X 5 X 6
    //  |   |   |
    //  7 = 8 = 9
    private final Room room1 = new Room("room1", "this is room 1");
    private final Room room2 = new Room("room2", "this is room 2");
    private final Room room3 = new Room("room3", "this is room 3");
    private final Room room4 = new Room("room4", "this is room 4");
    private final Room room5 = new Room("room5", "this is room 5");
    private final Room room6 = new Room("room6", "this is room 6");
    private final Room room7 = new Room("room7", "this is room 7");
    private final Room room8 = new Room("room8", "this is room 8");
    private final Room room9 = new Room("room9", "this is room 9");
    //WorldBuilding
    private void createMap(){
        room1.setEast(room2);
        room2.setEast(room3);
        room1.setSouth(room4);
        room3.setSouth(room6);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);
    }
    private void putItems(){
        room1.addItem(item1);
        room1.addItem(item1);
        room1.addItem(item3);
        room2.addItem(item2);
    }

}
