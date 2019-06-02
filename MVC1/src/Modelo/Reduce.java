/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Hilo1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author MaRu
 */
public class Reduce {   
    public static HashMap<String, Integer> Reduce() throws IOException, InterruptedException{
        HashMap<String,Integer> result;
        System.out.println("********Inicio Funcion Reduce******** \n");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input/inter10.txt")))) {
            String line;
            int aux=0;
            result = new HashMap<>();
            while((line=reader.readLine())!=null){
                String[] parts = line.split(",");
                Hilo1 Hilo1 = new Hilo1(parts,1,aux,result);
                Hilo1.run();
            }
        }
        System.out.println("********Finalizacion Funcion Reduce******** \n");
        return result;
    }
        
}
