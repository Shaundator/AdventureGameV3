package Adventure;

public class Map {
    public Map(){
    }

    public void createWorld(){
        createMap();
        putItems();
        putEnemies();
        putBosses();
    }
    public Room getStartRoom(){
        return subway_station;
    }
    public void defeatAunt(){
        familiar_park.setEast(home);
    }

    //Items:
    Items rock = new Item("Magnificent Rock","rock",1,"A rock? Maybe if u use it on someone it will actually do something");
    Items vitamin = new Item("Vitamin Drink","vitamin",2,"Adds 100 health to total health");
    Items anti_officer = new Item("Justice","justice",10,"Become one with justice");

    //Weapons:
    Items stick = new MeleeWeapon("Wooden stick","stick",1,5);
    Items baseball_bat = new MeleeWeapon("Baseball Bat","bat",5,15);
    Items knife = new MeleeWeapon("Metal knife", "knife",2,25);
    Items machete = new MeleeWeapon("Machete","machete",5,50);
    Items gun = new ShootingWeapon("Gun","gun",10,100,5);

    //Foods:
    Items burger = new Food("Hamburger","burger",2,25);
    Items badBurger = new Food("Bad Hamburger","badburger",2,-25);
    Items health_potion = new Food("Health Potion", "healthpotion",2,50);

    //BossWeapons:
    Items bully_weapon = new MeleeWeapon("Raw insults","insult",0,25);
    private final Items drug_dealer_weapon = new MeleeWeapon("Syringe","syringe",0,45);
    private final Items police_officer_weapon = new MeleeWeapon("Police Baton","baton",0,70);
    private final Items aunt_weapon = new MeleeWeapon("Scolding","scolding",0,145);
    //BossLoot:
    Items bully_loot = new Item("Bully Loot","bullyloot",5,"Trophy for defeating the bully");
    Items drug_dealer_loot = anti_officer;
    Items police_officer_loot = new Item("Police Officer Loot","officerloot",5,"Trophy for defeating the drug dealer");
    Items aunt_loot = new Item("Aunt Loot","auntloot",5,"Trophy for defeating your Aunt");
    //Enemy Loot:
    Items pedestrian_loot = new Item("Medicine","meds",1,"Restores 50 health");
    Items pedestrian_weapon = new MeleeWeapon("Annoyance","annoyance",0,15);

    //Enemies:
    Enemy violent_pedestrian = new Enemy("Violent pedestrian","pedestrian", "Dangerous human beings, bringer of violence and annoying situations","Ehm, excuse me i walked here","Have a LOVELY evening","*sigh* back in my days...",100,pedestrian_weapon,pedestrian_loot);
    Enemy invincible_slime = new Enemy("Invincible Slime","invislime","can't die can't kill just there to be annoying","Reee","REebye","impossible",100000,new MeleeWeapon("invincible hand","invihand",0,0),new Item("nothing","nothingness",0,"nothing"));
    //Boss:
    Enemy alpha_bully = new Enemy("Alpha Bully","alphabully","The final bully, feared by many and served by twice as many","What's up nerd","Yeah go cry to your mommy","How!? A mere nerd!",250, bully_weapon, bully_loot);
    Enemy drug_dealer = new Enemy("Drug Dealer","drugdealer","Dealer of Drugs, bringer of powders, half man, half stimulants","Punch punch punch, haha", "Where did you go? are you scared?", "Yuckers", 500, drug_dealer_weapon, drug_dealer_loot);
    Enemy police_officer = new Enemy("Local Neighbourhood Police Officer","officer","Bringer of justice, he is the judge, jury and the executioner","JUSTICE!","Justice prevails!","Impossible, how could justice lose!?",750,police_officer_weapon,police_officer_loot);
    Enemy aunt = new Enemy("Auntie","aunt","Scolder of children, the inside man(woman) of every mother, nothing escapes her gaze","The audacity of kids these days...","Wait till your mother finds out about this",":0",1500,aunt_weapon,aunt_loot);


    //Rooms:
    //  1 = 2 = 3 = 10
    //  |   X   |
    //  4 X 5 X 6
    //  |   |   |
    //  7 = 8 = 9
    private final Room subway_station = new Room("Subway Station", "The train is loud, and so are the people walking around");
    private final Room train = new Room("Train", "The train travels fast, yet it seems like this ride could take an eternity");
    private final Room familiar_park = new Room("Familiar Park", "The place reminds you of something, but you can't put your finger on it");
    private final Room police_station = new Room("Police Station", "You should avoid this place if you are up to mischief");
    private final Room prison = new Room("Prison", "The prison stands at show for all, with its many occupants to display like it was a zoo");
    private final Room school = new Room("School", "The place that could be summed up as progress and boredom, depending on who you ask of course");
    private final Room border = new Room("Border", "What countries lies beyond the border? No one seems to know or ask");
    private final Room crime_area = new Room("Cocaine Street", "A place publicly known for it's illegalities, a place of adventure and mischief");
    private final Room bench_by_a_lake = new Room("Bench by a lake", "The best place to take a sleeper when the road home is mystery");
    Room home = new Room("Home", "Your home, you can barely recognise it");
    //WorldBuilding
    private void createMap(){
        subway_station.setEast(train);
        train.setEast(familiar_park);
        subway_station.setSouth(police_station);
        familiar_park.setSouth(school);
        police_station.setSouth(border);
        prison.setSouth(crime_area);
        school.setSouth(bench_by_a_lake);
        border.setEast(crime_area);
        crime_area.setEast(bench_by_a_lake);
    }
    private void putItems(){
        subway_station.addItem(stick);
        subway_station.addItem(baseball_bat);
        subway_station.addItem(knife);
        subway_station.addItem(machete);
        subway_station.addItem(gun);
        subway_station.addItem(vitamin);
        subway_station.addItem(rock);

        border.addItem(burger);
        border.addItem(badBurger);
        border.addItem(burger);
        border.addItem(badBurger);
        border.addItem(burger);
        border.addItem(badBurger);

        train.addItem(health_potion);
        train.addItem(health_potion);
        train.addItem(health_potion);
        train.addItem(health_potion);
        train.addItem(health_potion);
    }
    private void putEnemies(){
        subway_station.addEnemy(violent_pedestrian);
        subway_station.addEnemy(violent_pedestrian);
        subway_station.addEnemy(violent_pedestrian);
        train.addEnemy(invincible_slime);
    }
    private void putBosses(){
        school.addEnemy(alpha_bully);
        prison.addEnemy(drug_dealer);
        police_station.addEnemy(police_officer);
        familiar_park.addEnemy(aunt);
    }

}
