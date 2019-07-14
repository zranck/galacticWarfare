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
            System.out.println("Lets begin");

        } else {
            return;
        }
        //SetupGame settings = new SetupGame("Banana", 1.1, 13);
    }
}
