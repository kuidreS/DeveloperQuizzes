package vserdiuk.tech.test.exception;

/**
 * Created by vserdiuk on 7/26/18
 */

public class AccountOperationsNotAvailable extends Exception {

    public AccountOperationsNotAvailable(String message) {
        super(message);
    }

}
