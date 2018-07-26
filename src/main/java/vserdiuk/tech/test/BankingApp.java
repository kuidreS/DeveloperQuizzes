package vserdiuk.tech.test;

import nl.garvelink.iban.IBAN;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by vserdiuk on 7/26/18
 */

public class BankingApp {
    public static void main(String[] args) {
        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b2 = BigDecimal.TEN;

        boolean isLessOrEquals = false;
        if (b2.compareTo(b1) == 1 || b2.compareTo(b1) == 0) {
            isLessOrEquals = true;
        }

        System.out.println(isLessOrEquals);
    }
}
