class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        // Step 1: Count the frequency of each character in the input string
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Use a max-heap (priority queue) to keep characters in descending order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> 
            Character.compare(b, a) // Compare characters in reverse (largest comes first)
        );

        // Add all unique characters to the max-heap
        for (char ch : freq.keySet()) {
            maxHeap.offer(ch);
        }

        StringBuilder result = new StringBuilder(); // To build the final output string

        // Step 3: Start building the string
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll(); // Get the current largest character
            int count = freq.get(ch); // Get its remaining frequency

            // Decide how many times to use this character (cannot exceed repeatLimit)
            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                result.append(ch); // Append the character "use" times
            }

            freq.put(ch, count - use); // Update the remaining count of this character

            // Step 4: If there are still occurrences left for the current character
            if (freq.get(ch) > 0 && !maxHeap.isEmpty()) {
                char nextCh = maxHeap.poll(); // Take the next largest character
                result.append(nextCh); // Append this next character once
                freq.put(nextCh, freq.get(nextCh) - 1); // Reduce its frequency by 1
                
                // If the next character still has occurrences left, put it back in the heap
                if (freq.get(nextCh) > 0) {
                    maxHeap.offer(nextCh);
                }
                // Put the current character back into the heap for future use
                maxHeap.offer(ch);
            }
        }

        // Step 5: Return the final constructed string
        return result.toString();
    }
}
