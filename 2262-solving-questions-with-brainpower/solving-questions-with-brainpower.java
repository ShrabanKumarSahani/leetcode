class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        if(n == 1) {
            return questions[0][0];
        }

        long[] t = new long[200001];

        for(int i = n-1; i >= 0; i--) {
            t[i] = Math.max(questions[i][0] + t[i + questions[i][1] + 1], t[i+1]);
        }

        return t[0];
    }
}
