package test.tom.be.fundamentals;

/**
 * Throwable
 *  - Error
 *  - Exception
 *    - normal Exception (checked Exception): must be caught
 *    - RuntimeException
 */


public class myException extends Exception {

    public myException(String message)
    {   super(message);
        TomsLogger.doLog(this.getClass().getName() + " is throwing an Exception..");

    }
}
