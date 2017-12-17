package com.ds.lists.leetcode.q21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ds.lists.ListNode;
import com.google.common.primitives.Ints;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists obj = new MergeTwoSortedLists();

    @Test
    public void test_withDuplicates() {
        ListNode l1 = ListNode.makeList(new int[] {1, 2, 4});
        ListNode l2 = ListNode.makeList(new int[] {1, 3, 4});
        assertEquals(Ints.asList(1, 1, 2, 3, 4, 4), obj.mergeTwoLists(l1, l2).toList());
    }
}
