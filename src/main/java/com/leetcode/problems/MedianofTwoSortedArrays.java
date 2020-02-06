package com.leetcode.problems;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double halfLength = Math.ceil((double) (nums1.length + nums2.length) / 2);

        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        int i = 0, y = 0, medium = 0;

        while (halfLength-- > 0) {
            if (i < nums1.length && nums1[i] >= medium && (y >= nums2.length || nums1[i] < nums2[y])) {
                medium = nums1[i++];
                continue;
            }
            medium = nums2[y++];
        }

        if (!isEven) return medium;

        if (i < nums1.length && nums1[i] >= medium && (y >= nums2.length || nums1[i] < nums2[y])) {
            return ((double) (medium + nums1[i])) / 2;
        }

        return ((double) (medium + nums2[y])) / 2;
    }
}
