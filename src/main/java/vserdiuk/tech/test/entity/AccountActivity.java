package vserdiuk.tech.test.entity;

/**
 * Created by vserdiuk on 7/26/18
 */

/*
* ACTIVE - All operations are available to the account owner.
*
* BLOCKED - The account owner has a possibility only to get balance info and add money to account
* (e.g. The card was stolen. The owner could add money to the account but has temporary no possibility to withdraw manoy). There is no possibility to withdraw money.
*
* FROZEN - Account could be frozen by POLICE or court. All transactions are forbidden.
*
* CANCELED - All transactions are forbidden. The status is for the Bank statistics.
* */
public enum AccountActivity {
    ACTIVE,
    BLOCKED,
    FROZEN,
    CANCELED
}
