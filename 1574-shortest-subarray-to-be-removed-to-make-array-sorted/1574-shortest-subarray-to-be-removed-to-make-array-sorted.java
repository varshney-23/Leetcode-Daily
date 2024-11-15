class Solution {

    public int findLengthOfShortestSubarray(int[] arr) {
        // Start from the end of the array and find the last position `right`
        // where the array stops being non-decreasing
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // If `right` is 0, the array is fully non-decreasing already,
        // so we don't need to remove any elements
        if (right == 0) return 0;

        // Initialize `ans` as the size of the subarray from the beginning to `right`,
        // assuming we might need to remove this part to make the array sorted
        int ans = right;

        // Now we use a `left` pointer to try building a valid sorted prefix
        int left = 0;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // Move `right` forward to skip elements in the suffix
            // until we find a point where we can combine with `left`
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }

            // Update `ans` with the minimum length of the subarray to remove
            ans = Math.min(ans, right - left - 1);
            
            // Move `left` forward to keep checking larger prefixes
            left++;
        }
        
        // `ans` now contains the smallest number of elements to remove
        return ans;
    }
}
