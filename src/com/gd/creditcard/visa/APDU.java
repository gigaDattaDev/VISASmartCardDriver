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

import javax.smartcardio.CommandAPDU;

/**
 *
 * @author Julio Chinchilla
 */
public class APDU {
    
     private static final byte[] Visa = {
        (byte)0x00, (byte)0xA4, (byte)0x04, (byte)0x00,
        (byte)0x07, (byte)0xA0, (byte)0x00, (byte)0x00,
        (byte)0x00, (byte)0x03, (byte)0x10, (byte)0x10
    };
    
    private static final byte[] Record0C = {
        (byte)0x00, (byte)0xB2, (byte)0x01, (byte)0x0C,
        (byte)0x00
    };
    
    private static final byte[] PaySysDDF01 = {
        (byte)0x00, (byte)0xA4, (byte)0x04, (byte)0x00,
        (byte)0x0E, (byte)0x31, (byte)0x50, (byte)0x41,
        (byte)0x59, (byte)0x2E, (byte)0x53, (byte)0x59,
        (byte)0x53, (byte)0x2E, (byte)0x44, (byte)0x44,
        (byte)0x46, (byte)0x30, (byte)0x31
    };
    
    public static final CommandAPDU VISA = new CommandAPDU(Visa);
    public static final CommandAPDU PAYSYSDDF01 = new CommandAPDU(PaySysDDF01);
    public static final CommandAPDU RECORD0C = new CommandAPDU(Record0C);
    
}
