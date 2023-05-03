package Accesorios;

import java.io.*;

public class AutomatizarProceso {
    
    public AutomatizarProceso(){
    }
    
    public void AutomatizarYProcesar() throws IOException, InterruptedException {

        // Compilar el archivo codigo.cpp
        ProcessBuilder compileProcessBuilder = new ProcessBuilder("c++", "./codigo/codigo.cpp", "-o", "./codigo/problem.exe");
        Process compileProcess = compileProcessBuilder.start();
        compileProcess.waitFor();

        // Ejecutar cada caso de prueba
        for (int i = 1; i <= 4; i++) {
            // Crear el proceso para ejecutar el archivo compilado con los datos de entrada y salida del caso de prueba
            ProcessBuilder executeProcessBuilder = new ProcessBuilder("./codigo/problem.exe");
            executeProcessBuilder.redirectInput(new File("./codigo/CASO" + i + ".txt"));
            executeProcessBuilder.redirectOutput(new File("./codigo/out" + i + ".txt"));
            Process executeProcess = executeProcessBuilder.start();
            executeProcess.waitFor();
        }

    }

}

