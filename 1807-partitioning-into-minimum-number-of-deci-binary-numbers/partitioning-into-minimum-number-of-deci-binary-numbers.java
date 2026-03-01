class Solution {
    public int minPartitions(String n) {
        char maxCh = '0';
        for(char ch : n.toCharArray()) {
            maxCh = (char)Math.max(maxCh, ch);
        }
        return maxCh - '0';
    }
}
/**
TC = O(l)
SC = O(1) */