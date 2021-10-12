package Adventure;

public class Game {
    private final String userName;
    private final String gender;
    Parser parser = new Parser();
    Map map = new Map();
    Player player;
    Enemy currentEnemy;
    public Game(String userName, String gender){
        this.userName=userName;
        this.gender=gender;
    }

    public void startGame(){
        setStartParameters();
        startText();
        boolean gameOn = true;
        while(gameOn) {
            if(player.getCurrentRoom()!=map.room10){
                System.out.print("Command: ");
                String command = parser.commandMenu();
                commandScanner(command);
            } else {
                System.out.println(colorText(cyan, userName + " is finally home"));
                gameOn=false;
            }
        }
        System.out.println(colorText(cyan, "And so, our hero finally arrived home"));
    }
    public void battleFight(){
        test(player.getCurrentWeapon());
    }
    public void test(Items weapon){
        if(weapon instanceof ShootingWeapon){
            int currentAmmo = ((ShootingWeapon) weapon).getAmmo();
        }
    }

    //Menu
    public void go(String direction){
        if(direction.equals("north")){
            if (player.goNorth()){
                travel(direction);
            } else {
                travelNot(direction);
                return;
            }
        }
        if(direction.equals("east")){
            if (player.goEast()){
                travel(direction);
            } else {
                travelNot(direction);
                return;
            }
        }
        if(direction.equals("south")){
            if (player.goSouth()){
                travel(direction);
            } else {
                travelNot(direction);
                return;
            }
        }
        if(direction.equals("west")){
            if (player.goWest()){
                travel(direction);
            } else {
                travelNot(direction);
                return;
            }
        }
    }
    public void look(){
        System.out.println("\nLocation:");
        System.out.println(colorText(cyan, "This is the " + player.getCurrentRoom().getName()));
        System.out.println(colorText(cyan,player.getCurrentRoom().getDescription()));
        System.out.println(colorText(cyan, userName + " takes a look around to see if anything is laying around the " + player.getCurrentRoom().getName().toLowerCase() + ": "));
        System.out.print("Items:");
        roomItems();
        System.out.println("\nupon further inspection, " + userName + " tries to see if there are anyone " + heOrShe() + " can talk with");
        roomNPCs();
    }
    public void inventory() {
        if(player.getCurrentWeapon()!=null){
            System.out.println(userName + apostrof(userName) + " weapon: " + "\n" +
                    colorText(blue,"Weapon: " + player.getCurrentWeapon().getName()));
            System.out.println(colorText(white, "" + player.getCurrentWeapon()));
        }
        System.out.println("Inventory:");
        String inventory = "";
        if (player.getInventory().size() == 0) {
            inventory += userName + apostrof(userName) + " inventory is empty";
            System.out.println(colorText(red, inventory));
        } else {
            for (int i = 0; i < player.getInventory().size(); i++) {
                inventory += addArticleCap(player.getInventory().get(i).getName()) + "(" + player.getInventory().get(i).getNameID() + ")";
                if (i < player.getInventory().size()) {
                    inventory += "\n";
                }
            }
            System.out.println(colorText(blue, inventory));
        }
    }
    public void health(){
        System.out.println(userName + apostrof(userName) + " health: " + healthCheck());
    }
    public void attack(String enemy){
        if(player.getCurrentRoom().getEnemy(enemy)!=null){
            currentEnemy=player.getCurrentRoom().getEnemy(enemy);
            System.out.println(userName + apostrof(userName) + " foe is a " + currentEnemy.getName()+ "!");
            int turn = 0;
            boolean battleOn = true;
            while(battleOn){
                turn++;
                playerAlive();
                System.out.println(currentEnemy.getName() + apostrof( currentEnemy.getName()) + " health: " + colorText(red, "" + currentEnemy.getHealth()) + " | " +
                        userName + apostrof(userName) + " health: " + healthCheck());
                System.out.println("\nTurn " + turn);
                System.out.print("Attack, Items, Flee: ");
                String action = parser.battleMenu();

                if(action.equals("attack")){
                    System.out.println(colorText(white,userName + " attacks the " + currentEnemy.getName() + " with " + player.getCurrentWeapon().getName()));
                    System.out.println(colorText(white,"Damage Done: " + player.getCurrentWeapon().getDamage()));
                    player.attack(currentEnemy);
                    checkWeapon();
                    if(enemyAlive()) {
                        enemyAttack();
                    }
                }
                else if(action.equals("items")){
                    if(!useItemFight()) {
                        System.out.println(userName + " does nothing?");
                        System.out.println(colorText(yellow,"The " + currentEnemy.getName() + " thinks " + userName + " is up to something and stands on guard"));
                    } else {
                        enemyAttack();
                    }
                }
                else if(action.equals("flee")){
                    System.out.println(colorText(yellow,userName + " flees from the fight"));
                    battleOn=false;
                }

                if(player.getCurrentHealth()<=0){
                    System.out.println(colorText(red,userName + " dies..."));
                    System.exit(0);
                    battleOn=false;
                }
                if(currentEnemy==null){
                    return;
                }
            }
        }
        else {
            System.out.println(colorText(red,"No such enemy"));
        }
    }
    public void use(String item){
        Items tempItem = player.findItem(item);

        if(tempItem != null) {
            if(player.useItem(tempItem)) {
                System.out.println(colorText(yellow,userName + " uses the " + tempItem.getName().toLowerCase()));
                player.useUseItem(tempItem);
                System.out.println(colorText(cyan,tempItem.useItem(this)));

            } else {
                System.out.println(colorText(red, "this item cannot be used"));
            }
        } else {
            System.out.println(colorText(red, userName + apostrof(userName) + " inventory does not contain " + item));
        }
    }
    public void equip(String item){
        if(player.findItem(item)!=null){
            if(player.findItem(item).weaponCheck()){
                System.out.println(colorText(green,userName + " equips the " + player.findItem(item).getName().toLowerCase()));
                player.equipWeapon(player.findItem(item));
            } else {
                System.out.println(colorText(red,player.findItem(item).getName() + " is not a weapon"));
            }
        }
    }
    public void take(String item){
        Items tempItem = player.getCurrentRoom().findItem(item);
        if(tempItem==null){
            System.out.println(colorText(red,player.getCurrentRoom().getName() + " does not contain any " + item));
            return;
        }
        player.takeItem(tempItem);
        System.out.println(colorText(green,userName + " takes the " + tempItem.getName().toLowerCase()));
    }
    public void drop(String item){
        Items tempItem = player.findItem(item);
        if(tempItem==null){
            System.out.println(colorText(red,userName + apostrof(userName) + " inventory does not contain " + item));
            return;
        }
        player.dropItem(tempItem);
        System.out.println(colorText(green,userName + " drops the " + tempItem.getName().toLowerCase()));
    }
    public void eat(String item) {
        if (player.findItem(item) != null) {
            if (player.eatItem(player.findItem(item))){
                player.eatFood(player.findItem(item));
                System.out.println(colorText(green,userName + " eats " + addArticle(player.findItem(item)) + player.findItem(item).getName().toLowerCase()));
                player.destroyItem(player.findItem(item));
            } else {
                System.out.println(colorText(red,player.findItem(item).getName() + " cannot be eaten"));
            }
        } else {
            System.out.println(colorText(red, userName + apostrof(userName) + " inventory does not contain " + item));
        }
    }
    public void help(){
        System.out.println(colorText(white,"""
                Commands:
                Go: North, East, South, West
                Look: Inspect current location
                Attack: Attack an enemy
                Inventory: See inventory
                Use: Use an item
                Eat: Eat an item
                Equip: Equip an item
                Take: Pick up an item from current location
                Drop: Drop an item on current location
                Help: See commands
                Restart: Restart Game(Not there yet)
                Exit: Exit the Game
                """));
    }
    public void exit(){
        System.out.println(colorText(red,"A somber night, for death fell upon our hero, " + userName + apostrof(userName) + " life...\n" +
                "May " + heOrShe() + " rest in peace"));
        System.exit(0);
    }

