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
package com.gd.creditcard.tlv.utils;

/**
 *
 * @author Julio Chinchilla
 */
public class EMVTags {
    
    public final static byte[] AcquirerIdentifier                   =   {(byte)0x9F,(byte)0x01};
    public final static byte[] AdditionalTerminalCapabilities       =   {(byte)0x9F,(byte)0x40};
    public final static byte[] AmountAuthorisedBIN                  =   {(byte)0x81};
    public final static byte[] AmountAuthorisedNUM                  =   {(byte)0x9F,(byte)0x02};
    
    public final static byte[] CardHolderName                       =   {(byte)0x5F,(byte)0x20};
    public final static byte[] Track1DiscretionaryData              =   {(byte)0x9F,(byte)0x1F};
    public final static byte[] ApplicationPreferredName             =   {(byte)0x9F,(byte)0x12};
    public final static byte[] ApplicationPriorityIndicator         =   {(byte)0x87};
    
}
