package com.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);

        for (int i=0; i < nums.length-1 && nums[i] <= 0; i++) {
            if (i-1 >= 0 && nums[i] == nums[i-1]) continue;

            int s = i+1;
            int e = nums.length-1;
            while (s < e) {
                int sum = nums[s] + nums[e] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[s++], nums[e--]));
                    while (s < e && nums[s-1] == nums[s]) s++;
                    while (s < e && nums[e+1] == nums[e]) e--;
                } else if (sum > 0) {
                    e--;
                    while (s < e && nums[e+1] == nums[e]) e--;
                } else {
                    s++;
                    while (s < e && nums[s-1] == nums[s]) s++;
                }
            }
        }
        return res;
    }
}
