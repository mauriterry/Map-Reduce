/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author MaRu
 */
public class Ordenar {
    public static void Ordenar(HashMap<String, Integer> result) throws IOException {
        System.out.println("********Inicio Funcion Ordenar******** \n");
        Set<java.util.Map.Entry<String,Integer>> set = result.entrySet();
        List<java.util.Map.Entry<String,Integer>> lista = new ArrayList<>(set);
        Collections.sort(lista, (java.util.Map.Entry<String,Integer> o1, java.util.Map.Entry<String,Integer> o2) -> (o2.getValue()).compareTo(o1.getValue()));
        lista.stream().forEach((val) -> {
            System.out.println(val.getKey() + " -> " + val.getValue());
        });
        System.out.println("********Finalizacion Funcion Ordenar******** \n");
    }
}
