/*
Problem: Two Sum
Platform: LeetCode
Link: https://leetcode.com/problems/two-sum/

Difficulty: Easy
Topic: Array, Hashing

Approach:
- Use a HashMap to store elements and their indices
- Traverse the array once
- For each element, calculate complement = target - nums[i]
- If complement exists in map → return indices
- Otherwise, store current element in map

Edge Cases:
- Exactly one valid solution is guaranteed
- No element can be used twice
- Array may contain negative numbers and duplicates

Time Complexity: O(n)
- Single pass through the array

Space Complexity: O(n)
- HashMap stores up to n elements
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {}; // no solution found
    }
}
