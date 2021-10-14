package Adventure;

import java.util.Scanner;

public class Adventure {

    public void play(String userName,String gender){
        Game game = new Game(userName,gender);
        game.startGame();
    }
    public static String setUserName(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext()) {
            System.out.println("Please enter a name");
            sc.next();
        }
        return sc.next();
    }
    public static String setGender(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Male or Female?");
        while(true){
            String gender = sc.nextLine().toLowerCase();
            switch(gender){
                case "male":
                case "man":
                    return "male";
                case "woman":
                case "female":
                    return "female";
                default:
                    System.out.println("Not valid");

            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the name of your character: ");
        Adventure adventure = new Adventure();
        adventure.play(setUserName(),setGender());

    }
}
