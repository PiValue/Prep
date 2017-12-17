package com.ds.tree.leetcode.q1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // Build lookup table for given numbers and look for required target sum.
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                return new int[] {map.get(target - nums[index]), index};
            }
            map.put(nums[index], index);
        }
        return new int[] {};
    }
}
