/*
 *  Copyright 2015-2020 WebPKI.org (http://webpki.org).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.webpki.saturn.common;

import java.io.IOException;

import java.security.GeneralSecurityException;

import java.util.GregorianCalendar;

import org.webpki.json.JSONAsymKeySigner;
import org.webpki.json.JSONObjectWriter;

import org.webpki.util.ISODateTime;

public class BalanceRequestEncoder implements BaseProperties {
    
    public static JSONObjectWriter encode(String recipientUrl,
                                          Currencies currency,
                                          String accountId,
                                          String credentialId,
                                          JSONAsymKeySigner signer) 
            throws IOException, GeneralSecurityException {
        return Messages.BALANCE_REQUEST.createBaseMessage()
            .setString(RECIPIENT_URL_JSON, recipientUrl)
            .setString(ACCOUNT_ID_JSON, accountId)
            .setString(CREDENTIAL_ID_JSON, credentialId)
            .setString(CURRENCY_JSON, currency.toString())
            .setDateTime(TIME_STAMP_JSON, new GregorianCalendar(), ISODateTime.LOCAL_NO_SUBSECONDS)
            .setSignature(REQUEST_SIGNATURE_JSON, signer);
    }
}
