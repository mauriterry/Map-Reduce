package Controlador;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo implements Runnable {
	
    private final int id;
    private final String val;
    private final int k;
    private final BufferedWriter writer;
	
    public Hilo(String val, int k, int aux, BufferedWriter writer) {
        this.val = val;
        this.k = k;
        this.id = aux;
        this.writer = writer;
    }

    @Override
    public void run(){
        try {
            writer.append(val + "," + k + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
