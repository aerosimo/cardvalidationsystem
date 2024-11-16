/******************************************************************************
 * This piece of work is to enhance cardvalidationsystem project functionality.
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ValidateCardTest.java                                           *
 * Created:   20/10/2024, 22:55                                               *
 * Modified:  20/10/2024, 22:55                                               *
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

import com.aerosimo.ominet.impl.ValidateCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateCardTest {

    static String actual;
    static String expected;

    @Test
    @DisplayName("Validating VISA Card Number")
    void verifyVISACardNumber() {
        expected = "true";
        actual = ValidateCard.verify("4916801905619884").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating VISA Card IIN")
    void verifyVISACardType() {
        expected = "Visa";
        actual = ValidateCard.verify("4916801905619884").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating MasterCard Card Number")
    void checkMasterCardCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("5193347091529678").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating MasterCard Card IIN")
    void checkMasterCardCardType() {
        expected = "MasterCard";
        actual = ValidateCard.verify("5193347091529678").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating American Express Card Number")
    void checkAMEXCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("348235854897579").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating American Express Card IIN")
    void checkAMEXCardType() {
        expected = "American Express";
        actual = ValidateCard.verify("348235854897579").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating JCB Card Number")
    void checkJCBCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("3553512923196850").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating JCB Card IIN")
    void checkJCBCardType() {
        expected = "JCB";
        actual = ValidateCard.verify("3553512923196850").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Discover Card Number")
    void checkDiscoverCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("6011643317673615").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Discover Card IIN")
    void checkDiscoverCardType() {
        expected = "Discover";
        actual = ValidateCard.verify("6011643317673615").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Voyager Card Number")
    void checkVoyagerCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("8699005612629079").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Voyager Card IIN")
    void checkVoyagerCardType() {
        expected = "Voyager";
        actual = ValidateCard.verify("8699005612629079").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating China UnionPay Number")
    void checkUnionPayCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("6250941006528599").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating China UnionPay Card IIN")
    void checkUnionPayCardType() {
        expected = "China UnionPay";
        actual = ValidateCard.verify("6221268807629548").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating DinersClub Number")
    void checkDinersClubCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("38999138953244").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating DinersClub Card IIN")
    void checkDinersClubCardType() {
        expected = "DinersClub";
        actual = ValidateCard.verify("38999138953244").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating UATP Number")
    void checkUATPCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("112583326236387").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating UATP Card IIN")
    void checkUATPCardType() {
        expected = "UATP";
        actual = ValidateCard.verify("112583326236387").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Dankort Number")
    void checkDankortCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("5019717010103742").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Dankort Card IIN")
    void checkDankortCardType() {
        expected = "Dankort";
        actual = ValidateCard.verify("5019368793005259").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating InterPayment Number")
    void checkInterPaymentCardNumber() {
        expected = "true";
        actual = ValidateCard.verify("6366801905619884").getValid();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating InterPayment Card IIN")
    void checkInterPaymentCardType() {
        expected = "InterPayment";
        actual = ValidateCard.verify("6366801905619884").getCardType();
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }
}