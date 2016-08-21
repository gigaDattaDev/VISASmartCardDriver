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

package com.gd.creditcard.visa;

import com.gd.creditcard.entitys.CreditCard;
import com.gd.creditcard.tlv.utils.EMVTags;
import com.gd.smartcard.SCardConexion;
import com.gd.utils.ByteConverts;
import com.gd.utils.ByteEngine;
import javax.smartcardio.ATR;

import javax.smartcardio.CardException;

/**
 *
 * @author Julio Chinchilla
 */
public final class VisaSCDataRead extends CreditCard {
    
    
    
    public VisaSCDataRead(int pcsc, String protocol) throws CardException, Exception {
        SCardConexion c = new SCardConexion();
        ATR atr = c.connect(pcsc, protocol);
        setAtr(com.gd.utils.ByteConverts.byteToHex(atr.getBytes()));
        VisaCardCheck checkVisa = new VisaCardCheck(atr);
        if (checkVisa.isVisaCard()) {
            setIssuerData(checkVisa.getIssuerData());
            c.transmit(APDU.VISA);
            byte[] visaData = c.transmit(APDU.RECORD0C).getData();
            c.transmit(APDU.PAYSYSDDF01);
            byte[] paySysData = c.transmit(APDU.RECORD0C).getData();
            scannData(visaData, paySysData);
        } else {
            throw new Exception("No es una tarjeta visa");
        }
    }
    
    public void scannData(byte[] visaData, byte[] paySysData) {
        setNumber(VisaNumberScanner(visaData));
        setDateExpiration(VisaDateExpireScanner(visaData));
        int cardHolderName = ByteEngine.find(visaData, EMVTags.CardHolderName);
        int trackData = ByteEngine.find(visaData, EMVTags.Track1DiscretionaryData);
        setName(ByteConverts.byteToASCII(visaData,cardHolderName+3,(trackData == -1)?visaData.length-1:trackData-3));
        setPaySys(PaySysScanner(paySysData));
    }
    
    private String PaySysScanner(byte[] paySysData) {
        int trackData = ByteEngine.find(paySysData, EMVTags.ApplicationPreferredName);
        int applIndicator = ByteEngine.find(paySysData, EMVTags.ApplicationPriorityIndicator);
        return ByteConverts.byteToASCII(paySysData,trackData+3,(trackData+3<applIndicator)?applIndicator-1:paySysData.length-1);
    }
    
    private String VisaNumberScanner (byte[] data) {
        String num = ByteConverts.byteToHex(data,4,11).replace(" ","");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            sb.append(num.charAt(i));
            if( ((i+1) % 4) == 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    private String VisaDateExpireScanner (byte[] data) {
        String d = ByteConverts.byteToHex(data,12,14).replace(" ","").substring(1, 5);
        String year = d.substring(0, 2);
        String month = d.substring(2,4);
        return month.concat("/").concat(year);
    }
    
}