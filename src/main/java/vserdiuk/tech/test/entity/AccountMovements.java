package vserdiuk.tech.test.entity;

import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;
import vserdiuk.tech.test.exception.NotEnoughMoneyAccountException;

import java.math.BigDecimal;

/**
 * Created by vserdiuk on 7/26/18
 */

public interface AccountMovements {

    void addMoney(BigDecimal moneyAmount) throws AccountOperationsNotAvailable;

    void withdrawMoney(BigDecimal moneyAmount) throws NotEnoughMoneyAccountException, AccountOperationsNotAvailable;

    BigDecimal getBalance() throws AccountOperationsNotAvailable;

}
