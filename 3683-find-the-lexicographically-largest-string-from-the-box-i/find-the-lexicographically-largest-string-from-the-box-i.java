class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1) {
            return word;
        }

        String ans = "";
        int longestPossibleLength = n - (numFriends - 1);

        for(int i = 0; i < n; i++) {
            int canTakeLength = Math.min(longestPossibleLength, n - i);
            String subStr = word.substring(i, i + canTakeLength);
            if(subStr.compareTo(ans) > 0) {
                ans = subStr;
            }
        }

        return ans;
    }
}