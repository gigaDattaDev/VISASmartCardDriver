/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd;

import com.gd.creditcard.visa.VisaSCDataRead;
import javax.smartcardio.CardException;

/**
 *
 * @author Julio Chinchilla
 */
public class Test {


    public static void main(String[] args) throws CardException, Exception {
        VisaSCDataRead visa = new VisaSCDataRead(0,"*");
        System.out.println(visa.getAtr());
        System.out.println(visa.getIssuerData());
        System.out.println(visa.getNumber());
        System.out.println(visa.getName());
        System.out.println(visa.getDateExpiration());
        System.out.println(visa.getPaySys());
    }
    
}