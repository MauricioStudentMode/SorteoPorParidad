package Main;

import Modelo.CrearCasos;
import Modelo.EvaluarCaso;
import Accesorios.AutomatizarProceso;

public class TallerSortByParity {

    public static void main(String[] args) {
        CrearCasos machine = new CrearCasos();
        AutomatizarProceso auto = new AutomatizarProceso();
        try{
        auto.AutomatizarYProcesar();
        EvaluarCaso e = new EvaluarCaso();
            System.out.print("Número de Casos Correctos:" + "\n");
            System.out.println(e.getPorcentaje() + "/100");
        }
        catch(Exception e){}
    }
}
