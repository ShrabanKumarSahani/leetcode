class Solution {
    public boolean isPowerOfThreeHelper(int n){
        if(n <= 0) return false;
        else if(n == 1) return true;
        else if(n % 3 != 0) return false;
        else return isPowerOfThreeHelper(n/3);
    } 
    
    public boolean isPowerOfThree(int n) {
        return isPowerOfThreeHelper(n);
    }
}