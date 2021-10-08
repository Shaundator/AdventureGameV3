package Adventure;

public class Map {
    public Map(){
    }

    public void createWorld(){
        createMap();
        putItems();
        putEnemies();
    }
    public Room getStartRoom(){
        return room1;
    }
    public Items getStartItems(){
        return hands;
    }

    //Items:
    private final Items item1 = new Item("Item 1","item1",5);
    private final Items item2 = new Item("Item 2","item2",5);
    private final Items item3 = new Item("Item 3","item3",5);
    //Food:
    private final Items food1 = new Food("Food 1","food1",2,15);
    private final Items food2 = new Food("Food 2","food2",4,-15);
    //Weapons:
    private final Items hands = new MeleeWeapon("Your hands", "hands",0,100,1);
    private final Items sword = new MeleeWeapon("A Sharp Sword","sword",5,25,10);
    private final Items gun = new ShootingWeapon("A Gun","gun",2,30,12);
    private final Items stick = new MeleeWeapon("A stick","stick",1,5,1);
    //Enemies
    private final Enemy slime = new Enemy("A Slime", "slime", "A green gooey Slime", 250, stick);
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
        room1.addItem(food1);
        room1.addItem(food1);
        room1.addItem(food1);
        room1.addItem(food2);
        room1.addItem(food2);
        room1.addItem(food2);
        room1.addItem(sword);
        room1.addItem(gun);
        room1.addItem(gun);
    }
    private void putEnemies(){
        room1.addEnemy(slime);
    }

}
