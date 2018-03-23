package test.tom.be.fundamentals;

public class TomsLogger {

    public static void doLog (String toLog)
    {
        System.out.println( TomsLogger.class.getName() + " - " + toLog);
    }
}
