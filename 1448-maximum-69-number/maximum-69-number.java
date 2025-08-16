class Solution {
    public int maximum69Number (int num) {
        String numS = String.valueOf(num);
        String modifiedNum = numS.replaceFirst("6","9");
        return Integer.valueOf(modifiedNum);
    }
}