package vserdiuk.tech.test.exception;

/**
 * Created by vserdiuk on 7/26/18
 */

public class NotEnoughMoneyAccountException extends Exception {

    public NotEnoughMoneyAccountException(String message) {
        super(message);
    }

}
