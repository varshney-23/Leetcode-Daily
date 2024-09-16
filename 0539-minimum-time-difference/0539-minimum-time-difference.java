class Solution {

    public int findMinDifference(List<String> timePoints) {
        // convert input to minutes
        int[] mint = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            mint[i] = h * 60 + m;
        }

        // sort times in ascending order
        Arrays.sort(mint);

        // find minimum difference across adjacent elements
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mint.length - 1; i++) {
            ans = Math.min(ans, mint[i + 1] - mint[i]);
        }

        // consider difference between last and first element
        return Math.min(ans, 24 * 60 - mint[mint.length - 1] + mint[0]);
    }
}