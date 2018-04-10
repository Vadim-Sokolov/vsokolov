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
        int position = 0;
        int p1 = 0;
        int size = 0;
        int[] target = new int[4];
        for (int i = 0; i < coins.length; i++) {
            p1 = change / coins[i];
            change -= p1 * coins[i];
            target[position++] = p1;
            size += p1;
        }
        int[] result = new int[size];
        int position1 = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i]; j++) {
                result[position1++] = coins[i];
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
