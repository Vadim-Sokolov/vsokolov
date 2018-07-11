package ru.job4j.parallelsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileVisitor {

    public List<String> getPaths(String directoryName) {
        File dir = new File(directoryName);
        Stack<File> stack = new Stack<File>();
        stack.push(dir);
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isFile()) {
                result.add(child.getAbsolutePath());
            }
            if (child.isDirectory()) {
                for (File f : child.listFiles()) {
                    stack.push(f);
                }
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
            }
            sc.close();
        }
        return result;
    }
}
