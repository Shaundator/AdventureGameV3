package Adventure;

public class Game {
    private final String userName;
    Parser parser = new Parser();
    Player player;
    Map map = new Map();
    Enemy currentEnemy;
    public Game(String userName){
        this.userName=userName;
    }

    public void startGame(){
        setStartParameters();
        startText();
        boolean gameOn = true;
        while(gameOn) {
            System.out.print("Command: ");
            String command = parser.commandMenu();
            commandScanner(command);
        }
        System.out.println("End of the game");
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
        System.out.println("der er blevet rejst");
    }
    public void look(){
        System.out.println(userName + " looks around");
        System.out.println(userName + " is located at " + player.getCurrentRoom().getName());
        System.out.println(colorText(cyan,player.getCurrentRoom().getDescription()));
        System.out.print("\nItems in " + player.getCurrentRoom().getName() + ": ");
        roomItems();
        System.out.println("\nUpon further inspection, " + userName + " tries to see if there are anyone they can talk with");
        roomNPCs();
    }
    public void inventory() {
        if(player.getCurrentWeapon()!=null){
            System.out.println(userName + " is holding " + player.getCurrentWeapon().getName() + " as a weapon");
        }
        System.out.println(userName + " checks their inventory");
        System.out.println("Items:");
        String inventory = "";
        if (player.getInventory().size() == 0) {
            inventory += userName + apostrof(userName) + " inventory is empty";
            System.out.println(colorText(red, inventory));
        } else {
            for (int i = 0; i < player.getInventory().size(); i++) {
                inventory += player.getInventory().get(i).getName() + "(" + player.getInventory().get(i).getNameID() + ")";
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
            System.out.println(userName + apostrof(userName) + " foe is " + currentEnemy.getName()+ "!");
            int turn = 0;
            boolean battleOn = true;
            while(battleOn){
                turn++;
                System.out.println(currentEnemy.getName() + apostrof( currentEnemy.getName()) + " health: " + colorText(red, "" + currentEnemy.getHealth()) + " | " +
                        userName + apostrof(userName) + " health: " + healthCheck());
                System.out.println("\nTurn " + turn);
                if(player.getHealth()<=0){
                    System.out.println(colorText(red,userName + " dies..."));
                }
                System.out.print("Attack, Items, Flee: ");
                switch(parser.battleMenu()){
                    case "attack":
                        System.out.println(userName + " attacks " + currentEnemy.getName() + " with " + player.getCurrentWeapon().getName());
                        System.out.println(colorText(white,"Damage Done: " + player.getCurrentWeapon().getDamage()));
                        player.attack(currentEnemy);
                        enemyAttack();
                        break;
                    case "items":
                        System.out.println("Use/Throw/Eat (item)");
                        if(useItemFight()) {
                            enemyAttack();
                        } else {
                            System.out.println(userName + " does nothing?");
                            System.out.println(currentEnemy + " thinks they are up to something and stands on guard");
                        }
                        break;
                    case "flee":
                        battleOn=false;
                        break;
                }
                if(player.getCurrentHealth()<=0){
                    System.out.println(colorText(red,userName + " dies..."));
                    System.exit(0);
                    battleOn=false;
                }
                if(currentEnemy.getHealth()<=0){
                    System.out.println(colorText(green, userName + " is victorious!"));
                    player.getCurrentRoom().enemyDeath(currentEnemy);
                    currentEnemy=null;
                    battleOn=false;
                }
            }
        }
        else {
            System.out.println("No such enemy");
        }
    }
    public void equip(String item){
        if(player.findItem(item)!=null){
            if(player.findItem(item).weaponCheck()){
                System.out.println(colorText(blue,userName + " equips " + player.findItem(item).getName()));
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
        System.out.println(colorText(green,userName + " takes " + tempItem.getName()));
    }
    public void drop(String item){
        Items tempItem = player.findItem(item);
        if(tempItem==null){
            System.out.println(colorText(red,userName + apostrof(userName) + " inventory does not contain " + item));
            return;
        }
        player.dropItem(tempItem);
        System.out.println(colorText(green,userName + " drops " + tempItem.getName()));
    }
    public void eat(String item) {
        if (player.findItem(item) != null) {
            if (player.eatItem(player.findItem(item))){
                player.eatFood(player.findItem(item));
                System.out.println(userName + " eats " + player.findItem(item).getName());
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
                Inventory: See inventory
                Use: Use an item
                Take: Pick up an item from current location
                Drop: Drop an item on current location
                Help: See commands
                Restart: Restart Game
                Exit: Exit the Game
                """));
    }
    public void exit(){
        System.out.println(colorText(red,"A somber night, for death fell upon our hero, " + userName + apostrof(userName) + " life...\n" +
                "May they rest in peace"));
        System.exit(0);
    }

    //SubMenus

    //go
    public void travel(String direction){
        System.out.println(userName + " travels " + direction + " and enters " + player.getCurrentRoom().getName());
    }
    public void travelNot(String direction){
        System.out.println(colorText(red, userName + " can not travel this way..." +
                "\nThere is no path " + direction + " of " + player.getCurrentRoom().getName()));

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
            result += "\n" + addArticleCap(player.getCurrentRoom().getRoomItems().get(i)) +
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
    //attack
    public void enemyAttack(){
        System.out.println(currentEnemy.getName() + " is furious!");
        player.takeDamage(currentEnemy);
        System.out.println(currentEnemy.getName() + " strikes with all its might!");
        System.out.println(colorText(red,userName + " takes " + currentEnemy.getWeapon().getDamage() + " damage!"));
    }
    public boolean useItemFight() {
        System.out.println("take, use or throw an item(exit to exit)");
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
                battleUse(command2);
                return true;
            case "throw":
                battleThrow(command2);
                return true;
            case "eat":
                battleEat(command2);
                return true;
            case "exit":
                return false;
        }
        return false;
    }
    public void battleUse(String item){
        System.out.println("use item");
        eat(item);
    }
    public void battleThrow(String item){
        System.out.println("throw item");
    }
    public void battleEat(String item){
        System.out.println("eat item");
    }

    //Parameters
    public void startText(){
        System.out.println("\nWelcome to the journey of the Skejs\n"+
                colorText(cyan,"The time has come and " + userName + " has done it again..." +
                        "\nOne bottle turned into many, and in the big city of Skejs our hero has lost his way" +
                        "\nWe need to get him home before the hour is night, or he will surely start drinking again," +
                        "\nyou are the only hope of showing him the way or all hope will be lost...") +
                "\nYou can write 'look' to see the details of " + userName + apostrof(userName) + " current location," +
                "\nyou can go north, east, south or west to get around."+
                "\nIf there are any further questions please write 'help'\n"+
                "\n"+colorText(cyan,"The time is 12:00pm, and our hero " + userName + " finds himself sleeping on a bench"+
                "\nHe knows where he is, this is " + player.getCurrentRoom().getName()));

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
    public String addArticleCap(Items item){
        char letter = item.getName().toLowerCase().charAt(0);
        return switch (letter) {
            case ('a'), ('e'), ('i'), ('o'), ('y'), ('u') -> "An " + item.getName();
            default -> "A " + item.getName();
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
