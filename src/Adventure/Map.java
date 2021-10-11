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
    public Items getStartItem(){
        return hands;
    }
    public void defeatAunt(){
        room3.setEast(room10);
    }

    //Items:
    private final Items item1 = new Item("Magnificent Rock","rock",5,"Nothing happens");
    private final Items item2 = new Item("ID Card","idcard",5,"You are now a legitimate member of the society");
    private final Items item3 = new Item("Mobile Phone","phone",5,"You call someone for no reason");
    private final Items item4 = new Item("Home Keys","key",5,"You go home");
    private final Items mask = new Item("A Mask","mask",5,"You put on a mask and no one knows who you are");
    private final Items cocaine = new Item("Cocaine", "cocaine", 1, "You feel newfound powers surge through your body" +
            "\nYou gain 100 Health");
    //Food:
    private final Items burger = new Food("Cheese Burger","burger",5,20);
    private final Items food2 = new Food("Food 2","food2",4,-15);
    private final Items vodka = new Food("Bottle of Vodka","vodka",5,-25,50);
    private final Items badBurger = new Food("Cheese Burger","burger",4,-20);
    //Weapons:
    private final Items hands = new MeleeWeapon("Nothing", "barehanded",0,1);
    private final Items stick = new MeleeWeapon("Stick","stick",1,5);
    private final Items sword = new MeleeWeapon("Sharp Sword","sword",5,25);
    private final Items gun = new ShootingWeapon("Gun","gun",2,30,1);
    private final Items situationCard = new ShootingWeapon("Get out of sticky situation card","situationcard",10,100000,1);

    //MobWeapons:
    Items policeBaton = new MeleeWeapon("Police Stick","policestick",5,50);
    Items scolding = new MeleeWeapon("A Scolding","scolding",0,1000);
    Items emptyFlask = new MeleeWeapon("An empty beer bottle", "emptybottle",5,5);
    //Enemies
    Enemy slime = new Enemy("A Slime", "slime", "A green gooey Slime","blub blub","Blub Blub :(", 250, stick, stick);
    Enemy hooligan = new Enemy("Football Hooligan", "hooligan",
            "Watcher of football, carrier of high alcohol levels and bringer of destruction","FOOTBALL ORALE","I gotta puke",
            100,emptyFlask,vodka);
    private final Enemy druggie = new Enemy("A Druggie","druggie","Smelly and vile, carrier of addiction and bringer of money",
            "Why do you look like my mother?","Bad cocaine",100,stick,cocaine);

    //Bosses
    Enemy drugDealer = new Enemy("Your local neighbourhood drug dealer", "drugdealer",
            "Seller of rocks, bringer of stocks. A plague to society and the cousin of fun",
            "Yo bro how's it hanging u wanna fight?", "Oh no", 300, gun, mask);
    Enemy officer = new Enemy("Police Officer","officer","Upholder of the law, strong brave and furious",
            "Taste the power of justice", ":0", 1000,policeBaton,situationCard);
    Enemy aunt = new Enemy("Your aunt","aunt", "Your aunt, the guardian of the front of your home... She seems invincible",
            "Where were you last night? Does my sister know you were out?","Here, i'll trust you are telling the truth",100000,scolding,item4);
    //Rooms:
    //  1 = 2 = 3 = 10
    //  |   X   |
    //  4 X 5 X 6
    //  |   |   |
    //  7 = 8 = 9
    private final Room room1 = new Room("Subway Station", "The train is loud, and so are the people walking around");
    private final Room room2 = new Room("Train", "The train travels fast, yet it seems like this ride could take an eternity");
    private final Room room3 = new Room("Familiar Park", "The place reminds you of something, but you can't put your finger on it");
    private final Room room4 = new Room("Police Station", "You should avoid this place if you are up to mischief");
    private final Room room5 = new Room("Prison", "The prison stands at show for all, with its many occupants to display like it was a zoo");
    private final Room room6 = new Room("School", "The place that could be summed up as progress and boredom, depending on who you ask of course");
    private final Room room7 = new Room("Border", "What countries lies beyond the border? No one seems to know or ask");
    private final Room room8 = new Room("Cocaine Street", "A place publicly known for it's illegalities, a place of adventure and mischief");
    private final Room room9 = new Room("Bench by a lake", "The best place to take a sleeper when the road home is mystery");
    private final Room room10 = new Room("Home", "Your home, you can barely recognise it");
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
        room1.addItem(item3);
        room2.addItem(item2);
        room1.addItem(sword);
        room1.addItem(gun);
    }
    private void putEnemies(){
        room1.addEnemy(slime);
        room1.addEnemy(slime);
        room4.addEnemy(officer);
        room3.addEnemy(aunt);
        room8.addEnemy(druggie);
        room8.addEnemy(druggie);
        room8.addEnemy(druggie);
        room8.addEnemy(druggie);
        room8.addEnemy(druggie);
    }

}
