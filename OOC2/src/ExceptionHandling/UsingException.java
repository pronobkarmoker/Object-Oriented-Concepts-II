package ExceptionHandling;

public class UsingException {
    public static void main(String args[]) {
        try {
            // Call throwException to demonstrate stack unwinding
            throwException();
        } // end try
        catch (Exception exception) {
            // Exception thrown in throwException will be caught here
            System.err.println("Exception handled in main");
        } // end catch
    } // end main

    // throwException throws exception that is not caught in this method
    public static void throwException() throws Exception {
        try {
            System.out.println("Method throwException");
            throw new Exception(); // generate exception
        } // end try
        catch (RuntimeException runtimeException) {
            System.err.println("Exception handled in method throwException");
        } // end catch
        finally {
            System.err.println("Finally is always executed");
        } // end finally
    } // end method throwException
}
