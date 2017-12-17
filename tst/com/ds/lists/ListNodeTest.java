package com.ds.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.google.common.primitives.Ints;

public class ListNodeTest {
    @Test(expected = NullPointerException.class)
    public void test_makeListNull() {
        ListNode.makeList(null);
    }

    @Test
    public void test_makeList() {
        final int[] input = {2, 4, 1, 5, 6, 4, 8, 10};
        ListNode list = ListNode.makeList(input);
        int index = 0;
        for (int element : input) {
            assertNotNull("Node is null after index: " + index, list);
            assertEquals("Value mismatch at index: " + index, element, list.getVal());
            list = list.getNext();
            index++;
        }
        // No more elements.
        assertNull(list);
    }

    @Test
    public void test_toList() {
        final int[] input = {2, 4, 1, 5, 6, 4, 8, 10};
        ListNode list = ListNode.makeList(input);
        assertEquals(Ints.asList(input), list.toList());
    }
}
