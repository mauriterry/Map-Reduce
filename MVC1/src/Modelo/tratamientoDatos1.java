/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author MaRu
 */
class tratamientoDatos1 {

    public static String guardarPdf(String content) throws IOException {
        String text = String.join(",", content);
        StringTokenizer tokens = new StringTokenizer(text);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append("").append(tokens.nextToken());
        }
        return buff.toString().trim();
    }
    
}
