package ru.job4j.tradeprocessor;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class TradeProcessorTest {

    private TradeProcessor tp;
    TradeRequest tr1 = new TradeRequest("testBook", "ADD", "BID", 100, 50);
    TradeRequest tr2 = new TradeRequest("testBook", "ADD", "BID", 120, 1000);
    TradeRequest tr3 = new TradeRequest("testBook", "ADD", "BID", 90, 300);
    TradeRequest tr4 = new TradeRequest("testBook", "ADD", "ASK", 150, 500);
    TradeRequest tr5 = new TradeRequest("testBook", "ADD", "ASK", 160, 500);
    TradeRequest tr6 = new TradeRequest("testBook", "ADD", "ASK", 170, 300);

    @Before
    public void beforeTest() {
        tp.addTradeRequest(tr1);
    }

    @Test
    public void addTradeRequestTest() {
        tp.addTradeRequest(tr2);
        assertThat(tp.getBooks().get(1).getName(), is("testBook"));
    }

    @Test
    public void findBookTest() {
    }

    @Test
    public void getBookByNameTest() {
    }
}