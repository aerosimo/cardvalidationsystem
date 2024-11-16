/******************************************************************************
 * This piece of work is to enhance cardvalidationsystem project functionality.
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CardValidatorSOAPService.java                                   *
 * Created:   20/10/2024, 20:29                                               *
 * Modified:  20/10/2024, 20:29                                               *
 *                                                                            *
 * Copyright (c)  2024.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.api;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aerosimo.ominet.dto.CardResult;
import com.aerosimo.ominet.impl.ValidateCard;

@WebService(name = "CardValidator", serviceName = "CardValidatorService",
        portName = "ValidateCardPort", targetNamespace = "https://aerosimo.com/api/ws/cardvalidator")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CardValidatorSOAPService {

    private static final Logger log;

    static {
        log = LogManager.getLogger(CardValidatorSOAPService.class.getName());
    }

    @WebMethod(operationName = "validateCard")
    @WebResult(name = "cardNetwork", partName = "validateCardResponse")
    public CardResult validateCard(@XmlElement(required = true) @WebParam(name = "CardLongNumber",
            partName = "validateCardRequest") String CardLongNumber) {

        return ValidateCard.verify(CardLongNumber.replaceAll("-", ""));
    }
}