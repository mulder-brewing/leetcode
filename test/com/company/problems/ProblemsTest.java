package com.company.problems;

import com.company.model.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.LinkedList;

class ProblemsTest {

    @Test
    void test_twoSum_bruteForce() {
        Assertions.assertArrayEquals(new int[] { 0, 1 }, Problems.twoSum_bruteForce(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, Problems.twoSum_bruteForce(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, Problems.twoSum_bruteForce(new int[] { 3, 3 }, 6));
    }

    @Test
    void test_twoSum_mapSolution() {
        Assertions.assertArrayEquals(new int[] { 1, 0 }, Problems.twoSum_mapSolution(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 2, 1 }, Problems.twoSum_mapSolution(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 0 }, Problems.twoSum_mapSolution(new int[] { 3, 3 }, 6));
    }

    @Test
    void test_addTwoNumbers() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(0);
        expected.add(8);
        Assertions.assertEquals(expected, Problems.addTwoNumbers(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_zeroCase() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(0);
        Assertions.assertEquals(expected, Problems.addTwoNumbers(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_anotherCase() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(1);
        Assertions.assertEquals(expected, Problems.addTwoNumbers(l1, l2).toList());
    }

    @Test
    void test_sumListNode() {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
        Assertions.assertEquals(new BigInteger("342"), Problems.sumListNode(listNode));
    }

    @Test
    void test_sumListNode_another() {
        ListNode listNode = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        Assertions.assertEquals(new BigInteger("9999999991"), Problems.sumListNode(listNode));
    }
}