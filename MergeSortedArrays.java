/*
💡 **6. Merge two sorted arrays**

Given two sorted arrays, the task is to merge them in a sorted manner.

**Examples:**

> Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
Output: arr3[] = {4, 5, 7, 8, 8, 9}

*/


public class MergeSortedArrays {
    public static int[] mergeArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];

        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2
        int k = 0; // pointer for merged array

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j < m) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};

        int[] mergedArray = mergeArrays(nums1, nums2);

        System.out.print("Merged array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
