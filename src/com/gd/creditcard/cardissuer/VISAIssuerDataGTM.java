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
package com.gd.creditcard.cardissuer;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Julio Chinchilla
 */
public class VISAIssuerDataGTM {
    

    
    public final Map<Short, String> IssuerData = new TreeMap<>();
    
    public VISAIssuerDataGTM() {
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x17,(byte)0xB1}).getShort(), "BANCO INDUSTRIAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x06,(byte)0x1B}).getShort(), "BANRURAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x18,(byte)0x60}).getShort(), "BANRURAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x18,(byte)0x64}).getShort(), "BANRURAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x08,(byte)0x8B}).getShort(), "BANRURAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x17,(byte)0xAE}).getShort(), "G&T CONTINENTAL");
        IssuerData.put(ByteBuffer.wrap(new byte[] {(byte)0x15,(byte)0x19}).getShort(), "BANTRAB");
    }
    
}
