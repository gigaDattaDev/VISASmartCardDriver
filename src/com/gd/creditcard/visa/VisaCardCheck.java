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

import com.gd.creditcard.cardissuer.VISAIssuerDataGTM;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.smartcardio.ATR;

/**
 *
 * @author Julio Chinchilla
 */
public class VisaCardCheck {
    
    private final boolean visaCard;
    private final String issuerData;
    
    public VisaCardCheck(ATR atr) {
        this.visaCard = checkVisaCard(atr);
        this.issuerData = this.IssuerData(atr);
    }
    
    private boolean checkVisaCard(ATR atr) {
        byte[] ATRT00 = new byte[9];
        System.arraycopy(atr.getBytes(), 0, ATRT00, 0, ATRT00.length);
        return Arrays.equals(ATRT00, VISA.ATR);
    }
    
    private String IssuerData(ATR atr) {
        byte[] cardIssuerData = new byte[2];
        System.arraycopy(atr.getBytes(), 9, cardIssuerData, 0, cardIssuerData.length);
        VISAIssuerDataGTM issgt = new VISAIssuerDataGTM();
        return issgt.IssuerData.get(ByteBuffer.wrap(cardIssuerData).getShort());
    }

    public boolean isVisaCard() {
        return visaCard;
    }

    public String getIssuerData() {
        return issuerData;
    }

}