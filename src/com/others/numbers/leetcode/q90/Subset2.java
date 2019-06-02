import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Explanation: https://leetcode.com/problems/subsets-ii/discuss/304333/1ms-beats-100-of-java-submissions 
 * [90] Subsets II
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubset(int[] nums, int idx, List<Integer> partial, List<List<Integer>> result) {
        result.add(new ArrayList<>(partial));

        int prev = Integer.MAX_VALUE;
        while (idx < nums.length) {
            if (nums[idx] == prev) {
                idx++; 
                continue;
            }

            partial.add(nums[idx]);
            generateSubset(nums, idx + 1, partial, result);
            prev = partial.get(partial.size() - 1);
            partial.remove(partial.size() - 1); // remove last element.
            idx++;
        }
    }
}



