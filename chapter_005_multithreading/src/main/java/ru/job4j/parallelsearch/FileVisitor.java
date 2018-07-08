package ru.job4j.parallelsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileVisitor {

    public List<String> getPaths(String directoryName) {

        File directory = new File(directoryName);

        List<String> result = new ArrayList<>();
        File[] fileList = directory.listFiles();

        for (File file : fileList) {
            if (file.isFile()) {
                result.add(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                result.addAll(getPaths(file.getAbsolutePath()));
            }
        }
        return result;
    }

    public ArrayList<String> filterExtensions(List<String> paths, List<String> exts) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : paths) {
            for (String e : exts) {
                if (s.endsWith(e)) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    public List<String> filterByText(Queue<String> paths, String text) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        for (String s : paths) {
            Scanner sc = new Scanner(new File(s));
            while (sc.hasNextLine()) {
                if (sc.nextLine().contains(text)) {
                    result.add(s);
                    sc.close();
                    break;
                }
            } sc.close();
        }
        return result;
    }
}
