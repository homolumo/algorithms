package SingleLink;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleLinkTest {
    private SingleLink<Integer> singleLink = new SingleLink<Integer>();

    @Before
    public void onBefore() {
        singleLink.unshift(1);
        singleLink.push(2);
        singleLink.unshift(0);
        singleLink.push(3);
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
        assertEquals(Integer.valueOf(0), singleLink.shift());
        assertEquals(Integer.valueOf(3), singleLink.pop());
        assertEquals("1 2", singleLink.toString());
        assertEquals(2, singleLink.getCount());
        assertEquals(Integer.valueOf(2), singleLink.pop());
        assertEquals(Integer.valueOf(1), singleLink.shift());
        assertEquals(0, singleLink.getCount());
    }

    @Test
    public void foreach() {
        for (Integer val : singleLink) {
            System.out.println(val);
        }
    }
}