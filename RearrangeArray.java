/*
  5. **Rearrange array in alternating positive & negative items with O(1) extra space**

Given an **array of positive** and **negative numbers**, arrange them in an **alternate** fashion such that every positive number is followed by a negative and vice-versa maintaining the **order of appearance**. The number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

**Examples:**

> Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
> 

*/

public class RearrangeArray {
    public static void rearrange(int[] nums) {
        int n = nums.length;
        int positive = 0; // pointer for positive numbers
        int negative = 0; // pointer for negative numbers

        while (positive < n && negative < n) {
            // Find the next positive number
            while (positive < n && nums[positive] < 0) {
                positive++;
            }

            // Find the next negative number
            while (negative < n && nums[negative] >= 0) {
                negative++;
            }

            // Swap the positive and negative numbers
            if (positive < n && negative < n) {
                swap(nums, positive, negative);
                positive++;
                negative += 2;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -4, 5, -6, 7};

        rearrange(nums);

        System.out.print("Modified array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
