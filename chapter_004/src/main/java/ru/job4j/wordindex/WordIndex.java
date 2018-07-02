package ru.job4j.wordindex;

import java.io.*;
import java.util.Set;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class WordIndex {

    private Node root = new Node();

    /**
     * Method inserts a word into the trie structure
     * and adds it's index to the Node.
     * @param word - word to add
     * @param index - index to add
     */
    public void insert(String word, int index) {
        Node current = this.root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                current.getChildren().put(c, new Node());
            }
            current = current.getChildren().get(c);
        }
        current.getIndeces().add(index);
    }

    /**
     * Method asserts whether a word is contained within the WordIndex
     * and returns a boolean result.
     * @param word - word to look for.
     * @return - result
     */
    public boolean find(String word) {
        Node current = this.root;
        boolean result = true;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                result = false;
                break;
            } else {
                current = current.getChildren().get(c);
            }
        }
        return result;
    }

    /**
     * Method reads from file line by line, extracts words only,
     * indexes them and adds the words to WordIndex.
     * @param fileName - file to be read.
     * @throws IOException - exception.
     */
    public void loadFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        int index = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\W|\\d|_");
            for (int i = 0; i < words.length; i++) {
                this.insert(words[i], index++);
            }
        }
        br.close();
    }

    /**
     * Method returns a Set of Integers representing the word's
     * positions in the file from which it came.
     * @param word - the target word.
     * @return - the Set of Integers.
     */
    public Set<Integer> getIndicesForWord(String word) {
        Node current = root;
        if (this.find(word)) {
            for (char c : word.toLowerCase().toCharArray()) {
                current = current.getChildren().get(c);
            }
        }
        return current.getIndeces();
    }
}
