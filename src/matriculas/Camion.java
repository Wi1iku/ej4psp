package matriculas;

import java.util.Random;

public class Camion extends Thread{
    int matricula;
    int plazas;
    Parking parking;
    Random random= new Random();
    public Camion(Parking parking) {
        this.parking=parking;

        matricula=random.nextInt((10000-1000)+1000);
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public void run() {
        int[] data = new int[2];
        int posicion;
        try {
            sleep(random.nextInt(10001)+10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Camion con matricula "+matricula+" intenta aparcar");

        data= parking.aparcar(matricula);
        plazas=data[0];
        posicion=data[1];
        System.out.println(plazas>0);
        System.out.println(posicion%2==0);
        System.out.println(parking.getadyacente(posicion));
        System.out.println(posicion);
        if (plazas>0 && ((posicion%2)==0)&&(parking.getadyacente(posicion))){
            System.out.println("El camion con matricula "+matricula+" ha aparcado");
            try {
                sleep(random.nextInt(10001)+10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El camion con matricula "+matricula+" abandona parking");
            parking.salio(matricula);
        }else{
            System.out.println("El camion con matricula "+matricula+" no ha podido aparcar");
        }
    }
}
