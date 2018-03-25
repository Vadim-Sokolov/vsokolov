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
        int tenCoins = change / 10;
        int remainderBy10 = change - 10 * tenCoins;
        int fiveCoins = remainderBy10 / 5;
        int remainderBy5 = remainderBy10 - 5 * fiveCoins;
        int twoCoins = remainderBy5 / 2;
        int remainderBy2 = remainderBy5 - 2 * twoCoins;
        int oneCoins = remainderBy2;
        int[] target = {tenCoins, fiveCoins, twoCoins, oneCoins};
        int size = 0;
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
