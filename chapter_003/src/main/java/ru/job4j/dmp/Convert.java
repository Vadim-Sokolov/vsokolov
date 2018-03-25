package com;

// комментариев нет
import java.util.*;

public class Convert {

    //'{' is not preceded with whitespace.
    public Convert(){ // дефолтный конструктор не нужен

    }

    //Converts array to list
	// неправильный формат комментариев
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)//'for' construct must use '{}'s.
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    // неправильный формат комментариев
    public int[][] makeArray(List<Integer> list, int rws) { // назвать rows
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())//'if' construct must use '{}'s.
                    array[i][j] = iterator.next();
                else //'else' construct must use '{}'s.
                    array[i][j] = 0;
            }
        }
        return array;
    }
}