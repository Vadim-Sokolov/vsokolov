package ru.job4j.tradeprocessor;

import java.util.ArrayList;
import java.util.HashMap;

public class TradeProcessor {

    private HashMap<String, Book> books;
    private long index = 0;

    public TradeProcessor() {
        this.books = new HashMap<>();
        books.put("Not found", new Book("Not found"));
    }

    /**
     * Method adds or deletes a TradeRequest according to type.
     * If neither option is viable - does nothing, returns false.
     *
     * @param tr
     * @return boolean
     */
    public boolean addTradeRequest(TradeRequest tr) {
        boolean result = false;
        tr.setId(index++);
        Book target = findBook(tr);
        if (tr.getType().equals("ADD")) {
            target.add(tr);
            result = true;
        } else if (tr.getType().equals("DELETE")) {
            target.delete(tr);
            result = true;
        }
        return result;
    }

    /**
     * Method finds the appropriate bucket for TradeRequest by bookName.
     *
     * @param tr
     * @return Book
     */
    public Book findBook(TradeRequest tr) {
        Book result = books.get("Not found");
        if (books.containsKey(tr.getBookName())) {
            result = books.get(tr.getBookName());
        } else {
            books.put(tr.getBookName(), new Book(tr.getBookName()));
        }
        return result;
    }

    /**
     * Method finds a Book be bookName.
     *
     * @param bookName
     * @return Book
     */
    public Book getBookByName(String bookName) {
        Book result = books.get("Not found");
        if (books.containsKey(bookName)) {
            result = books.get(bookName);
        }
        return result;
    }

    /**
     * Method adds Book to list of books if it is not already on the list.
     *
     * @param book
     * @return boolean
     */
    public boolean addBook(Book book) {
        boolean result = true;
        String bookName = book.getBookName();
        if (books.containsKey(bookName)) {
            result = false;
        } else {
            books.put(bookName, book);
        }
        return result;
    }

    public HashMap<String, Book> getBooks() {
        return this.books;
    }
}
