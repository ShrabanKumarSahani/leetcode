class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));  // max heap  - SC = O(n)

        // storing in pq as pair {delta, index}
        for(int i = 0; i < n; i++) {
            double currentPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPR - currentPR;
            pq.offer(new double[]{delta, i});
        }

        // allocating extra students
        while(extraStudents-- > 0) {
            // extract the class with max delta
            double[] curr = pq.poll();
            int idx = (int) curr[1];

            // update the class with an extra student
            classes[idx][0]++;
            classes[idx][1]++;

            // recalculating the delta for this case
            double currentPR = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double delta = newPR - currentPR;

            // pushing the updated delta and index back to pq
            pq.offer(new double[]{delta, idx});  //logn
        }

        // finding the final avg pass ratio
        double ans = 0.0;
        for(int i = 0; i < n; i++) {
            ans += (double) classes[i][0]/classes[i][1];
        }

        return ans/n;
    }
}

/**
TC - O(logn*extraStudents)
SC - O(n) */