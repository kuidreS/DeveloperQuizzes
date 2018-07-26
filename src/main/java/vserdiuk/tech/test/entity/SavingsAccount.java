package vserdiuk.tech.test.entity;

import nl.garvelink.iban.IBAN;
import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.util.ApplicationUtil;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

/**
 * Created by vserdiuk on 7/26/18
 */

public class SavingsAccount extends Account{

    private InterestRate interestRate;

    public SavingsAccount(SavingsAccountBuilder builder) {
        super(builder);
        this.interestRate = builder.interestRate;
    }

    public void payInterestsToAccountOwner() {
        try {
            if (super.getAccountActivity().equals(AccountActivity.ACTIVE) && super.getBalance().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal percentageMoneyValue = super.getBalance().multiply(BigDecimal.valueOf(interestRate.getRate())).divide(BigDecimal.valueOf(100));
                BigDecimal updatedBalance = super.getBalance().add(percentageMoneyValue);
                super.setBalance(updatedBalance);
            }
        } catch (AccountOperationsNotAvailable accountOperationsNotAvailable) {
            accountOperationsNotAvailable.printStackTrace();
        }
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(InterestRate interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), interestRate);
    }

    @Override
    public String toString() {
        return super.toString() + "; SavingsAccount{" +
                "interestRate=" + interestRate +
                '}';
    }

    public static class SavingsAccountBuilder extends AccountBuilder{
        private InterestRate interestRate;

        public SavingsAccountBuilder setInterestRate(InterestRate interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public SavingsAccount build() {
            return new SavingsAccount(this);
        }
    }

}
