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

    public void shields(int damage){
        this.shields = this.shields - damage;
    }

    public void hits(int hit) {
        //how many hit?
        this.damageDone = random.nextInt(hit) * 5;

    }


    public int getMyInt()
    {
        return damageDone;
    }

    public String toString() {
        return "you have "+this.ammo+" remaining and "+damageDone+"damage was done you fired "+shotsFired+"shields are at "+this.shields;
    }


    public void reset(){
        this.shotsFired = 0;
    }


}

