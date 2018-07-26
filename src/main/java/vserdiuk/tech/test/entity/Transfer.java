package vserdiuk.tech.test.entity;

import vserdiuk.tech.test.exception.AccountOperationsNotAvailable;

import java.math.BigDecimal;

/**
 * Created by vserdiuk on 7/26/18
 */

public interface Transfer {

    void transferMoney(CheckingAccount recipientAccount, BigDecimal amount) throws AccountOperationsNotAvailable;

}
