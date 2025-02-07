class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();

        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballMap.containsKey(ball)) {
                int oldColour = ballMap.get(ball);
                colorMap.put(oldColour, colorMap.get(oldColour) - 1);
                if(colorMap.get(oldColour) == 0) {
                    colorMap.remove(oldColour);
                }
            }

            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color,0) + 1);
            ans[i] = colorMap.size();
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n) */