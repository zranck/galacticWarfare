import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
        if ((begin.equals("Y")) || begin.equals("y")) {
            beginGame();
        } else {
            return;
        }
    }

    public static void beginGame() {

        /////////////////
        /// INTRO INFORMATION
        /////////////////////
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome Captain!");
        System.out.println("We just need some information before we depart.");
        System.out.println("First, what would you like to name your ship?");
        String shipName = reader.nextLine();
        System.out.println("Great! the " + shipName + " is nearly ready to depart.\n");
        System.out.println("You should have received information on the hostiles nearby.");
        System.out.println("What name do they go by?");
        String enemyName = reader.nextLine();
        System.out.println("Alright captain the " + shipName + " is now enroute to meet the enemy " + enemyName + ". Please standby...");

        Battle myShip = new Battle(30, 100);
        Battle enemyShip = new Battle(30, 100);

        System.out.println("we've reached the enemy ship, and their setup seem to match our own\n \n");
        System.out.println("Both ships have 30 Torpedoes and shields are at 100");
        System.out.println("Each torpedo does 5 damage, but there's always the chance we miss");

        System.out.println("enemy "+enemyShip.getAmmo()+" "+enemyShip.enemyShields());
        System.out.println("YOU "+myShip.getAmmo()+" "+myShip.enemyShields());
        Boolean enemyTurn = false;
        int turnCount = 0;
        //start the back an forth as long as either ship has shields
        while(enemyShip.enemyShields() >= 0 ){
            if(myShip.enemyShields() <=0){
                System.out.println("☢☢☢ GAME OVER ☢☢☢");
                System.out.println("You Lost");
                return;
            }
            //if its your turn
            if(!enemyTurn) {
                if (enemyShip.getAmmo() > 0 && myShip.getAmmo() <= 0) {
                    System.out.println("We're out of ammo they get to fire again!");
                    enemyTurn = true;
                } else if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() <= 0) {
                    System.out.println("\n \n \n \n \n");
                    System.out.println(" ═══════════════════════════════════════");
                    System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
                    System.out.println("║      BOTH SIDES ARE OUT OF AMMO       ║");
                    System.out.println("║    THE BATTLE IS OVER... FOR NOW      ║");
                    System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
                    System.out.println(" ═══════════════════════════════════════");
                    return;
                } else{

                if (turnCount <= 0) {
                    System.out.println("We've taken them by suprise and can take the first shot");
                }
                System.out.println("how many would you like to fire?");
                int firedAmmo = Integer.parseInt(reader.nextLine());
                //reduce total ammo, and setup total shots fired
                myShip.fire(firedAmmo);
                //randomize how many shots fired hit and the damage done
                myShip.hits(firedAmmo);
                //subtract shields from enemy shields
                enemyShip.shields(myShip.getDamageDone());
                enemyTurn = true;

                //PRINT OUT RESULT OF TURN
                System.out.println("\n \n");
                System.out.println("────────────END OF YOUR TURN────────────────");
                System.out.println("         AFTER FIRING " + firedAmmo + " SHOTS");
                System.out.println("         YOU DEALT " + myShip.getDamageDone() + " DAMAGE!");
                System.out.println("ENEMY SHIP STATUS || SHIELDS: "+enemyShip.enemyShields()+" AMMO: "+enemyShip.getAmmo());
                System.out.println("YOUR SHIP STATUS  || SHIELDS: "+myShip.enemyShields()+" AMMO: "+myShip.getAmmo());
            }
            } else {  //if its the enemy turn
                if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() > 0) {
                    System.out.println("\n ↺ Enemy is out of ammo we get to fire again!");
                    enemyTurn = false;
                } else if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() <= 0) {
                    System.out.println("\n \n \n \n \n");
                    System.out.println(" ═══════════════════════════════════════");
                    System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
                    System.out.println("║      BOTH SIDES ARE OUT OF AMMO       ║");
                    System.out.println("║    THE BATTLE IS OVER... FOR NOW      ║");
                    System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
                    System.out.println(" ═══════════════════════════════════════");
                    return;
                } else {

                System.out.println("\n \n");
                    System.out.println("────────────BEGIN ENEMY TURN───────────────");
                Random enemyRandom = new Random();
                int enemyFiredShots = 1 + enemyRandom.nextInt(enemyShip.getAmmo());

                //reduce total ammo, and setup total shots fired
                enemyShip.fire(enemyFiredShots);
                //randomize how many shots fired hit and the damage done
                enemyShip.hits(enemyFiredShots);
                //subtract damage from enemy shields
                myShip.shields(enemyShip.getDamageDone());


                enemyTurn = false;

                //PRINT OUT RESULT OF TURN
                System.out.println("\n \n");
                System.out.println("────────────END OF ENEMY TURN───────────────");
                System.out.println("         AFTER FIRING " + enemyFiredShots + " SHOTS");
                System.out.println("         YOU RECEIVED " + enemyShip.getDamageDone() + " DAMAGE!");
                System.out.println("YOUR SHIP STATUS || SHIELDS: "+myShip.enemyShields()+" AMMO: "+myShip.getAmmo());
                System.out.println("ENEMY SHIP STATUS  || SHIELDS: "+enemyShip.enemyShields()+" AMMO: "+enemyShip.getAmmo());
            }
            }
            turnCount++;
        }//end while
        if(enemyShip.enemyShields() <=0){

            System.out.println("\n \n \n \n \n");
            System.out.println(" ═══════════════════════════════════════");
            System.out.println("║★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★║");
            System.out.println("║   THE ENEMY SHIP HAS BEEN DESTROYED   ║");
            System.out.println("║                YOU WON!!!             ║");
            System.out.println("║★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★║");
            System.out.println(" ═══════════════════════════════════════");



        } else {
            System.out.println("You Lost :(");
        }


    }

}
