package Adventure;

import java.util.Scanner;

public class Adventure {

    public void play(String userName){
        Game game = new Game(userName);
        game.startGame();
        System.out.println("This is the end of the game");
    }


    public static void main(String[] args) {
        System.out.print("Enter the name of your character: ");
        Adventure adventure = new Adventure();
        adventure.play(setUserName());

    }
    public static String setUserName(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext()) {
            System.out.println("Please enter a name");
            sc.next();
        }
        return sc.next();
    }
}
