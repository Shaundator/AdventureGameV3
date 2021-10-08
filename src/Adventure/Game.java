package Adventure;

import java.util.Scanner;

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
        boolean gameOn = true;
        while(gameOn) {
            System.out.print("Command: ");
            String command = parser.commandMenu();
            commandScanner(command);
        }
        System.out.println("End of the game");
    }

    //Commands
    public void go(String direction){;
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
    public void travel(String direction){
        System.out.println(userName + " travels " + direction + " and enters " + player.getCurrentRoom().getName());
    }
    public void travelNot(String direction){
        System.out.println(colorText(red, userName + " can not travel this way..." +
                "\nThere is no path " + direction + " of " + player.getCurrentRoom().getName()));

    }
    public void look(){
        System.out.println(userName + " looks around");
        System.out.println("They are located in " + player.getCurrentRoom().getName());
        System.out.println(colorText(cyan,player.getCurrentRoom().getDescription()));
        System.out.print("\nItems in " + player.getCurrentRoom().getName() + ": ");
        roomItems();
        System.out.println("\nUpon further inspection, " + userName + " tries to see if there are anyone they can talk with");
        roomNPCs();
    }
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
        System.out.println(colorText(cyan,result));

    }
    public void roomNPCs(){
        System.out.println(colorText(red,"there are no one around"));
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
        System.out.print(userName + apostrof(userName) + " health: " + healthCheck());
    }
    public String healthCheck(){
        System.out.println("healthMax: " + player.getHealth());
        System.out.println("current health: " + player.getCurrentHealth());
        double currentHP = player.getCurrentHealth();
        double fullHP = player.getHealth();
        double hpDifference = fullHP/currentHP;
        System.out.println("health difference: " + hpDifference);
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
    public void attack(String enemy){
        if(player.getCurrentRoom().getEnemy(enemy)!=null){
            currentEnemy=player.getCurrentRoom().getEnemy(enemy);
            System.out.println(userName + apostrof(userName) + " foe is " + currentEnemy.getName()+ "!");
            int turn = 0;
            boolean battleOn = true;
            while(battleOn){
                turn++;
                System.out.println(currentEnemy.getName() + apostrof( currentEnemy.getName()) + " health: " + currentEnemy.getHealth() + "\n" +
                        userName + apostrof(userName) + " health: " + healthCheck());
                System.out.println("\nTurn " + turn);
                if(player.getHealth()<=0){
                    System.out.println(colorText(red,userName + " dies..."));
                }
                System.out.println("Attack, Items, Flee");
                switch(parser.battleMenu()){
                    case "attack":
                        System.out.println(userName + " attacks " + currentEnemy.getName() + " with " + player.getCurrentWeapon().getName());
                        System.out.println("Damage Done: " + player.getCurrentWeapon().getDamage());
                        player.attack(currentEnemy);
                        enemyAttack();
                        break;
                    case "items":
                        System.out.println("Use/Throw/Eat (item)");
                        useItemFight();
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
                    System.out.println(userName + " is victorious!");
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
    public void enemyAttack(){
        System.out.println(currentEnemy.getName() + " is furious!");
        player.takeDamage(currentEnemy);
        System.out.println(currentEnemy.getName() + " strikes with all its might!");
        System.out.println(userName + " takes " + currentEnemy.getWeapon().getDamage() + " damage!");
    }
    public void useItemFight(){
        String command = parser.battleMenuItems();
        String command1 = command;
        String command2 = "";
        if(command.contains(" ")){
            int space = command.indexOf(" ");
            command1 = command.substring(0,space);
            command2 = command.substring(space+1);
        }
        switch(command1){
            case "use":
                battleUse(command2);
                break;
            case "throw":
                battleThrow(command2);
                break;
            case "eat":
                battleEat(command2);
                break;
        }
    }
    public void battleUse(String item){
        System.out.println("use item");
    }
    public void battleThrow(String item){
        System.out.println("throw item");
    }
    public void battleEat(String item){
        System.out.println("eat item");
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

    //Parameters
    public void setStartParameters(){
        this.player=new Player(userName,100);
        player.setCurrentWeapon(map.getStartItems());
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
                System.out.println("attacking: " + command2);
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
