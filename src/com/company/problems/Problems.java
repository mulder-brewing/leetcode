package com.company.problems;

import com.company.model.ListNode;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Problems {

    public static int[] twoSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static int[] twoSum_mapSolution(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer remainder = target - nums[i];
            if (valueToIndex.containsKey(remainder) && valueToIndex.get(remainder) != i) {
                return new int[] { i, valueToIndex.get(remainder) };
            }
            valueToIndex.put(nums[i], i);
        }

        return null;
    }

    public static ListNode addTwoNumbers_bruteForce(ListNode l1, ListNode l2) {
        BigInteger sum = sumListNode(l1).add(sumListNode(l2));
        String[] digits = sum.toString().split("");
        int[] digitsArray = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitsArray[i] = Integer.parseInt(digits[i]);
        }

        ListNode toReturn = new ListNode(digitsArray[digitsArray.length - 1]);

        ListNode prev = toReturn;
        for (int i = digitsArray.length - 2; i >= 0; i--) {
            prev.next = new ListNode(digitsArray[i]);
            prev = prev.next;
        }

        return toReturn;
    }

    protected static BigInteger sumListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        ListNode currentListNode = listNode;
        while (currentListNode != null) {
            sb.append(currentListNode.val);
            currentListNode = currentListNode.next;
        }
        sb.reverse();
        return new BigInteger(sb.toString());
    }

    public static ListNode addTwoNumbers_elementaryMath(ListNode l1, ListNode l2) {
        ListNode toReturn = null;
        ListNode currentNode = null;

        int remainder = 0;
        while (l1 != null || l2 != null) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;

            int sum = l1Num + l2Num + remainder;
            remainder = sum / 10;

            ListNode node = new ListNode(sum % 10);

            if (toReturn == null) {
                toReturn = node;
            }
            if (currentNode == null) {
                currentNode = node;
            } else {
                currentNode.next = node;
                currentNode = node;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (remainder > 0) {
            currentNode.next = new ListNode(remainder);
        }

        return toReturn;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        // Use this for uniqueness
        Set<Character> characters = new HashSet<>();

        int longestSubstringLength = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            characters.add(chars[i]);
            int longestLengthThisIndex = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (characters.add(chars[j])) {
                    longestLengthThisIndex++;
                    if (longestLengthThisIndex > longestSubstringLength) {
                        longestSubstringLength = longestLengthThisIndex;
                    }
                } else {
                    break;
                }
            }
            characters.clear();
        }

        return longestSubstringLength;
    }

    public static int lengthOfLongestSubstring_slidingWindow(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> chars = new HashSet<>();
        int startWindow = 0;
        int endWindow = 0;
        int maxLength = 0;

        while (endWindow < s.length()) {
            if (chars.add(s.charAt(endWindow))) {
                endWindow++;
                maxLength = Math.max(maxLength, chars.size());
            } else {
                chars.remove(s.charAt(startWindow++));
            }
        }

        return maxLength;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedAndSorted = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
        int middle = mergedAndSorted.length / 2;
        if (mergedAndSorted.length % 2 == 0) {
            return (mergedAndSorted[middle] + mergedAndSorted[middle - 1]) / 2.0;
        } else {
            return mergedAndSorted[middle];
        }
    }

    public static String longestPalindrome_bruteForce(String s) {
        if (s.length() == 1) {
            return s;
        }

        String longestPalindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longestPalindrome.length()) {
                    longestPalindrome = sub;
                }
            }
        }
        return longestPalindrome;
    }

    protected static boolean isPalindrome(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            queue.add(c);
        }

        return stack.equals(queue);
    }

}