    //SubMenus

    //go
    public void travel(String direction){
        System.out.println(colorText(cyan,userName + " travels " + direction + " and enters " + player.getCurrentRoom().getName()));
    }
    public void travelNot(String direction){
        System.out.println(colorText(red, "There is no path " + direction + " of " + player.getCurrentRoom().getName()));

    }
    //look
    public boolean roomItemsNull(){
        return player.getCurrentRoom().getRoomItems().size() == 0;
    }
    public void roomItems(){
        if(roomItemsNull()){
            System.out.println(colorText(red,"\nThere are no items in this room"));
            return;
        }
        String result = "";
        for(int i = 0; i < player.getCurrentRoom().getRoomItems().size(); i++){
            result += "\n" + addArticleCap(player.getCurrentRoom().getRoomItems().get(i).getName()) +
                    "("+player.getCurrentRoom().getRoomItems().get(i).getNameID()+")";
        }
        System.out.println(colorText(blue,result));

    }
    public void roomNPCs(){
        String enemiesInRoom = "";
        if(player.getCurrentRoom().getEnemies().size()==0) {
            System.out.println(colorText(red, "there are no one around"));
        } else {
            for(int i = 0; i < player.getCurrentRoom().getEnemies().size(); i++) {
                enemiesInRoom += player.getCurrentRoom().getEnemies().get(i).getName() +
                        "(" + player.getCurrentRoom().getEnemies().get(i).getNameID() + ")\n";
            }
            System.out.println(colorText(red,enemiesInRoom));
        }
    }
    //Use
    //attack
    public boolean enemyAlive(){
        if(currentEnemy.getHealth()<=0){
            System.out.println(colorText(yellow,currentEnemy.getName() + ": " + "'" + currentEnemy.getEnemyDeathLine() + "'"));
            System.out.println(colorText(green, userName + " is victorious!"));
            player.getCurrentRoom().enemyDeath(currentEnemy);
            System.out.println(colorText(blue,currentEnemy.getName() + " drops " + currentEnemy.getLoot().getName()));
            currentEnemy=null;
            return false;
        }
        return true;
    }
    public void playerAlive(){
        if(player.getCurrentHealth()<=0){
            System.out.println(colorText(red,userName + " dies..."));
            System.exit(0);
        }

    }
    public void enemyAttack(){
        if(currentEnemy==null){
            return;
        }
        System.out.println(colorText(red,currentEnemy.getName() + " is furious!"));
        System.out.println(currentEnemy.getName() + ": " + colorText(yellow,"'"+currentEnemy.getEnemyAttackLine())+"'");
        player.takeDamage(currentEnemy);
        System.out.println(colorText(white, currentEnemy.getName() + " strikes with " + currentEnemy.getWeapon().getName()));
        System.out.println(colorText(red,userName + " takes " + currentEnemy.getWeapon().getDamage() + " damage!"));
    }
    public boolean useItemFight() {
        System.out.print("Eat(item), Use(item), Exit: ");
        String command = parser.battleMenuItems();
        String command1 = command;
        String command2 = "";
        if (command.contains(" ")) {
            int space = command.indexOf(" ");
            command1 = command.substring(0, space);
            command2 = command.substring(space + 1);
        }
        switch (command1) {
            case "use":
                use(command2);
                return true;
            case "eat":
                eat(command2);
                return true;
            case "exit":
                return false;
        }
        return false;
    }
    //Parameters
    public void startText(){
        System.out.println("\nWelcome to the journey of the Skejs\n"+
                colorText(cyan,"The time has come and " + userName + " has done it again..." +
                        "\nOne bottle turned into many, and in the big city of Skejs our hero has lost " + hisOrHer() + " way" +
                        "\nWe need to get "+ himOrHer() +" home before the hour is night, or " + heOrShe() + " will surely start drinking again," +
                        "\nyou are the only hope of showing " + himOrHer() + " the way or all hope will be lost...") +
                colorText(white,"\nYou can write 'look' to see the details of " + userName + apostrof(userName) + " current location," +
                "\nyou can go north, east, south or west to get around."+
                "\nIf there are any further questions please write 'help'\n") +
                "\n"+colorText(cyan,"The time is 12:00pm, and our hero " + userName + " finds " + himselfOrHerself() + " sleeping on a bench"+
                "\n"+ heOrShe() + " knows where " + heOrShe() +" is, this is the " + player.getCurrentRoom().getName()));

    }
    public String healthCheck(){
        double currentHP = player.getCurrentHealth();
        double fullHP = player.getHealth();
        double hpDifference = fullHP/currentHP;
        if(2>hpDifference&&hpDifference>=1){
            return colorText(blue,player.getCurrentHealth() + "/" + player.getHealth());
        }
        if(4>hpDifference&&hpDifference>=2){
            return colorText(yellow,player.getCurrentHealth() + "/" + player.getHealth());
        }
        if(hpDifference>=4){
            return colorText(red,player.getCurrentHealth() + "/" + player.getHealth());
        }
        return null;
    }
    public void setStartParameters(){
        this.player=new Player(userName,100);
        player.setCurrentWeapon(map.getStartItem());
        map.createWorld();
        player.setCurrentRoom(map.getStartRoom());
    }
    public void checkWeapon(){
        if(!player.getCurrentWeapon().checkValid()){
            System.out.println(colorText(red,player.getCurrentWeapon().getName() + " can not be used anymore..." +
                    userName + " throws it away"));
            player.setCurrentWeapon(player.findItem("barehanded"));
            player.destroyItem(player.findItem("barehanded"));
        }
    }

