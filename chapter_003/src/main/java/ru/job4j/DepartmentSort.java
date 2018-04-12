package ru.job4j;

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
        TreeSet<String> missing1 = new TreeSet<>();
        TreeSet<String> missing2 = new TreeSet<>();
        for (String s : target) {
            if (s.length() >= 2) {
                missing1.add(s.substring(0, 2));
            }
        }
        for (String s : target) {
            if (s.length() >= 6) {
                missing2.add(s.substring(0, 6));
            }
        }
        result.addAll(target);
        result.addAll(missing1);
        result.addAll(missing2);
        return result;
    }
}
