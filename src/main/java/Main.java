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
        System.out.println("how many would you like to fire?");
        int firedAmmo = Integer.parseInt(reader.nextLine());

        //reduce total ammo, and setup total shots fired
        myShip.fire(firedAmmo);
        //randomize how many shots fired hit and the damage done
        myShip.hits(firedAmmo);

        //Print out the damage done
        System.out.println("You dealt " + myShip.getDamageDone() + " damage!");

        //subtract shields from enemy shields
        enemyShip.shields(myShip.getDamageDone());


        System.out.println(myShip);

        System.out.println("The enemy ships shields are at: " + enemyShip.enemyShields());

        //CHECK IF THE OTHER SHIP SURVIVED
        if (enemyShip.enemyShields() <= 0) {
            System.out.println("YOU WON!");
            return;
        }

        while (enemyShip.enemyShields() > 0 || myShip.enemyShields() > 0) {
            if (enemyShip.getAmmo() > 0) {
                System.out.println("\n|||||||| ENEMY TURN ||||||||");
                System.out.println("|||||| SHIELDS: "+enemyShip.enemyShields()+" ||||||");
                System.out.println("||||||  AMMO: "+enemyShip.getAmmo()+" ||||||\n");
                ///// ENEMY TURN
                System.out.println("\n the enemy is returning fire!");
                Random enemyRandom = new Random();
                int enemyFiredShots = 1 +enemyRandom.nextInt(enemyShip.getAmmo());
                System.out.println("The enemy fires " + enemyFiredShots + " torpedoes");
                enemyShip.fire(enemyFiredShots);
                //randomize how many shots fired hit and the damage done
                enemyShip.hits(enemyFiredShots);

                //Print out the damage done
                System.out.println("the enemy dealt " + enemyShip.getDamageDone() + " damage");

                //subtract shields from enemy shields
                myShip.shields(enemyShip.getDamageDone());


                System.out.println(enemyShip);

                System.out.println("Your ships shields are at: " + myShip.enemyShields());

                //CHECK IF THE OTHER SHIP SURVIVED
                if (myShip.enemyShields() <= 0) {
                    System.out.println("YOU LOST!");
                    return;
                }
            } else if(enemyShip.getAmmo() <= 0 && myShip.getAmmo() <=0){
                System.out.println("Both ships are out of ammo and must leave the area.");
                System.out.println("||||||||GAME OVER||||||||");
                return;
            }else {
                System.out.println("the enemy has no ammo, it's our turn again");
            }
            if (myShip.getAmmo() > 0) {
                //// PLAYER NEXT TURN
                System.out.println("We survied their counter attack!");
                System.out.println("\n|||||||| YOUR TURN ||||||||");
                System.out.println("|||||| SHIELDS: "+myShip.enemyShields()+" ||||||");
                System.out.println("||||||  AMMO: "+myShip.getAmmo()+" ||||||\n");


                System.out.println("how many would you like to fire?");
                firedAmmo = Integer.parseInt(reader.nextLine());

                //reduce total ammo, and setup total shots fired
                myShip.fire(firedAmmo);
                //randomize how many shots fired hit and the damage done
                myShip.hits(firedAmmo);

                //Print out the damage done
                System.out.println("the damage done was " + myShip.getDamageDone());

                //subtract shields from enemy shields
                enemyShip.shields(myShip.getDamageDone());


                System.out.println(myShip);

                System.out.println("The enemy ships shields are at: " + enemyShip.enemyShields());

                //CHECK IF THE OTHER SHIP SURVIVED
                if (enemyShip.enemyShields() <= 0) {
                    System.out.println("YOU WON!");
                    return;
                }

            } else if(enemyShip.getAmmo() <= 0 && myShip.getAmmo() <=0){
            return;
        } else {
                System.out.println("We are out of ammo!");
            }
        }

    }

}
