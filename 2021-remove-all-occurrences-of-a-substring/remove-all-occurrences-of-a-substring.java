class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int m = s.length();
        int n = part.length();

        for (int i = 0; i < m; i++) {
            st.push(s.charAt(i));
            if (st.size() >= n && check(n, part, st)) {     // if st size > part length and part is present then popping
                for (int j = 0; j < n; j++) {
                    st.pop();
                }
            }
        }

        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.append(st.pop());
        }

        return str.reverse().toString();
    }

    private boolean check(int n, String part, Stack<Character> st) {
        Stack<Character> tempStack = new Stack<>();
        tempStack.addAll(st);           // copy stack

        for(int idx = n-1; idx >= 0; idx--) {
            if(tempStack.peek() != part.charAt(idx)) {  // not match with part
                return false;
            }
            tempStack.pop();
        }

        return true;
    }
}
/**
 * TC = O(s.length * part.length) = O(n^2)
 * SC = O(s.length)
 */