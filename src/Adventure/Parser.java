package Adventure;

import java.util.Locale;
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
            case "inspect":
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
    public String yesOrNo(){
        Scanner sc1 = new Scanner(System.in);
        String yesOrNo = sc1.nextLine().toLowerCase();
        if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
                return "yes";
        }
        if (yesOrNo.equals("no") || yesOrNo.equals("n")) {
                return "no";
        }
        return "("+yesOrNo+")";
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
            String command = scBattleItems.nextLine().toLowerCase();
            String command1 = command;
            String command2 = "";
            if (command.contains(" ")) {
                int space = command.indexOf(" ");
                command1 = command.substring(0, space);
                command2 = command.substring(space + 1);
            } else {
                command1 = command;
            }
            switch(command1) {
                case "use":
                case "eat":
                    return command1 + " " + command2;
                case "exit":
                    return command1;
            }
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
