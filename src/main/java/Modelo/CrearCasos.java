/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CrearCasos {

    /*Existen dos tipos de caso de prueba principales: 
    1- donde los elementos de arreglo estan desordenados y otro donde los elementos del arreglo estan ordenados.
    seran 100 casos dividos en 4 tipos: 1- 25 casos de tamaño == 30, 2- luego 25 casos de tamaño 500, 
    luego 25 casos de tamaño 1000 y los ultimos 25 casos de tamaño 5000.
    
    Se decidio dejar la cotaSuperior en 5000 para evitar un desbortamiento en la memoria del programa :0*/
    public CrearCasos() {
        CrearCasos(30, "CASO1");
        CrearCasos(500, "CASO2");
        CrearCasos(1000, "CASO3");
        CrearCasos(5000, "CASO4");
    }
    
    /*Los casos siempre seran de n = 25 para tener un total de 100 casos de prueba.
       Lo unico que cambiara es el tamaño de cada arreglo.*/
    public void CrearCasos(int n, String archivo) {
        Boolean coin = false;
        LinkedList<int[]> casos = new LinkedList();
        for (int i = 0; i < 25; i++) {
            casos.addLast(rellenarLista(n, coin));
            if (!coin) {
                coin = true;
            } else {
                coin = false;
            }
        }
        String data = listaToString(casos);
        try {
            saveToFiles(data, archivo);
        } catch (Exception e) {
        }
    }
    
    /*Se rellena la lista con un numero aleatorio en el rango de 0 a 1000 el cual puede ser par o impar.
      Al finalizar el metodo, el arreglo estra compuesto por una mitad de numeros pares y otra de impares*/
    public int[] rellenarLista(int n, boolean ordenado) {
        int[] array = new int[n];
        int x = -1;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int numero = rand.nextInt(1000);
            if ((ordenado && i % 2 == 0) || x == -1) {
                numero = numero - (numero % 2);
            } else if ((ordenado && i % 2 != 0) || x != -1) {
                numero = numero - (numero % 2) + 1;
            }
            x *= -1;
            array[i] = numero;
        }
        return array;
    }
     
    /*Asignamos los casos de prueba a un string para luego guardarlos en un archivo .txt */
    public String listaToString(LinkedList<int[]> casos) {
        Iterator<int[]> list = casos.iterator();
        int[] dato;
        String dataSet = "", data = "";
        while (list.hasNext()) {
            dato = list.next();
            dataSet += dato.length + "\n";
            data = Arrays.toString(dato).replaceAll("[\\[\\],]", "");
            dataSet += data + "\n";
        }
        return dataSet;
    }

    public static void saveToFiles(String contentToWrite, String fileName) throws IOException {
        String path = "./codigo/" + fileName + ".txt";
        Files.write(Paths.get(path), contentToWrite.getBytes());
    }

}
