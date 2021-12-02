package com.company.problems;

import com.company.model.ListNode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
    
}
