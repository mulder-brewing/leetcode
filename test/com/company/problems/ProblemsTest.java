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
    void test_addTwoNumbers_bruteForce() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(0);
        expected.add(8);
        Assertions.assertEquals(expected, Problems.addTwoNumbers_bruteForce(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_bruteForce_zeroCase() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(0);
        Assertions.assertEquals(expected, Problems.addTwoNumbers_bruteForce(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_bruteForce_anotherCase() {
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
        Assertions.assertEquals(expected, Problems.addTwoNumbers_bruteForce(l1, l2).toList());
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

    @Test
    void test_addTwoNumbers_elementaryMath() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(0);
        expected.add(8);
        Assertions.assertEquals(expected, Problems.addTwoNumbers_elementaryMath(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_elementaryMath_zeroCase() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(0);
        Assertions.assertEquals(expected, Problems.addTwoNumbers_elementaryMath(l1, l2).toList());
    }

    @Test
    void test_addTwoNumbers_elementaryMath_anotherCase() {
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
        Assertions.assertEquals(expected, Problems.addTwoNumbers_elementaryMath(l1, l2).toList());
    }

    @Test
    void test_lengthOfLongestSubstring() {
        Assertions.assertEquals(3, Problems.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void test_lengthOfLongestSubstring_slidingWindow() {
        Assertions.assertEquals(3, Problems.lengthOfLongestSubstring_slidingWindow("pwwkew"));
    }

    @Test
    void test_findMedianSortedArrays_odd() {
        Assertions.assertEquals(2, Problems.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
    }

    @Test
    void test_findMedianSortedArrays_even() {
        Assertions.assertEquals(2.5, Problems.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    @Test
    void test_isPalindrome() {
        Assertions.assertTrue(Problems.isPalindrome("racecar"));
        Assertions.assertFalse(Problems.isPalindrome("racecars"));
        Assertions.assertFalse(Problems.isPalindrome("222020221"));
    }

    @Test
    void test_longestPalindrome_bruteForce() {
        Assertions.assertEquals("bab", Problems.longestPalindrome_bruteForce("babad"));
        Assertions.assertEquals("a", Problems.longestPalindrome_bruteForce("a"));
        Assertions.assertEquals("bb", Problems.longestPalindrome_bruteForce("bb"));
    }
}