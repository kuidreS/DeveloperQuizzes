package vserdiuk.tech.test.entity;

import nl.garvelink.iban.IBAN;
import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.exception.NotEnoughMoneyAccountException;
import vserdiuk.tech.test.util.ApplicationUtil;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

/**
 * Created by vserdiuk on 7/26/18
 */

public class Account {

    private IBAN iban; // The International Bank Account Number
    private Currency currency; // The account currency
    private Person owner; // The account owner (bank customer)
    private BigDecimal balance;
    private AccountActivity accountActivity; // The account has several activity options: ACTIVE, BLOCKED, FROZEN, CANCELED

    public Account(AccountBuilder builder) {
        this.iban = builder.iban;
        this.currency = builder.currency;
        this.owner = builder.owner;
        this.balance = builder.balance;
        this.accountActivity = builder.accountActivity;
    }

    public void addMoney(BigDecimal moneyAmount) throws AccountOperationsNotAvailable {
        boolean isAddPossible = ApplicationUtil.getAccountAvailability(this.accountActivity);
        if (isAddPossible) {
            this.balance = this.balance.add(moneyAmount);
        } else {
            throw new AccountOperationsNotAvailable("Account operations are not available. The account is " + this.accountActivity);
        }
    }

    public void withdrawMoney(BigDecimal moneyAmount) throws NotEnoughMoneyAccountException, AccountOperationsNotAvailable {
        boolean isWithdrawPossible = ApplicationUtil.getWithdrawPermission(this.accountActivity);
        if (isWithdrawPossible) {
            if (moneyAmount.compareTo(this.balance) == 1 || moneyAmount.compareTo(this.balance) == 0) {
                this.balance = this.balance.subtract(moneyAmount);
            } else {
                throw new NotEnoughMoneyAccountException("Not enough money on the account");
            }
        } else {
            throw new AccountOperationsNotAvailable("Account operations are not available. The account is " + this.accountActivity);
        }
    }

    public IBAN getIban() {
        return iban;
    }

    public void setIban(IBAN iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() throws AccountOperationsNotAvailable {
        boolean isAccountAvailable = ApplicationUtil.getAccountAvailability(this.accountActivity);
        if (isAccountAvailable) {
            return balance;
        } else {
            throw new AccountOperationsNotAvailable("Account operations are not available. The account is " + this.accountActivity);
        }
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountActivity getAccountActivity() {
        return accountActivity;
    }

    public void setAccountActivity(AccountActivity accountActivity) {
        this.accountActivity = accountActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(iban, account.iban) &&
                Objects.equals(currency, account.currency) &&
                Objects.equals(owner, account.owner) &&
                Objects.equals(balance, account.balance) &&
                accountActivity == account.accountActivity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(iban, currency, owner, balance, accountActivity);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban=" + iban +
                ", currency=" + currency +
                ", owner=" + owner +
                ", balance=" + balance +
                ", accountActivity=" + accountActivity +
                '}';
    }

    public static class AccountBuilder {
        private IBAN iban;
        private Currency currency = ApplicationUtil.getCurrency(this.iban);
        private Person owner;
        private BigDecimal balance = BigDecimal.ZERO;
        private AccountActivity accountActivity;

        public AccountBuilder setIban(IBAN iban) {
            this.iban = iban;
            return this;
        }

        public AccountBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public AccountBuilder setOwner(Person owner) {
            this.owner = owner;
            return this;
        }

        public AccountBuilder setBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder setAccountActivity(AccountActivity accountActivity) {
            this.accountActivity = accountActivity;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

}
