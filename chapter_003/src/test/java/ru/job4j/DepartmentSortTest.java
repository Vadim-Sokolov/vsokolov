package ru.job4j;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class DepartmentSortTest {

    @Test
    public void sortTest() {
        String[] departments = {"K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1",
                "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2"};
        DepartmentSort ds = new DepartmentSort(departments);
        TreeSet<String> ts = new TreeSet<>();
        ts.add("K2\\SK1\\SSK1");
        ts.add("K2\\SK1\\SSK2");
        ts.add("K1\\SK1");
        ts.add("K1\\SK2");
        ts.add("K1\\SK1\\SSK1");
        ts.add("K1\\SK1\\SSK2");
        ts.add("K2");
        assertThat(ds.sort(departments), is(ts));
    }

    @Test
    public void reverseSortTest() {
        String[] departments = {"K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1",
                "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2"};
        DepartmentSort ds = new DepartmentSort(departments);
        TreeSet<String> ts = new TreeSet<>();
        ts.add("K2\\SK1\\SSK1");
        ts.add("K2\\SK1\\SSK2");
        ts.add("K1\\SK1");
        ts.add("K1\\SK2");
        ts.add("K1\\SK1\\SSK1");
        ts.add("K1\\SK1\\SSK2");
        ts.add("K2");
        TreeSet<String> reverse = (TreeSet<String>) ts.descendingSet();
        assertThat(ds.reverseSort(departments), is(reverse));
    }

    @Test
    public void fillMissingDepartmentsTest() {
        String[] departments = {"K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1",
                "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2"};
        DepartmentSort ds = new DepartmentSort(departments);
        TreeSet<String> ts = new TreeSet<>();
        ts.add("K2\\SK1\\SSK1");
        ts.add("K2\\SK1\\SSK2");
        ts.add("K1\\SK1");
        ts.add("K1\\SK2");
        ts.add("K1\\SK1\\SSK1");
        ts.add("K1\\SK1\\SSK2");
        ts.add("K2");
        ts.add("K1");
        ts.add("K2\\SK1");
        TreeSet<String> target = ds.sort(departments);
        assertThat(ds.fillMissingDepartments(target), is(ts));
    }
}