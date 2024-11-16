/******************************************************************************
 * This piece of work is to enhance cardvalidationsystem project functionality.
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ValidateCard.java                                               *
 * Created:   15/11/2024, 20:48                                               *
 * Modified:  15/11/2024, 20:50                                               *
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

package com.aerosimo.ominet.impl;

import com.aerosimo.ominet.dto.CardResult;
import com.aerosimo.ominet.models.CheckCardNetwork;
import com.aerosimo.ominet.models.CheckCardNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ValidateCard class provides functionality to validate
 * credit card numbers using the Luhn algorithm and identify card types.
 */

public class ValidateCard {

    private static final Logger log;

    static {
        log = LogManager.getLogger(ValidateCard.class.getName());
    }

    static String isValid;
    static String cardType;
    static String message;

    public static CardResult verify(String CardLongNumber) {

        if (CardLongNumber == null || CardLongNumber.isEmpty()) {
            log.error("Schema Validation failed because cardLongNumber is a required field but it is empty");
            return new CardResult("false", "Unknown", "Card number is empty");
        } else if (CardLongNumber.length() <= 12 || CardLongNumber.length() > 19) {
            log.error("Schema Validation failed because cardLongNumber length is too short or too long");
            return new CardResult("false", "Unknown", "Card number is too short or too long");
        } else {
            isValid = String.valueOf(CheckCardNumber.checkCardNumber(CardLongNumber));
            cardType = CheckCardNetwork.checkCardType(CardLongNumber);
            if (isValid.contains("true")) {message = "Card is valid";}
            else {message = "Card number is not valid";}
            return new CardResult(isValid, cardType, message);
        }
    }
}