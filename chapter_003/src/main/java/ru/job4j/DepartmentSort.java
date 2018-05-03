package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */

public class DepartmentSort {

    private String[] departments;

    public DepartmentSort(String[] departments) {
        this.departments = departments;
    }
    /**
     * Method sorts and array of Strings
     * by converting it to a TreeSet.
     * @param departments - array to be sorted
     * @return the result
     */
    public TreeSet<String> sort(String[] departments) {
        TreeSet<String> result = new TreeSet<>();
        for (String s : departments) {
            result.add(s);
        }
        return result;
    }
    /**
     * Method reverse-sorts and array of Strings
     * by converting it to a TreeSet and using descendingSet() method on it.
     * @param departments - array to be sorted
     * @return the result
     */
    public TreeSet<String> reverseSort(String[] departments) {
        return (TreeSet<String>) sort(departments).descendingSet();
    }
    /**
     * Method fills in missing departments into the given TreeSet
     * by identifying and adding the appropriate substrings.
     * @param target - TreeSet to be filled
     * @return the result
     */
    public TreeSet<String> fillMissingDepartments(TreeSet<String> target) {
        TreeSet<String> result = new TreeSet<>();
        for (String s : target) {
            String[] parts = s.split("\\\\");
            List<String> missing = new ArrayList<>();
            missing.add(parts[0]);
            for (int i = 1; i < parts.length - 1; i++) {
               String fill = missing.get(i - 1) + "\\" + parts[i];
               missing.add(fill);
            }
            for (String s1 : missing) {
                result.add(s1);
            }
        }
        result.addAll(target);
        return result;
    }
}
