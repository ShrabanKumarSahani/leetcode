class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--) {
            // remove all indices where temp <= curr temp
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            //if stack is not empty then this is next warmer temp
            if(!st.isEmpty()) {
                ans[i] = st.peek() - i;         // diff in days
            }
            // pushing curr idx for future comparisions
            st.push(i);
        }
        return ans;
    }
}