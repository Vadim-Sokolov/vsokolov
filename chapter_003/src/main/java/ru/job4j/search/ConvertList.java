package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ConvertList {

    /**
     * Method takes list of arrays and adds all elements to a list
     * @param list - list to be converted
     * @return List<Integer> - result
     */
    public List<Integer> convert(List<int[]> list){
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int a : arr) {
                result.add(a);
            }
        }
        return result;
    }
    /**
     * Method takes a two dimentional array of int,
     * and converts them to a List<Integer>
     * @param array - array to be converted
     * @return List<Integer>
     */

    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : array) {
            for (int a : arr) {
                result.add(a);
            }
        }
        return result;
    }
    /**
     * Method takes a list of Integers, and a number of rows
     * and converts them to a two dimentional array.
     * Left over positions are filled with zeros.
     * @param list - List to be converted
     * @param rows - number of rows to be filled
     * @return int[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int secondSize = size / rows;
        secondSize = size % rows == 0 ? secondSize : secondSize + 1;
        int[][] result = new int[rows][secondSize];
        int position = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < secondSize; j++) {
                if (position < size) {
                    result[i][j] = list.get(position++);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}
