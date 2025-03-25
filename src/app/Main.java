package app;

import java.util.Scanner;

// Головний клас програми
public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = getBalance(); // Отримання початкового балансу
        validateAmount(balance, getAmount());
    }

    // Метод для отримання балансу
    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    // Метод для введення суми покупки
    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) { // Перевірка на недостатню кількість коштів
            try {
                throw new FundsException("Insufficient funds!"); // Генерація винятку
            } catch (FundsException ex) {
                System.out.println(ex.getMessage()); // Виведення повідомлення про помилку
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
    }

    /* Метод розрахунку наявних коштів на рахунку
     після зняття певної суми коштів*/
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal; // Повернення нового балансу
    }
}