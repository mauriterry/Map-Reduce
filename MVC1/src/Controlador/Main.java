/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Map;
import Modelo.Ordenar;
import Modelo.Reduce;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author MaRu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        try {
            File file = new File("F:/AplicacionPersistenciaPoliglotaPFC.pdf");
            try (PDDocument pddDocument = PDDocument.load(file)) {
                //Extraccion de cada palabra contenida en el pdf
                System.out.println("********Extraccion de cada palabra contenida en el pdf******** \n");
                PDFTextStripper textStripper = new PDFTextStripper();
                String content = textStripper.getText(pddDocument);
                System.out.println("********Finalizacion de extraccioon de cada palabra contenida en el pdf******** \n");
                System.out.println("********Inicio Funcion Map******** \n");
                Map.Map(content);
                Ordenar.Ordenar(Reduce.Reduce());
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
