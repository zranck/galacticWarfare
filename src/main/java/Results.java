public class Results {
    public static void returnResult(String result){
        if( result.contentEquals("out of ammo")){
            System.out.println("\n \n \n \n \n");
            System.out.println(" ═══════════════════════════════════════");
            System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
            System.out.println("║      BOTH SIDES ARE OUT OF AMMO       ║");
            System.out.println("║    THE BATTLE IS OVER... FOR NOW      ║");
            System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░║");
            System.out.println(" ═══════════════════════════════════════");
        }
        if (result.contentEquals("battle won")){
            System.out.println("\n \n \n \n \n");
            System.out.println(" ═══════════════════════════════════════");
            System.out.println("║★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★║");
            System.out.println("║   THE ENEMY SHIP HAS BEEN DESTROYED   ║");
            System.out.println("║                YOU WON!!!             ║");
            System.out.println("║★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★║");
            System.out.println(" ═══════════════════════════════════════");
        }
        if(result.contentEquals("you lost")){
            System.out.println("☢☢☢ GAME OVER ☢☢☢");
            System.out.println("You Lost");
        }

    }
}
