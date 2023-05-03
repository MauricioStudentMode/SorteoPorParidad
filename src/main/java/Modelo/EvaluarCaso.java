package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mauricio Di Donato Sánchez
 */
public class EvaluarCaso {
        
        private int[][] casos;
        private int porcentaje;
        
        /*Cada "CASO" tiene un valor de 25 unidades, ya que cada "CASO" esta
          por 25 arreglos diferentes de entrada. Lo que significa que "CASO" 1 + 2 + 3 + 4 = 100/100 Correctos */
        public EvaluarCaso(){
            porcentaje = 0;
            leerArchivo("./codigo/out1.txt", 30);
            porcentaje += parity();
            leerArchivo("./codigo/out2.txt", 500);
            porcentaje += parity();
            leerArchivo("./codigo/out3.txt", 1000);
            porcentaje += parity();
            leerArchivo("./codigo/out4.txt", 5000);
            porcentaje += parity();
        }
        
        //Lee el archivo y guarda cada caso en la matriz casosDePrueba
        public void leerArchivo(String ruta, int n) {
            int[][] casos = new int[25][n];
        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int[] caso = new int[n];
            String[] strings;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                strings = linea.split(" ");
                for(int j = 0; j < strings.length; j++){
                    caso[j] = Integer.parseInt(strings[j]);
                } 
                casos[i] = caso;
                i++;
            }
            fr.close();
            this.casos = casos;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
        
    }
        
        //Evalua que la respuesta dada sea correcta
        public int parity(){
            int resultado = 25;
            for(int i = 0; i < this.casos.length; i++){
                for(int j = 0; j < this.casos[i].length; j++){
                    int dato = this.casos[i][j];
                    if((j%2==0 && dato%2!=0) || (j%2!=0 && dato%2==0)){
                        resultado--;
                    }
                }
            }
            return resultado;
        }

    public int[][] getCasos() {
        return casos;
    }

    public void setCasos(int[][] casos) {
        this.casos = casos;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
