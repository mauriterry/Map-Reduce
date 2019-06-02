/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Hilo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author MaRu
 */
public class Map {
    public static void Map(String text) throws IOException, InterruptedException{
        //Ingresa datos array
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/input/inter10.txt")));
        System.out.println("********Inicio de Limpieza ******** \n");
        String[] parts = tratamientoDatos1.guardarPdf(tratamientoDatos.guardarPdf(text)).split(",");
        System.out.println("********Finalizacion de Limpieza******** \n");
        int aux=0;
        for(String val: parts){
            Hilo Hilo = new Hilo(val,1,aux,writer);
            Hilo.run();
        }
        System.out.println("********Finalizacion Funcion Map******** \n");
    }
}
