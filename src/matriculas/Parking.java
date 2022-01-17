package matriculas;

public class Parking {
    Plaza[] plazas = new Plaza[50];

    public Parking() {
        for (int i = 0; i <50 ; i++) {
            plazas[i]=new Plaza(-1);
        }
    }
    public synchronized int[] aparcar(int matricula){
        int[] data = {0,0};
        int libre=0;
        int posicion=0;
        for (Plaza plaza:
             plazas) {
            System.out.println(plaza.matricula);
            if (plaza.matricula==-1){
                libre=1;
                plaza.matricula=matricula;
                posicion++;
                break;
            }else {libre=0;}
        }
        data[0]=libre;
        data[1]=posicion;
        return data;
    }
    public synchronized void salio(int matricula){
        for (Plaza plaza:
             plazas) {
            if(matricula== plaza.matricula){
                plaza.matricula=-1;
            }
        }
    }

    public Plaza[] getPlazas() {
        return plazas;
    }
    public boolean getadyacente(int numeroabuscar){
        return plazas[numeroabuscar + 1].matricula != 0;
    }
}
