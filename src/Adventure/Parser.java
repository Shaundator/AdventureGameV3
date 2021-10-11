package Adventure;

import java.util.Scanner;

public class Parser {
    //General
    public String commandMenu() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        String command;
        String commandInput = "";
        if (input.contains(" ")) {
            command = input.substring(0, input.indexOf(" "));
            commandInput = input.substring(input.indexOf(" ") + 1);
        } else {
            command = scanCommand(input);
        }
        switch (command) {
            case "go":
                if (scanCommand(input).equals(command)) {
                    return scanDirection(input);
                }
                return scanDirection(commandInput);
            case "use":
            case "take":
            case "drop":
            case "equip":
            case "eat":
            case "attack":
                return command + " " + commandInput;
            case "look":
            case "inventory":
            case "health":
            case "time":
            case "help":
            case "exit":
                return command;
            default:
                return "("+command+")";
        }
    }

    //Battle
    public String battleMenu() {
        Scanner scBattle = new Scanner(System.in);
        boolean validAttack = true;
        while (validAttack) {
            String choice = scBattle.nextLine().toLowerCase();
            if (choice.equals("attack")) {
                return "attack";
            }
            if (choice.equals("items") || choice.equals("item")) {
                return "items";
            }
            if (choice.equals("flee")) {
                return "flee";
            }
            System.out.println("invalid");
        }
        return "what?";
    }
    public String battleMenuItems(){
        Scanner scBattleItems = new Scanner(System.in);
        while(true){
            String choice = scBattleItems.nextLine().toLowerCase();
            String command = scanBattleChoice(choice);
            if(command.equals("use")) {
                return "use " + choice;
            }
            if(command.equals("throw")) {
                return "throw " + choice;
            }
            if(command.equals("eat")) {
                    return "eat " + choice;
            }
            System.out.println("invalid");
        }
    }

    //Scanners
    public String scanDirection(String userInput) {
        if ((userInput.equalsIgnoreCase("North")) || (userInput.equalsIgnoreCase("N"))) {
            return "north";
        }
        else if ((userInput.equalsIgnoreCase("East")) || (userInput.equalsIgnoreCase("E"))) {
            return "east";
        }
        else if ((userInput.equalsIgnoreCase("South")) || (userInput.equalsIgnoreCase("S"))) {
            return "south";
        }
        else if ((userInput.equalsIgnoreCase("West")) || (userInput.equalsIgnoreCase("W"))) {
            return "west";
        }
        else return "invalid direction";
    }
    public String scanBattleChoice(String userInput){
        if(userInput.contains("use")){
            return "use";
        }
        if(userInput.contains("throw")){
            return "throw";
        }
        if(userInput.contains("eat")){
            return "eat";
        }
        return "invalid";
    }
    public String scanCommand(String userInput) {
        if ((userInput.equalsIgnoreCase("North")) || (userInput.equalsIgnoreCase("N"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("East")) || (userInput.equalsIgnoreCase("E"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("South")) || (userInput.equalsIgnoreCase("S"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("West")) || (userInput.equalsIgnoreCase("W"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("Inv")) || (userInput.equalsIgnoreCase("I"))){
            return "inventory";
        }
        else if ((userInput.equalsIgnoreCase("health")) || (userInput.equalsIgnoreCase("hp"))){
            return "health";
        }
        else if ((userInput.equalsIgnoreCase("Take"))){
            return "take";
        }
        else if ((userInput.equalsIgnoreCase("drop"))){
            return "drop";
        }
        else if (userInput.equalsIgnoreCase("Look")) {
            return "look";
        }
        else if (userInput.equalsIgnoreCase("Help")) {
            return "help";
        }
        else if(userInput.equalsIgnoreCase("Restart")){
            return "restart";
        }
        else if (userInput.equalsIgnoreCase("Exit")) {
            return "exit";
        }
        else{return userInput;}
    }

}
