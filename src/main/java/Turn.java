public class Turn {

    public static void returnEnemyTurn(int shotsFired, int damageDone, int myShields, int myAmmo, int enemyShields, int enemyAmmo){

        System.out.println("\n \n");
        System.out.println("────────────END OF ENEMY TURN───────────────");
        System.out.println("         AFTER FIRING " + shotsFired + " SHOTS");
        System.out.println("         YOU RECEIVED " + damageDone + " DAMAGE!");
        System.out.println("YOUR SHIP STATUS || SHIELDS: "+myShields+" AMMO: "+myAmmo);
        System.out.println("ENEMY SHIP STATUS  || SHIELDS: "+enemyShields+" AMMO: "+enemyAmmo);

    }

    public static void returnMyTurn(int shotsFired, int damageDone, int myShields, int myAmmo, int enemyShields, int enemyAmmo){
        System.out.println("\n \n");
        System.out.println("────────────END OF YOUR TURN────────────────");
        System.out.println("         AFTER FIRING " + shotsFired + " SHOTS");
        System.out.println("         YOU DEALT " + damageDone + " DAMAGE!");
        System.out.println("ENEMY SHIP STATUS || SHIELDS: "+enemyShields+" AMMO: "+enemyAmmo);
        System.out.println("YOUR SHIP STATUS  || SHIELDS: "+myShields+" AMMO: "+myAmmo);
    }
}
