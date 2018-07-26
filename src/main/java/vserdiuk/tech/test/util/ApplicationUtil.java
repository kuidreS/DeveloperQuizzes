package vserdiuk.tech.test.util;

import nl.garvelink.iban.IBAN;
import vserdiuk.tech.test.entity.Account;
import vserdiuk.tech.test.entity.AccountActivity;
import vserdiuk.tech.test.entity.CheckingAccount;
import vserdiuk.tech.test.entity.InterestRate;
import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.exception.SumExeedsLimitException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by vserdiuk on 7/26/18
 */

public class ApplicationUtil {

    public static Currency getCurrency(IBAN iban) {
        String countryCode = iban.getCountryCode();
        Locale ibanLocale = null;
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            if (locale.getCountry().toLowerCase().equals(countryCode.toLowerCase())) {
                ibanLocale = locale;
                break;
            }
        }
        return Currency.getInstance(ibanLocale);
    }

    public static boolean getWithdrawPermission(AccountActivity accountActivity) {
        if (accountActivity.equals(AccountActivity.ACTIVE)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getAccountAvailability (AccountActivity accountActivity) {
        if (accountActivity.equals(AccountActivity.ACTIVE) || accountActivity.equals(AccountActivity.BLOCKED)) {
            return true;
        } else {
            return false;
        }
    }

    public static void withdrawWithLimit(boolean isWithdrawPossible, BigDecimal amount, CheckingAccount account) throws AccountOperationsNotAvailable {
        if (isWithdrawPossible && (amount.compareTo(account.getLimit()) == -1 || amount.compareTo(account.getLimit()) == 0)) {
            BigDecimal updatedBalance = account.getBalance().subtract(amount);
            account.setBalance(updatedBalance);
        } else {
            try {
                throw new SumExeedsLimitException("The sum (" + amount + ") exeeds the limit equals to " + account.getLimit());
            } catch (SumExeedsLimitException e) {
                e.printStackTrace();
            }
        }
    }

}
