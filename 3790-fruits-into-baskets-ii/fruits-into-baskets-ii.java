class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] visited = new boolean[n];
        int unplacedFruits = n;

        for (int fruit : fruits) {
            for (int i = 0; i < n; ++i) {
                if (baskets[i] >= fruit && !visited[i]) {
                    visited[i] = true; // Mark the basket as used
                    --unplacedFruits; // Decrease count of unplaced fruits
                    break; // Move to the next fruit
                }
            }
        }
        return unplacedFruits; // Return the count of unplaced fruits
    }
}
