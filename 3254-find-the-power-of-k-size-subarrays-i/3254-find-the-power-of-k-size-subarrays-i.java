class Solution {

    public int[] resultsArray(int[] nums, int k) {
        // If k is 1, return the original array as each element itself is a valid subarray
        if (k == 1) {
            return nums;
        }

        int length = nums.length; // Length of the input array
        int[] result = new int[length - k + 1]; // Array to store results
        Arrays.fill(result, -1); // Fill result array with -1 as default values
        int consecutiveCount = 1; // To count consecutive increasing elements

        // Loop through the array till the second last element
        for (int index = 0; index < length - 1; index++) {
            // Check if the next element is consecutive (current element + 1)
            if (nums[index] + 1 == nums[index + 1]) {
                consecutiveCount++; // Increase the count if consecutive
            } else {
                consecutiveCount = 1; // Reset count if they are not consecutive
            }

            // If we have found k consecutive elements
            if (consecutiveCount >= k) {
                // Update result array at the start of this k-length sequence
                result[index - k + 2] = nums[index + 1];
            }
        }

        return result;
    }
}