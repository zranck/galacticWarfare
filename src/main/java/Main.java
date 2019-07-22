import java.util.Scanner;
import java.util.Random;

public class Main {

    static String shipName;
    static String enemyName;
    static int turnCount = 0;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Art.introArt();
        System.out.println("Are you ready to begin?");
        System.out.println("Enter Y for yes or any other character to quit: ");
        String begin = reader.nextLine();
        if ((begin.equals("Y")) || begin.equals("y")) {
            beginGame();
        } else {
            System.out.println("Good Bye!");
            return;
        }

    }

    public static void beginGame() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome Captain!");
        System.out.println("We just need some information before we depart.");
        System.out.println("First, what would you like to name your ship?");
        shipName = reader.nextLine();
        System.out.println("Great! the " + shipName + " is nearly ready to depart.\n");
        System.out.println("You should have received information on the hostiles nearby.");
        System.out.println("What name do they go by?");
        enemyName = reader.nextLine();
        System.out.println("Alright captain the " + shipName + " is now enroute to meet the enemy " + enemyName + ". Please standby...");
        beginBattle();

    }

    public static void beginBattle(){
        Scanner reader = new Scanner(System.in);

        Battle myShip = new Battle(30, 100);
        Battle enemyShip = new Battle(30, 100);

        System.out.println("we've reached the enemy ship, and their setup seem to match our own\n \n");
        System.out.println("Both ships have 30 Torpedoes and shields are at 100");
        System.out.println("Each torpedo does 5 damage, but there's always the chance we miss");

        //System.out.println("enemy "+enemyShip.getAmmo()+" "+enemyShip.enemyShields());
        //System.out.println("YOU "+myShip.getAmmo()+" "+myShip.enemyShields());
        Boolean enemyTurn = false;

        //start the back an forth as long as either ship has shields
        while(enemyShip.enemyShields() >= 0 ){
            if(myShip.enemyShields() <=0){
                Results.returnResult("battle lost");
                return;
            }
            //if its your turn
            if(!enemyTurn) {
                if (enemyShip.getAmmo() > 0 && myShip.getAmmo() <= 0) {
                    System.out.println("We're out of ammo they get to fire again!");
                    enemyTurn = true;
                } else if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() <= 0) {
                    new Results().returnResult("out of ammo");
                    return;
                } else{

                    if (turnCount <= 0) {
                        System.out.println("We've taken them by suprise and can take the first shot");
                    }
                    System.out.println("how many would you like to fire?");
                    while(!reader.hasNextInt()) {
                        reader.next();
                        System.out.println("Please Enter A Valid Digit(1,2,3,...)");
                    }
                    int firedAmmo = reader.nextInt();
                    if(firedAmmo >  myShip.getAmmo()){
                        System.out.println("You only have " +  myShip.getAmmo() + " ammo remaining.");
                        System.out.println("Firing remaining " +myShip.getAmmo() + " ammo instead.");
                        firedAmmo = myShip.getAmmo();
                    }

                    //reduce total ammo, and setup total shots fired
                    myShip.fire(firedAmmo);
                    //randomize how many shots fired hit and the damage done
                    myShip.hits(firedAmmo);
                    //subtract shields from enemy shields
                    enemyShip.shields(myShip.getDamageDone());
                    enemyTurn = true;

                     //PRINT OUT RESULT OF TURN
                    Turn.returnMyTurn(firedAmmo,myShip.getDamageDone(),myShip.getAmmo(),myShip.enemyShields(),enemyShip.enemyShields(),enemyShip.getAmmo());

                }
            } else {  //if its the enemy turn
                if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() > 0) {
                    System.out.println("\n ↺ Enemy is out of ammo we get to fire again!");
                    enemyTurn = false;
                } else if (enemyShip.getAmmo() <= 0 && myShip.getAmmo() <= 0) {
                    new Results().returnResult("out of ammo");
                    return;
                } else {

                    System.out.println("\n");
                    System.out.println("────────────BEGIN ENEMY TURN───────────────");
                    Art.enemyShip();
                    Random enemyRandom = new Random();
                    int enemyFiredShots = 1 + enemyRandom.nextInt(enemyShip.getAmmo());

                    //reduce total ammo, and setup total shots fired
                    enemyShip.fire(enemyFiredShots);
                    //randomize how many shots fired hit and the damage done
                    enemyShip.hits(enemyFiredShots);
                    //subtract damage from enemy shields
                    myShip.shields(enemyShip.getDamageDone());


                    enemyTurn = false;

                    //PRINT OUT RESULT OF ENEMY TURN
                    Turn.returnEnemyTurn(enemyFiredShots,enemyShip.getDamageDone(),myShip.enemyShields(),myShip.getAmmo(),enemyShip.enemyShields(),enemyShip.getAmmo());

                }
            }
            turnCount++;
        }//end while
        if(enemyShip.enemyShields() <=0){
            Results.returnResult("battle won");
        } else {
            Results.returnResult("battle lost");
        }

    }

}
