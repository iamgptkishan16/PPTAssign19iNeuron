/*
💡 3. **Sort an Array**

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem **without using any built-in** functions in `O(nlog(n))` time complexity and with the smallest space complexity possible.

**Example 1:**
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).


*/

public class SortArray {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};

        int[] sortedArray = sortArray(nums);

        System.out.print("Sorted array: ");

        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}