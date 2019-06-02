/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sala7
 */
public class tratamientoDatos {
    public static String guardarPdf(String content) throws IOException {
       guardarpdf(content);
        BufferedWriter writer;
        ArrayList<String> palabraModificada;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/datos/inter4.txt")));
            writer = new BufferedWriter(new FileWriter(new File("src/datos/inter1.txt")));
            String line;
            palabraModificada = new ArrayList<>();
            while((line=reader.readLine())!=null){
                String[] parts = line.split(",");
                if (parts[0].contains("-") || parts[0].contains("http") || parts[0].contains("https")){
                    //Modificando palabra con -
                    palabraModificada.add(parts[0]);
                }else{
                    //Sin modificar para esta
                    writer.append(parts[0].replaceAll("[!#^/,.:“”•\"%&();=¿?@_{}>’<$\\|»«‘∗—/]", "")+"\n");
                }
            }
        writer.close();
        String pal = palabraModificada.toString();
        modificarCaracter1(pal);
        String x1= unirListas().toString().replace("[", "");
        x1= x1.replace("]", "");
        return x1;
    }
    private static void guardarpdf(String content) throws IOException {
        StringTokenizer tokens = new StringTokenizer(content);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append(" ").append(tokens.nextToken());
        }
        String[] parts = buff.toString().trim().split(" ");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/datos/inter4.txt")))) {
            for(String val: parts){
                writer.append(val+ ","+"\n");
            }
        }
    }
    
    private static String modificarCaracter(String part) {
        StringBuilder buff = new StringBuilder();
        buff.append(part);
        String palabra = buff.toString();
        String letraIngresada = "-";
        int i= buff.indexOf(letraIngresada);
        String comp = palabra.substring(i+1,i+2);
//        String comp2= palabra.substring(i-1,i-2);
        String expression = "^[a-zA-Z0-9]*$";
  //      CharSequence inputStr2 = comp2;
        CharSequence inputStr = comp;
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr);
    //    Matcher matcher3 = pattern1.matcher(inputStr2);
        if (matcher1.find()) {
            int j= buff.indexOf(letraIngresada);
            String comp1 = palabra.substring(j+2,j+3);
            String expression1 = "^[a-zA-Z0-9]*$";
            CharSequence inputStr1 = comp1;
            Pattern pattern2 = Pattern.compile(expression1);
            Matcher matcher2 = pattern2.matcher(inputStr1);
            if(matcher2.find()){
                // REMPLAZAR - POR (" ") CUAL LA SIGUIENTE DE UN CARACTER ES UN CARACTER
                buff.replace(j,j+1, " ");
            }else{
                // QUITAR - CUANDO EL SIGUIENTE ES UN CARCATER
                buff.delete(j,j+1);
            }
        }/*else if(!matcher3.find()){
            //ELIMINAMOS - SI EL ANTERIOR NO ES UN CARACTER
            buff.delete(i,i-2);
        }*/else{
            //QUITAR - CUANDO EL SIGUIENTE ES VACIO
            buff.delete(i,i+2);
        }
        return buff.toString();
    }

    private static void modificarCaracter1(String pal) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/datos/inter2.txt"))); BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File("src/datos/inter6.txt")))) {
            StringTokenizer tokens = new StringTokenizer(pal);
            StringBuilder buff = new StringBuilder();
            while (tokens.hasMoreTokens()) {
                buff.append(" ").append(tokens.nextToken());
            }
            String[] parts = buff.toString().trim().split(" ");
            for(String val: parts){
                if(!val.contains("http") || !val.contains("http")){
                    writer.append(modificarCaracter(val).replaceAll("[!#^/,.:“”•\"%&();=¿?@_{}>’<$\\|»«‘∗—/]", "")+"\n");
                }else if(val.contains("http") || val.contains("http")){
                    writer1.append(val+"\n");
                }else{
                    //Sin modificar para esta linea
                    writer.append(val+"\n");
                }
            }
            writer.close();
        }
    }
    
    public static ArrayList<String> unirListas() throws FileNotFoundException, IOException{ 
        List<String> listTxt =  Files.readAllLines(Paths.get("src/datos/inter1.txt"), StandardCharsets.UTF_8); 
        List<String> listTxt1 =  Files.readAllLines(Paths.get("src/datos/inter2.txt"), StandardCharsets.UTF_8); 
        String listTxt2 = Arrays.toString(listTxt.toArray(new String[listTxt.size()]));
        String listTxt3 = Arrays.toString(listTxt1.toArray(new String[listTxt1.size()]));
        ArrayList<String> listTxt4 = new ArrayList<>();
        
        String[] a = listTxt2.split(",");
        String[] b = listTxt3.split(",");
                
        listTxt4.addAll(Arrays.asList(a));        
        listTxt4.addAll(Arrays.asList(b));

        return listTxt4;
    }
}
