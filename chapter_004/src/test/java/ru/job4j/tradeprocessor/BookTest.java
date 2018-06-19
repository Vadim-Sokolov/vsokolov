package ru.job4j.tradeprocessor;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BookTest {

    private Book tb = new Book("testBook");
    TradeRequest tr1 = new TradeRequest("testBook", "ADD", "BID", 100, 50);
    TradeRequest tr2 = new TradeRequest("testBook", "ADD", "BID", 120, 1000);
    TradeRequest tr3 = new TradeRequest("testBook", "ADD", "BID", 90, 300);
    TradeRequest tr4 = new TradeRequest("testBook", "ADD", "ASK", 150, 500);
    TradeRequest tr5 = new TradeRequest("testBook", "ADD", "ASK", 160, 500);
    TradeRequest tr6 = new TradeRequest("testBook", "ADD", "ASK", 170, 300);

    @Before
    public void beforeTest() {
        tb.add(tr1);
        tb.add(tr2);
        tb.add(tr3);
        tb.add(tr4);
        tb.add(tr5);
        tb.add(tr6);
    }

    @Test
    public void addTest() {
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void checkBidForRequestTest() {
    }

    @Test
    public void checkAskForRequestTest() {
    }

    @Test
    public void bookPrintTest() {
        tb.bookPrint();
    }
}