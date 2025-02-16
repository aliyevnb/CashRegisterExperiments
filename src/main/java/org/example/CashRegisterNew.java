package org.example;

import java.util.Scanner;

public class CashRegisterNew {

    public static double calculateChange(double paidAmmount, double owedAmmount) {
        return Math.round((paidAmmount - owedAmmount) * 100.0) / 100.0;
    }

    public static int calculateBillsOrCoins(int ammount, int denomination){
        return ammount / denomination;
    }

    public static int remainingAmount(int ammount, int denomination){
        return ammount % denomination;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.print("Bill total: ");
        double total = scanner.nextDouble();
        System.out.print("Customer paid: ");
        double paid = scanner.nextDouble();
        scanner.close();

        // Calculate change and breakdown into dollars and cents
        double change = calculateChange(paid, total);
        int dollars = (int) change;
        int cents = (int) ((change - dollars) * 100);

        // Define denominations for banknotes and coins
        int[] banknotes = {100, 50, 20, 10, 5, 1};
        int[] coins = {25, 10, 5, 1}; // Quarter, Dime, Nickel, Penny
        String[] banknoteNames = {"100 Dollar bill(s)",
                "50 Dollar bill(s)",
                "20 Dollar bill(s)",
                "10 Dollar bill(s)",
                "5 Dollar bill(s)",
                "1 Dollar bill(s)"};
        String[] coinNames = {"Quarter(s)",
                "Dime(s)",
                "Nickel(s)",
                "Penny(ies)"};

        // Display change breakdown
        System.out.println("\nChange to customer: $" + change);
        System.out.println("-----------");

        // Calculate banknotes
        for (int i = 0; i < banknotes.length; i++) {
            int count = calculateBillsOrCoins(dollars, banknotes[i]);
            dollars = remainingAmount(dollars, banknotes[i]);
            if (count > 0) {
                System.out.println(banknoteNames[i] + ": " + count);
            }
        }

        // Calculate coins
        for (int i = 0; i < coins.length; i++) {
            int count = calculateBillsOrCoins(cents, coins[i]);
            cents = remainingAmount(cents, coins[i]);
            if (count > 0) {
                System.out.println(coinNames[i] + ": " + count);
            }
        }
    }
}
