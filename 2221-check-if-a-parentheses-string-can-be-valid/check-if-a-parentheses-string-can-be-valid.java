class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        // base check
        if (n % 2 != 0) {
            return false;
        }

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                openClose.push(i);
            } else if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == ')') {
                if (!open.isEmpty()) { // neutralize
                    open.pop();
                } else if (!openClose.isEmpty()) { // openClose can become open and make it valid
                    openClose.pop();
                } else { // can't be valid
                    return false;
                }
            }
        }

        // if elements in both stack left
        while (!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek()) {
            // if open peek index > openClose peek index so it will not able to cancel out
            open.pop();
            openClose.pop();
        }

        return open.isEmpty();
    }
}
/**
TC - O(n)
SC - O(n) */