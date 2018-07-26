package vserdiuk.tech.test;

import nl.garvelink.iban.IBAN;
import vserdiuk.tech.test.entity.Account;
import vserdiuk.tech.test.entity.AccountActivity;
import vserdiuk.tech.test.entity.Address;
import vserdiuk.tech.test.entity.Person;
import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.exception.NotEnoughMoneyAccountException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by vserdiuk on 7/26/18
 */

public class BankingApp {
    public static void main(String[] args) throws AccountOperationsNotAvailable, NotEnoughMoneyAccountException {

        Address address = new Address.AddressBuilder()
                .setCountry("SomeCountry")
                .setCity("SomeCity")
                .setBuildingNumber("1A")
                .build();
        Person person = new Person.PersonBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setBirthday(LocalDate.of(1991, 1, 2))
                .setAddress(address)
                .setPersonalIdNumber(1234567890l)
                .build();

        IBAN iban = IBAN.valueOf( "NL91ABNA0417164300" );
        Account account = new Account.AccountBuilder()
                .setOwner(person)
                .setIban(iban)
                .setAccountActivity(AccountActivity.ACTIVE)
                .setBalance(BigDecimal.valueOf(1234.5))
                .build();
        System.out.println("Current account balance = " + account.getBalance());

        account.addMoney(BigDecimal.valueOf(9876.5));
        System.out.println("Account balance after adding money = " + account.getBalance());



    }
}
