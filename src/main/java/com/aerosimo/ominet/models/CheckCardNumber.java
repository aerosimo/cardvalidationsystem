/******************************************************************************
 * This piece of work is to enhance cardvalidationsystem project functionality.
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CheckCardNumber.java                                            *
 * Created:   20/10/2024, 20:47                                               *
 * Modified:  20/10/2024, 20:47                                               *
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

package com.aerosimo.ominet.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckCardNumber {

    private static final Logger log;

    static {
        log = LogManager.getLogger(CheckCardNumber.class.getName());
    }

    /**
     * Validates a given credit card number using the Luhn algorithm.
     *
     * @param cardNumber The credit card number as a String.
     * @return true if the card number is valid according to the Luhn algorithm, false otherwise.
     */

    public static boolean checkCardNumber(String cardNumber) {
        // Check if the card number is null or empty
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }

        // Check if the card number contains only digits
        if (!cardNumber.matches("\\d+")) {
            return false;
        }

        // Reverse the card number and convert to character array
        char[] cardDigits = new StringBuilder(cardNumber).reverse().toString().toCharArray();
        int sum = 0;

        for (int i = 0; i < cardDigits.length; i++) {
            int digit = Character.getNumericValue(cardDigits[i]);

            // Double every second digit (i.e., digits at odd indices)
            if (i % 2 == 1) {
                digit *= 2;
                // If the result is greater than 9, subtract 9
                if (digit > 9) {
                    digit -= 9;
                }
            }

            // Sum all the digits
            sum += digit;
        }

        // A valid card number will have a total sum that is a multiple of 10
        return sum % 10 == 0;
    }
}