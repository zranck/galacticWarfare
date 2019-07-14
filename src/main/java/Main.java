import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("\t\t   ◺");
        System.out.println("\t\t   ▤◺");
        System.out.println("\t\t◅◅▤▤▤▤▤▤▻");
        System.out.println("\t\t   ▤▤▤◺");
        System.out.println("\t\t   ▤▤▤▤▤◺                      This Is");
        System.out.println("\t\t◅◅▤▤▤▤▤▤▤▤▤▤▤▤▷");
        System.out.println("\t\t   ▤▤▤▤▤◸                  GALACTIC WARFARE");
        System.out.println("\t\t   ▤▤▤◸");
        System.out.println("\t\t◅◅▤▤▤▤▤▤▻");
        System.out.println("\t\t   ▤◸");
        System.out.println("\t\t   ◸");

        System.out.println("Are you ready to begin?");
        System.out.println("Enter Y for yes or N to Quit: ");
        String begin = reader.nextLine();
        if ((begin.equals("Y")) || begin.equals("y")){
            beginGame();
        } else {
            return;
        }
        //SetupGame settings = new SetupGame("Banana", 1.1, 13);
    }

    public static void beginGame(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome Captain!");
        System.out.println("We just need some information before we depart.");
        System.out.print("First, what would you like to name your ship?");
        String shipName = reader.nextLine();
        System.out.println("Great! the "+shipName+" is ready to depart.");
        System.out.println("You should have received information on the hostiles nearby.");
        System.out.print("What name do they go by?");
        String enemyName = reader.nextLine();
        System.out.println("Alright captain the "+shipName+" is now enroute to meet the enemy "+enemyName+". Please standby...");

        Battle myShip = new Battle( 50, 100);
        Battle enemyShip = new Battle (50,100);
        System.out.println("we've reached the enemy ship, and their setup seem to match our own");
        System.out.println("Both ships have 50 Torpedo's and shields are at 100");
        System.out.println("Each torpedo does 5 damage, but there's always the chance we miss");
        System.out.println("how many would you like to fire?");

        int firedAmmo = Integer.parseInt(reader.nextLine());
        myShip.fire(firedAmmo);
        myShip.hits(firedAmmo);
        System.out.println("the damage done was "+ myShip.getMyInt());
        enemyShip.shields(myShip.getMyInt());
        System.out.println("Pekka: " + myShip);
        System.out.println("Brian: " + enemyShip);
    }



}
