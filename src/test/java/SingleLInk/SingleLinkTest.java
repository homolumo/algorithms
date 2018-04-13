package SingleLInk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleLinkTest {
    private SingleLink<Integer> singleLink = new SingleLink<>();

    @Before
    public void onBefore() {
        singleLink.insertHead(1);
        singleLink.insertTail(2);
        singleLink.insertHead(0);
        singleLink.insertTail(3);
    }

    @Test
    public void headThenTail() throws Exception {
        assertEquals("0 1 2 3", singleLink.toString());
        assertEquals(4, singleLink.getCount());
        assertEquals(Integer.valueOf(2), singleLink.getValue(2));
    }

    @Test
    public void insert() throws Exception {
        singleLink.insert(3, 10);
        assertEquals("0 1 2 3 10", singleLink.toString());
        singleLink.insert(0, 11);
        assertEquals("11 0 1 2 3 10", singleLink.toString());
        singleLink.insert(2, 12);
        assertEquals("11 0 1 12 2 3 10", singleLink.toString());
        assertEquals(7, singleLink.getCount());
    }

    @Test
    public void removeHeadAndTail() {
        assertEquals(Integer.valueOf(0), singleLink.removeHead());
        assertEquals(Integer.valueOf(3), singleLink.removeTail());
        assertEquals("1 2", singleLink.toString());
        assertEquals(2, singleLink.getCount());
        assertEquals(Integer.valueOf(2), singleLink.removeTail());
        assertEquals(Integer.valueOf(1), singleLink.removeHead());
        assertEquals(0, singleLink.getCount());
    }

}