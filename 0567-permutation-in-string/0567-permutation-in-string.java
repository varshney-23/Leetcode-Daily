public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Fill frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        int windowSize = s1.length();
        int s2Length = s2.length();
        
        for (int i = 0; i < s2Length; i++) {
            // Add current character to the window
            s2Count[s2.charAt(i) - 'a']++;
            
            // Remove the character that's left the window (if window is full)
            if (i >= windowSize) {
                s2Count[s2.charAt(i - windowSize) - 'a']--;
            }
            
            // Check if the current window matches the frequency of s1
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
}
