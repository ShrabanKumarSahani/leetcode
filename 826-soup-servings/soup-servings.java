class Solution {
    List<int[]> serves = new ArrayList<int[]>() {{
        add(new int[]{100, 0});
        add(new int[]{75, 25});
        add(new int[]{50, 50});
        add(new int[]{25, 75});
    }};
    
    double[][] t;
    public double soupServings(int n) {
        if(n>=5000) {
            return 1;
        }
        t = new double[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                t[i][j] = -1.0;
            }
        }
        return solve(n,n);
    }

    double solve(double A, double B) {
        if(A <= 0 && B <= 0) {
            return 0.5;
        }
        if(A <= 0) {
            return 1.0;
        }
        if(B <= 0) {
            return 0.0;
        }
        if(t[(int)A][(int)B] != -1.0) {
            return t[(int)A][(int)B];
        }

        double probability = 0.0;
        for(int[] p : serves) {
            double A_serve = p[0];
            double B_serve = p[1];
            probability += 0.25*solve(A - A_serve, B - B_serve);
        }

        return t[(int)A][(int)B] = probability;
    }
}