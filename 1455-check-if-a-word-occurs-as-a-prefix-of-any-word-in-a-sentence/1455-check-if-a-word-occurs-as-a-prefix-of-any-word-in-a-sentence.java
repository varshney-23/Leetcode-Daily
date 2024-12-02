class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split sentence into words
        String[] words = sentence.split(" ");
        // Iterate through words
        for (int i = 0; i < words.length; i++) {
            // Check if prefix matches searchWord
            if (words[i].length() >= searchWord.length() && 
                words[i].substring(0, searchWord.length()).equals(searchWord)) {
                // Return 1-based index
                return i + 1;
            }
        }
        // Return -1 if no match
        return -1;
    }
}
