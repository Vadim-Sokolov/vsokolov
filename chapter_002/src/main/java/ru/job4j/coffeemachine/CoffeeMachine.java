package ru.job4j.coffeemachine;

public class CoffeeMachine {

    private final int[] coins = new int[] {10, 5, 2, 1};
    /**
     * Method calculates the change to be returned
     * and the coin composition to be dispensed.
     * @param value - the note inserted into the machine
     * @param price - the price of the coffee
     * @return array of coin values
     */
    public int[] change(int value, int price) {
        int change = value - price;
        int[] target = new int[4];
        int number;
        int size = 0;
        for (int i = 0; i < coins.length; i++) {
            number = change / coins[i];
            target[i] = number * coins[i];
            change -= number * coins[i];
        }

        for (int i : target) {
            if (i != 0) {
                size++;
            }
        }
        int[] result = new int[size];
        int position = 0;
        for (int i : target) {
            if (i != 0) {
                result[position++] = i;
            }
        }
        return result;
    }
    /**
     * Method checks whether the customer has inserted enough
     * money to buy the drink.
     * @return
     */
    public boolean isEnough(int value, int price) {
        return value >= price;
    }
}
