/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.CreditCard;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class CreditCardFactory {
    public static CreditCard getCreditCard(Map<String, String> details, BigDecimal balance, Date expiryDate) {
         CreditCard creditCard = new CreditCard();
         creditCard.setCreditNumber(details.get("number"));
         creditCard.setNameOnCreditCard(details.get("name"));
         creditCard.setBalance(balance);
         creditCard.setExpiryDate(expiryDate);
        return creditCard;
    }
}
