package Algorithm;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1]

public class TwoSum {//暴力破解法
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

}
//Time complexity : O(n^2)O(n2). For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time. 
//Therefore, the time complexity is O(n^2)O(n2).
//Space complexity : O(1)O(1).