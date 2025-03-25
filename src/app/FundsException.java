
// Клас для кастомного винятку
package app;

public class FundsException extends Exception { //Наслідування від Exception

    public FundsException(String message) {
        super(message);
    }
}