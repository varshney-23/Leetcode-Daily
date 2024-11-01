class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;  // Start counting from the first character

        // Append the first character to result, as we are starting from it
        result.append(s.charAt(0));
        
        // Iterate from the second character to the end
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;  // Increase the count if the current character is the same as the previous
            } else {
                count = 1;  // Reset count if the character changes
            }

            // Append only if count is less than or equal to 2
            if (count <= 2) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
