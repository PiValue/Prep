---
title: "Two sum - return indices of numbers in given array that add up to target number."
tags: Leetcode, Number, Others, Easy
---

### Question
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Links
* [Question link](https://leetcode.com/problems/two-sum/description/)
* [Code](./TwoSum.java)
* [Official solution](https://leetcode.com/problems/two-sum/solution/)
* [Discussion](https://leetcode.com/problems/two-sum/discuss/)

### Notes
* Using extra memory for lookup table.

### Code
```java
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
```

### Solution
#### Official
##### Brute force
```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

##### Two pass - HashTable
* My solution is one pass version of this.
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

#### Discussion
* Sort and search approach with O(nlog(n))
```java
	    public int[] twoSum_n2(int[] nums, int target) {
	    	if(nums == null)
	    		return null;
	    	int[] nums2 = Arrays.copyOf(nums, nums.length);
	    	Arrays.sort(nums2);
	    	int a = 0, b = 0;
	    	int start = 0, end = nums2.length-1;
	    	//find two nums
	    	while(start<end){
	    		int sum = nums2[start] + nums2[end];
	    		if(sum < target)
	    			start++;
	    		else if(sum > target)
	    			end--;
	    		else{
	    			a = nums2[start]; b = nums2[end];
	    			break;
	    		}
	    	}
	    	//find the index of two numbers
	    	int[] res = new int[2];
	    	for(int i = 0; i < nums.length; i++){
	    		if(nums[i] == a){
	    			res[0] = i;
	    			break;
	    		}
	    	}
	    	if(a != b){
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	} else{
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b && i != res[0]){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	}
	    	
	    	return res;
	    }
```