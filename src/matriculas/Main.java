package matriculas;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Main{
    public static void main(String[] args) {
        Random random = new Random();
        Coche coche;
        Camion camion;
        Parking parking = new Parking();
        while (true) {
            try {
                sleep(random.nextInt((2500)+500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("test");
            coche = new Coche(parking);
            camion = new Camion(parking);
            coche.start();
            camion.start();

        }

    }
}
