package com.ds.lists;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ListNode {
    private int val;
    private ListNode next;

    /**
     * Make a Linked list out of given array of integers.
     * @return
     */
    public static ListNode makeList(@NonNull final int []elements) {
        ListNode preHead = new ListNode(-1, null);
        ListNode prev = preHead;
        for (int element : elements) {
            ListNode node = new ListNode(element, null);
            prev.setNext(node);
            prev = node;
        }
        return preHead.getNext();
    }

    /**
     * Convert given Linked list to a List<Integer> starting at given pointer as head node.
     * @return {@link List} of values.
     */
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        ListNode ptr = this;
        while (ptr != null) {
            list.add(ptr.getVal());
            ptr = ptr.next;
        }
        return list;
    }
}
