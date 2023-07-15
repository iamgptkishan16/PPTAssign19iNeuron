/*
💡 4. **Move all zeroes to end of array**

Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).

**Example:**
Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};

Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
Output : arr[] = {1, 2, 3, 6, 0, 0, 0};

*/

public class MoveZeroesToEnd {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0; // pointer to track the last non-zero element
        int right = 0; // pointer to iterate through the array

        while (right < n) {
            if (nums[right] != 0) {
                // Swap the current element with the last non-zero element
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        moveZeroes(nums);

        System.out.print("Modified array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
