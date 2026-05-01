/*
Problem: 3Sum
Platform: LeetCode
Link: https://leetcode.com/problems/3sum/

Difficulty: Medium
Topic: Array, Two Pointers, Sorting

Approach:
- Sort the array to enable two-pointer technique
- Fix one element (i) and use two pointers (j, k) for remaining part
- If sum < 0 → move left pointer (j++) to increase sum
- If sum > 0 → move right pointer (k--) to decrease sum
- If sum == 0 → store triplet and move both pointers
- Skip duplicates for i, j, and k to avoid repeated triplets

Edge Cases:
- Array length < 3 → return empty list
- Multiple duplicates → handled using skip logic
- All positive or all negative → no valid triplets

Time Complexity: O(n^2)
- Outer loop runs n-2 times, inner two-pointer scan takes O(n)

Space Complexity: O(1) (excluding output list)
- No extra space used apart from result storage
*/

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
      
        //Optimization: no need to go till n
        for (int i = 0; i < n-2; i++) {
            
            // Skip duplicate values for i
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;

                    // Skip duplicates for j and k
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}
