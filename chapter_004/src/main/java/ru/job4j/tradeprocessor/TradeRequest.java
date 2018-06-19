package ru.job4j.tradeprocessor;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class TradeRequest {

    private long id;
    private String bookName; // issuer
    private String type; // ADD, DELETE
    private String action; // BID, ASK
    private float price;
    private int volume;

    public TradeRequest(String bookName, String type, String action, float price, int volume) {
        this.bookName = bookName;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getType() {
        return type;
    }

    public String getAction() {
        return action;
    }

    public float getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }
}
