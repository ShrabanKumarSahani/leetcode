class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n+1];
        P[0] = 1;
        double currProbSum = k > 0 ? 1 : 0;
        for(int i = 1; i <= n; i++) {
            P[i] = currProbSum/maxPts;
            if(i < k) {
                currProbSum += P[i];
            }
            if(i - maxPts >= 0 && i - maxPts < k) {
                currProbSum -= P[i-maxPts];
            }
        }
        return Arrays.stream(P, k, P.length).sum();
    }
}