    //Interface
    public void commandScanner(String command){
        String command1 = command;
        String command2 = "";
        if(command.contains(" ")){
            int space = command.indexOf(" ");
            command1 = command.substring(0,space);
            command2 = command.substring(space+1);
        }
        switch(command1){
            case "north":
            case "east":
            case "south":
            case "west":
                go(command);
                break;
            case "attack":
                attack(command2);
                break;
            case "look":
                look();
                break;
            case "inventory":
                inventory();
                break;
            case "health":
                health();
                break;
            case "use":
                use(command2);
                break;
            case "take":
                take(command2);
                break;
            case "drop":
                drop(command2);
                break;
            case "eat":
                eat(command2);
                break;
            case "equip":
                equip(command2);
                break;
            case "help":
                help();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println(colorText(red, "Invalid command: " + command1));
        }
    }

    //Grammar
    public String apostrof(String name){
        int nameSize = name.length();
        if(name.charAt(nameSize-1)=='s'){
            return "'";
        } else {
            return "'s";
        }
    }
    public String addArticle(Items item){
        char letter = item.getName().toLowerCase().charAt(0);
        return switch (letter) {
            case ('a'), ('e'), ('i'), ('o'), ('y'), ('u') -> "an " + item.getName();
            default -> "a " + item.getName();
        };
    }
    public String addArticleCap(String word){
        char letter = word.toLowerCase().charAt(0);
        return switch (letter) {
            case ('a'), ('e'), ('i'), ('o'), ('y'), ('u') -> "An " + word;
            default -> "A " + word;
        };
    }
    public String inOrAtThe(){
        int startIndex = player.getCurrentRoom().getName().indexOf(" ");
        String firstWord = player.getCurrentRoom().getName().substring(0,startIndex);
        if(firstWord.equalsIgnoreCase("the")){
            return "in";
        }
        if(firstWord.equalsIgnoreCase("a")){
            return "by";
        }
        return "at the";

    }
    public String plural(String object){
        int lastIndex = object.length()-1;
        if(object.charAt(lastIndex)=='s'){
            return "some";
        }
        return "the";
    }
    public String heOrShe(){
        if(gender.equals("male")){
            return "he";
        } else return "she";

    }
    public String hisOrHer(){
        if(gender.equals("male")){
            return "his'";
        } else return "her";
    }
    public String himOrHer(){
        if(gender.equals("him")){
            return "him";
        } else return "her";
    }
    public String himselfOrHerself(){
        if(gender.equals("male")){
            return "himself";
        } else return "herself";
    }

    //Colors for String
    public String colorText(String color, String text){
        String resetColour = "\u001B[0m";
        return color + text + resetColour;
    }
    private final String black = "\u001B[30m";
    private final String red = "\u001B[31m";
    private final String green = "\u001B[32m";
    private final String yellow = "\u001B[33m";
    private final String blue = "\u001B[34m";
    private final String purple = "\u001B[35m";
    private final String cyan = "\u001B[36m";
    private final String white = "\u001B[37m";

}
