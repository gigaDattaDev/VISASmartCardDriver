package com.gd.smartcard.utils;

import javax.smartcardio.ATR;

/*
 * Version 1.0 Revision 1
 *
 * 18/08/2014
 *
 * Copyright 2014 bit502
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
 
 
 
/**
 *
 * @author Julio Chinchilla
 */
public class ATRVerify {
    
    /**
     * Función que recibe un objeto ATR separa los bytes T0 hasta TJ en
     * el byte array check, luego utiliza la función getXORCheckSumValue
     * para obtener la suma verificativa y lo compara con el byte TCK,
     * si los bytes coinciden la respuesta será true de lo contrario será
     * false, y el ATR a verificar estará incorrecto
     * @param atr ATR con espacios entre bytes
     * @return
     */
    public static boolean checkATR (ATR atr) {
        byte[] check = new byte[atr.getBytes().length-4];
        System.arraycopy(atr.getBytes(), 1, check, 0, check.length);
        return getXORCheckSumValue(check) == atr.getBytes()[atr.getBytes().length-1];
    }
 
    /**
     * Función que recibe un ATR en formato String con separador de espacio
     * entre cada byte, la función formatea la cadena de caracteres quitándole
     * los espacios en blanco, posteriormente separa los bytes T0 hasta TJ en
     * el String t0tj y separa el byte de comprobación final TCK, luego utiliza
     * la función getXORCheckSumValue para obtener la suma verificativa y lo
     * compara con el byte TCK, si los bytes coinciden la respuesta será true
     * de lo contrario será false, y el ATR a verificar estará incorrecto
     * @param atr ATR con espacios entre bytes
     * @return
     */
    public static boolean checkATRStrWS (String atr) {
        boolean resp = false;
        String t0tj = atr.replaceAll("\\s","");
        String tck = atr.substring(atr.length()-2, atr.length());
        t0tj = t0tj.substring(2, t0tj.length()-2);
        if (getXORCheckSumValue(t0tj).equals(tck))
            resp = true;
        return resp;
    }
 
    /**
     * Función que recibe un ATR en formato String con separador de espacio
     * entre cada byte, posteriormente separa los bytes T0 hasta TJ en
     * el String t0tj y separa el byte de comprobación final TCK, luego utiliza
     * la función getXORCheckSumValue para obtener la suma verificativa y lo
     * compara con el byte TCK, si los bytes coinciden la respuesta será true
     * de lo contrario será false, y el ATR a verificar estará incorrecto
     * @param atr ATR sin espacios entre bytes
     * @return
     */
    public static boolean checkATRStr (String atr) {
        boolean resp = false;
        String t0tj = atr.substring(2, atr.length()-2);;
        String tck = atr.substring(atr.length()-2, atr.length());
        if (getXORCheckSumValue(t0tj).equals(tck))
            resp = true;
        return resp;
    }
 
    /**
     * Función que realiza una suma de verificación a una cadena String en
     * formato Hexadecimal con el operador XOR
     * @param bytes Cadena String en formato hexadecimal a analizar
     * @see <a href="http://es.wikipedia.org/wiki/Suma_de_verificaci%C3%B3n"&gt;WikiES: Suma de verificación</a&gt;
     * @return String de comprobación mediante Suma de Verificación HEX
     */
    private static String getXORCheckSumValue (String bytes) {
        int cc = 0;
        for (int i = 0; i < bytes.length(); i=(i+2)) {
            if (i==0){
                cc = Integer.parseInt(bytes.substring(i, i+2), 16) & (0x00FF);
            } else {
                cc^=(Integer.parseInt(bytes.substring(i, i+2),16)&(0x00FF));
                cc=cc&(0x00FF);
            }
        }
        return Integer.toString(cc, 16).toUpperCase();
    }
    
    /**
     * Función que realiza una suma de verificación a una arreglo de bytes
     * utilizando el operador XOR
     * @param bytes Cadena String en formato hexadecimal a analizar
     * @see <a href="http://es.wikipedia.org/wiki/Suma_de_verificaci%C3%B3n"&gt;WikiES: Suma de verificación</a&gt;
     * @return String de comprobación mediante Suma de Verificación HEX
     */
    private static final byte getXORCheckSumValue(byte[] bytes) {
        byte sum = 0;
        for (byte b : bytes) {
            sum ^= b;
        }
        return sum;
    }
 
}