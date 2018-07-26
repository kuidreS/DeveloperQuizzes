package vserdiuk.tech.test.entity;

import java.util.Objects;

/**
 * Created by vserdiuk on 7/26/18
 */

public class InterestRate {

    private SavingPeriod savingPeriod;
    private double rate;

    public InterestRate(SavingPeriod savingPeriod, double rate) {
        this.savingPeriod = savingPeriod;
        this.rate = rate;
    }

    public SavingPeriod getSavingPeriod() {
        return savingPeriod;
    }

    public void setSavingPeriod(SavingPeriod savingPeriod) {
        this.savingPeriod = savingPeriod;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestRate that = (InterestRate) o;
        return Double.compare(that.rate, rate) == 0 &&
                savingPeriod == that.savingPeriod;
    }

    @Override
    public int hashCode() {

        return Objects.hash(savingPeriod, rate);
    }

    @Override
    public String toString() {
        return "InterestRate{" +
                "savingPeriod=" + savingPeriod +
                ", rate=" + rate +
                '}';
    }
}
