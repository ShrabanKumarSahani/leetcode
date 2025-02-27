class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> numset = new HashSet<>();
        for(int num : arr) {
            numset.add(num);
        }

        int maxlength = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int prevNum = arr[j];
                int currNum = arr[i] + arr[j];
                int l = 2;

                while(numset.contains(currNum)) {
                    int tempNum = currNum;
                    currNum += prevNum;
                    prevNum = tempNum;
                    maxlength = Math.max(maxlength, ++l);
                }
            }
        }

        return maxlength;
    }
}
/**
TC = O(n^3)
SC = O(n) */