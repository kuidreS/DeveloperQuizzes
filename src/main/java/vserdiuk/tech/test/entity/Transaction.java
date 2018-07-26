package vserdiuk.tech.test.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by vserdiuk on 7/26/18
 */

public class Transaction {

    private UUID uuid;
    private CheckingAccount accountFrom;
    private CheckingAccount accountTo;
    private BigDecimal amount;
    private LocalDateTime date;
    private TransactionStatus status;

    public Transaction(TransactionBuilder builder) {
        this.uuid = builder.uuid;
        this.accountFrom = builder.accountFrom;
        this.accountTo = builder.accountTo;
        this.amount = builder.amount;
        this.date = builder.date;
        this.status = builder.status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public CheckingAccount getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(CheckingAccount accountFrom) {
        this.accountFrom = accountFrom;
    }

    public CheckingAccount getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(CheckingAccount accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(accountFrom, that.accountFrom) &&
                Objects.equals(accountTo, that.accountTo) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date) &&
                status == that.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, accountFrom, accountTo, amount, date, status);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid=" + uuid +
                ", accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", amount=" + amount +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public static class TransactionBuilder {
        private UUID uuid;
        private CheckingAccount accountFrom;
        private CheckingAccount accountTo;
        private BigDecimal amount;
        private LocalDateTime date;
        private TransactionStatus status;

        public TransactionBuilder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public TransactionBuilder setAccountFrom(CheckingAccount accountFrom) {
            this.accountFrom = accountFrom;
            return this;
        }

        public TransactionBuilder setAccountTo(CheckingAccount accountTo) {
            this.accountTo = accountTo;
            return this;
        }

        public TransactionBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public TransactionBuilder setDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder setStatus(TransactionStatus status) {
            this.status = status;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

}
