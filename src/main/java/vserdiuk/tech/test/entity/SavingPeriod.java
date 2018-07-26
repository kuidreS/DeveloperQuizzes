package vserdiuk.tech.test.entity;

/**
 * Created by vserdiuk on 7/26/18
 */

public enum SavingPeriod {

    ANNUAL(12),
    THREE_MONTHS(3),
    SIX_MONTHS(6);

    private int months;

    public int getMonths() {
        return months;
    }

    SavingPeriod(int months) {
        this.months = months;
    }
}
