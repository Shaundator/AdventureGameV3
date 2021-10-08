package Adventure;

import java.util.Scanner;

public class Parser {
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
