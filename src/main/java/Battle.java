import java.util.Random;

public class Battle {


    private int ammo;
    private int shields;
    private int shotsFired;
    private int damageDone;
    private Random random = new Random();

    public Battle(int ammo, int shields) {
        this.ammo = ammo;
        this.shields = shields;
    }

    public void fire(int amount){
        //new ammo amount
        this.ammo = this.ammo - amount;
        this.shotsFired = amount;
    }
    public int getAmmo(){
        return this.ammo;
    }

    public void shields(int damage){
        this.shields = this.shields - damage;
    }

    public void hits(int hit) {
        //how many hit?
        this.damageDone = random.nextInt(hit) * 5;

    }



    public int getDamageDone()
    {
        return damageDone;
    }

    public int enemyShields(){
        return this.shields;
    }

    public String toString() {
        return "you have "+this.ammo+" torpedoes remaining and your shields are at "+this.shields;
    }


    public void reset(){
        this.shotsFired = 0;
    }


}

