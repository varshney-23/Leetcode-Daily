class Solution {

    public int[] finalPrices(int[] prices) {
        // Step 1: Create a copy of the prices array to store the final discounted prices
        int[] result = prices.clone();

        // Step 2: Use a stack to track indices of items waiting for a discount
        Stack<Integer> stack = new Stack<>();

        // Step 3: Iterate through the prices array
        for (int i = 0; i < prices.length; i++) {
            // While there are items in the stack and the current price is less than or equal
            // to the price of the item at the top of the stack, apply the discount
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                result[stack.pop()] -= prices[i]; // Apply the discount
            }
            // Add the current item's index to the stack
            stack.add(i);
        }

        // Step 4: Return the array of final prices after discounts
        return result;
    }
}
