package ru.job4j.tradeprocessor;

import java.util.ArrayList;

public class TradeProcessor {

    private ArrayList<Book> books;
    private long index = 0;

    public TradeProcessor() {
        books.add(new Book("Not found"));
    }

    /**
     * Method adds or deletes a TradeRequest according to type.
     * If neither option is viable - does nothing, returns false.
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
     * @param tr
     * @return Book
     */
    public Book findBook(TradeRequest tr) {
        Book result = books.get(0);
        for (Book b : books) {
            if (tr.getBookName().equals(b.getBookName())) {
                result = b;
                break;
            } else {
                books.add(new Book(tr.getBookName()));
            }
        }
        return result;
    }

    /**
     * Method finds a Book be bookName.
     * @param bookName
     * @return Book
     */
    public Book getBookByName(String bookName) {
        Book result = books.get(0);
        for (Book b : books) {
            if (b.getBookName().equals(bookName)) {
                result = b;
                break;
            }
        }
        return result;
    }

    /**
     * Method adds Book to list of books if it is not already on the list.
     * @param book
     * @return boolean
     */
    public boolean addBook(Book book) {
        boolean result = true;
        String bookName = book.getBookName();
        for (Book b : books) {
            if (b.getBookName().equals(bookName)) {
                result = false;
                break;
            } else {
                books.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }
}
