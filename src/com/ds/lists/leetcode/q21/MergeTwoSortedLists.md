---
title: "Merge Two Sorted Lists."
tags: Leetcode, LinkedList, Easy
---

### Question
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

### Links
* [Question link](https://leetcode.com/problems/merge-two-sorted-lists/description/)
* [Code](./MergeTwoSortedLists.java)
* [Official solution](https://leetcode.com/problems/merge-two-sorted-lists/solution/)
* [Discussion](https://discuss.leetcode.com/category/29/merge-two-sorted-lists)

### Notes
* Assign `head` to the head with smallest value in the given 2 lists.
	* Whatever input list that had smallest value, move it's head pointer to next element. 
	* We would be returning `head`.
* Assign `ptr` to head before iterating.
* Loop till both lists have some elements. In each iteration,
	*  Assign smallest node to `ptr.next`, move smallest node ref to its next.
	* Move `ptr` to `ptr.next` and `ptr.next = null`.
* After the loop, append whatever remaining values to `ptr`.
	* There would elements on just one list at maximum.

### Code
#### Attempt-1
```java
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode prev = null;
        if (l1.getVal() < l2.getVal()) {
            prev = l1;
            l1 = l1.getNext();
        } else {
            prev = l2;
            l2 = l2.getNext();
        }
        ListNode head = prev;
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
        if (l1 != null) {
            prev.setNext(l1);
        } else {
            prev.setNext(l2);
        }
        return head;
    }
}
```

#### Attempt-2
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        final ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
            prev.next = null;
        }
        // Append whatever is remaining after loop.
        ListNode remaining = l1 == null ? l2 : l1;
        prev.next  = remaining;
        return preHead.next;
    }
}
```

### Solution
#### Official
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
```

#### Discussion
* Iterative,
```java
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1!=null && l2==null) return l1;
        if(l2!=null && l1==null) return l2;
        ListNode head=new ListNode(0);
        ListNode node=head;
        while(l1!=null && l2!=null){
            if(l1.val>=l2.val) {
                node.next=l2;
                l2=l2.next;
            }
            else{
                node.next=l1;
                l1=l1.next;
            }
            node=node.next;
        }
        node.next = (l1 != null) ? l1 : l2;// Append the remaining elements in the longer list
        return head.next;
    }
}
```

* Recusrive
```java
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
```