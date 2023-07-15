/*
💡 2. **Count of Smaller Numbers After Self**

Given an integer array `nums`, return *an integer array* `counts` *where* `counts[i]` *is the number of smaller elements to the right of* `nums[i]`.

**Example 1:**

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are2 smaller elements (2 and 1).
To the right of 2 there is only1 smaller element (1).
To the right of 6 there is1 smaller element (1).
To the right of 1 there is0 smaller element.

*/

import java.util.*;

public class CountSmallerNumbersAfterSelf {
    private static class NumberIndex {
        int number;
        int index;

        NumberIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] counts = new Integer[n];
        NumberIndex[] numbers = new NumberIndex[n];

        // Initialize the counts array with zeros
        Arrays.fill(counts, 0);

        // Create NumberIndex objects for each element in the input array
        for (int i = 0; i < n; i++) {
            numbers[i] = new NumberIndex(nums[i], i);
        }

        mergeSort(numbers, counts);

        return Arrays.asList(counts);
    }

    private static NumberIndex[] mergeSort(NumberIndex[] numbers, Integer[] counts) {
        int n = numbers.length;
        if (n <= 1) {
            return numbers;
        }

        int mid = n / 2;

        NumberIndex[] left = mergeSort(Arrays.copyOfRange(numbers, 0, mid), counts);
        NumberIndex[] right = mergeSort(Arrays.copyOfRange(numbers, mid, n), counts);

        int i = 0, j = 0;
        while (i < left.length || j < right.length) {
            if (j == right.length || (i < left.length && left[i].number <= right[j].number)) {
                numbers[i + j] = left[i];
                counts[left[i].index] += j;
                i++;
            } else {
                numbers[i + j] = right[j];
                j++;
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};

        List<Integer> counts = countSmaller(nums);

        System.out.println("Counts of smaller numbers after each element: " + counts);
    }
}