package ru.job4j.tradeprocessor;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Book {

    private String bookName;
    Comparator<TradeRequest> comparator;
    PriorityQueue<TradeRequest> bid;
    PriorityQueue<TradeRequest> ask;

    public Book(String bookName) {
        this.bookName = bookName;
        this.comparator = new PriceComparator();
        this.bid = new PriorityQueue<>(10, comparator);
        this.ask = new PriorityQueue<>(10, comparator);
    }

    public void add(TradeRequest tr) {
        if (tr.getAction().equals("BID")) {
            bid.add(tr);
            checkAskForRequest(tr);
        } else if (tr.getAction().equals("ASK")) {
            ask.add(tr);
            checkBidForRequest(tr);
        }
    }

    public void delete(TradeRequest tr) {
        if (tr.getAction().equals("BID")) {
            bid.remove(tr);
        } else if (tr.getAction().equals("ASK")) {
            ask.remove(tr);
        }
    }

    public void checkBidForRequest(TradeRequest tr) {
        while (tr.getVolume() > 0 && this.bid.peek() != null) {
            if (this.bid.peek().getPrice() >= tr.getPrice()) {
                if (this.bid.peek().getVolume() < tr.getVolume()) {
                    tr.setVolume(tr.getVolume() - this.bid.poll().getVolume());
                } else if (bid.peek().getVolume() > tr.getVolume()) {
                    this.bid.peek().setVolume(this.bid.peek().getVolume() - tr.getVolume());
                    this.ask.remove(tr);
                } else if (bid.peek().getVolume() == tr.getVolume()) {
                    this.bid.poll();
                    this.ask.remove(tr);
                }
            }
        }
    }

    public void checkAskForRequest(TradeRequest tr) {
        while (tr.getVolume() > 0 && this.ask.peek() != null) {
            if (this.ask.peek().getPrice() <= tr.getPrice()) {
                if (this.ask.peek().getVolume() < tr.getVolume()) {
                    tr.setVolume(tr.getVolume() - this.ask.poll().getVolume());
                } else if (this.ask.peek().getVolume() > tr.getVolume()) {
                    this.ask.peek().setVolume(this.ask.peek().getVolume() - tr.getVolume());
                    this.bid.remove(tr);
                } else if (this.ask.peek().getVolume() == tr.getVolume()) {
                    this.ask.poll();
                    this.bid.remove(tr);
                }
            }
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void bookPrint() {
        TreeMap<Float, Integer> bids = new TreeMap<>();
        while (this.bid.peek() != null) {
            float price = this.bid.peek().getPrice();
            int volume = this.bid.poll().getVolume();
            if (bids.containsKey(price)) {
                int temp = bids.get(price) + volume;
                bids.put(price, temp);
            } else {
                bids.put(price, volume);
            }
        }
        TreeMap<Float, Integer> asks = new TreeMap<>();
        while (this.ask.peek() != null) {
            float price = this.ask.peek().getPrice();
            int volume = this.ask.poll().getVolume();
            if (asks.containsKey(price)) {
                int temp = asks.get(price) + volume;
                asks.put(price, temp);
            } else {
                asks.put(price, volume);
            }
        }
        if (this.bid.isEmpty()) {
            for (Map.Entry<Float, Integer> i : asks.entrySet()) {
                System.out.println(i.getKey() + " " + i.getValue());
            }
        } else if (this.ask.isEmpty()) {
            for (Map.Entry<Float, Integer> i : bids.entrySet()) {
                System.out.println(i.getKey() + " " + i.getValue());
            }
        } else {
            for (Map.Entry<Float, Integer> i : bids.entrySet()) {
                for (Map.Entry<Float, Integer> j : asks.entrySet()) {
                    if (i.getKey() >= j.getKey()) {
                        System.out.println(i.getKey() + " " + i.getValue());
                    } else {
                        System.out.println(j.getKey() + " " + j.getValue());
                    }
                }
            }
        }
    }

    public String getName() {
        return this.bookName;
    }
        private class PriceComparator implements Comparator<TradeRequest> {

            @Override
            public int compare(TradeRequest o1, TradeRequest o2) {
                int result = -2;
                if (o1.getPrice() < o2.getPrice()) {
                    result = -1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    result = 1;
                } else {
                    result = 0;
                }
                return result;
            }
        }
    }
