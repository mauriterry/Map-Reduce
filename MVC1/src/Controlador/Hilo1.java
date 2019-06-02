/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MaRu
 */
public class Hilo1 implements Runnable{
	
    private final int id;
    private final int i;
    private final String[] parts;
    private final HashMap<String, Integer> result;
	
    public Hilo1(String[] parts, int i, int aux, HashMap<String, Integer> result) {
        this.id = aux;
        this.i = i;
        this.parts = parts;
        this.result = result;
    }
	
    @Override
    public void run(){
        if(result.containsKey(parts[0])){
            result.put(parts[0], result.get(parts[0]) + i);
        }else{
            result.put(parts[0], i);
        }
    }
}

