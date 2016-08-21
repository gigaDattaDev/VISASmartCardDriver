/* 
 * Version 2.0 Revision 1
 * 
 * 01/03/2014
 *
 * Copyright 2013-2016 gigaDatta, S.A.
 * Julio Francisco Chinchilla Valenzuela - gigadatta@gmail.com
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.gd.creditcard.entitys;

/**
 *
 * @author Julio Chinchilla
 */
public abstract class CreditCard {
    
    private String atr;
    private String number;
    private String name;
    private String dateExpiration;
    private String paySys;
    private String issuerData;

    public String getAtr() {
        return atr;
    }

    public void setAtr(String atr) {
        this.atr = atr;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getPaySys() {
        return paySys;
    }

    public void setPaySys(String paySys) {
        this.paySys = paySys;
    }

    public String getIssuerData() {
        return issuerData;
    }

    public void setIssuerData(String issuerData) {
        this.issuerData = issuerData;
    } 
    
}