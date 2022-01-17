package matriculas;

import java.util.Random;

public class Coche extends Thread{
    int matricula;
    int plazas;
    Parking parking;
    Random random= new Random();
    public Coche(Parking parking) {
        this.parking=parking;

        matricula=random.nextInt((10000-1000)+1000);
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public void run() {
        int[] data = new int[2];
        System.out.println("Coche con matricula "+matricula+" intenta aparcar");
        data= parking.aparcar(matricula);
        plazas=data[0];
        if (plazas>0){
            System.out.println("El coche con matricula "+matricula+" ha aparcado");
            try {
                sleep(random.nextInt(10001)+10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El coche con matricula "+matricula+" abandona parking");
            parking.salio(matricula);
        }else{
            System.out.println("El coche con matricula "+matricula+" no ha podido aparcar");
        }
    }
}
