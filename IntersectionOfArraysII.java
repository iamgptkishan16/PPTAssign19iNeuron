/*
💡 8. **Intersection of Two Arrays II**

Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must appear as many times as it shows in both arrays and you may return the result in **any order**.

**Example 1:**

*/

import java.util.*;

public class IntersectionOfArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                intersection.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index] = num;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] intersectionArray = intersect(nums1, nums2);

        System.out.print("Intersection: ");
        for (int num : intersectionArray) {
            System.out.print(num + " ");
        }
    }
}
