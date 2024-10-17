class Solution {
    public int maximumSwap(int num) {
        // Convert the number into a char array representing each digit
        char[] digits = Integer.toString(num).toCharArray();
        
        // Create an array to track the last position of each digit (0-9)
        int[] last = new int[10];

        // Loop through the digits and store the index of each digit's last occurrence
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i; // '0' is subtracted to get the numeric value of the character
        }

        // Try to find the first digit that can be swapped for a larger one
        for (int i = 0; i < digits.length; i++) {
            // Start from the largest digit (9) and check if we can swap it
            for (int d = 9; d > digits[i] - '0'; d--) {
                // If a larger digit exists later in the number, swap
                if (last[d] > i) {
                    // Swap the current digit with the larger one
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    // Return the new number after the swap
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap was made, return the original number
        return num;
    }
}
