package com.company.model;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<Integer> toList() {
        ListNode tmp = this;
        List<Integer> list = new LinkedList();
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}