package com.ds.lists.leetcode.q21;

import com.ds.lists.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        final ListNode preHead = new ListNode(-1, null);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.getVal() < l2.getVal()) {
                prev.setNext(l1);
                l1 = l1.getNext();
            } else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            prev = prev.getNext();
            prev.setNext(null);
        }
        // Append whatever is remaining after loop.
        ListNode remaining = l1 == null ? l2 : l1;
        prev.setNext(remaining);
        return preHead.getNext();
    }
}
