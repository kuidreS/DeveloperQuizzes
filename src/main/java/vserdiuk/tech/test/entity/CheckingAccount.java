package vserdiuk.tech.test.entity;

import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.exception.NotEnoughMoneyAccountException;
import vserdiuk.tech.test.exception.SumExeedsLimitException;
import vserdiuk.tech.test.util.ApplicationUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by vserdiuk on 7/26/18
 */

public class CheckingAccount extends Account {

    private BigDecimal limit;

    public CheckingAccount(CheckingAccountBuilder builder) {
        super(builder);
    }

    @Override
    public void withdrawMoney(BigDecimal moneyAmount) throws AccountOperationsNotAvailable {
        boolean isWithdrawPossible = ApplicationUtil.getWithdrawPermission(this.getAccountActivity());
        ApplicationUtil.withdrawWithLimit(isWithdrawPossible, moneyAmount, this);
    }

    public void transferMoney(CheckingAccount recipientAccount, BigDecimal amount) throws AccountOperationsNotAvailable {
        Transaction transaction = new Transaction
                .TransactionBuilder()
                .setUuid(UUID.randomUUID())
                .setAccountFrom(this)
                .setAccountTo(recipientAccount)
                .setAmount(amount)
                .setDate(LocalDateTime.now())
                .build();

        boolean isCurrentAccountAvailable = ApplicationUtil.getAccountAvailability(this.getAccountActivity());
        boolean isRecipientAccountAvailable = ApplicationUtil.getAccountAvailability(recipientAccount.getAccountActivity());

        if (isCurrentAccountAvailable && isRecipientAccountAvailable) {

            ApplicationUtil.withdrawWithLimit(isCurrentAccountAvailable, amount, this);

            BigDecimal updatedBalance = recipientAccount.getBalance().add(amount);
            recipientAccount.setBalance(updatedBalance);

            transaction.setStatus(TransactionStatus.OK);
        } else {
            if (isCurrentAccountAvailable && !isRecipientAccountAvailable) {
                transaction.setStatus(TransactionStatus.REFUND);
            } else {
                transaction.setStatus(TransactionStatus.NOK);
            }
        }
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(limit, that.limit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), limit);
    }

    @Override
    public String toString() {
        return super.toString() + "; CheckingAccount{" +
                "limit=" + limit +
                '}';
    }

    public static class CheckingAccountBuilder extends AccountBuilder {
        private BigDecimal limit;

        public CheckingAccountBuilder setLimit(BigDecimal limit) {
            this.limit = limit;
            return this;
        }

        public CheckingAccount build() {
            return new CheckingAccount(this);
        }
    }
}
