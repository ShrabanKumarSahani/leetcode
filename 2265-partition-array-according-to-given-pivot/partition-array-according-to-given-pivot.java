class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int n = nums.length;
       
       int countLess = 0;
       int countEqual = 0;
       
       for(int num : nums) {
        if(num < pivot) {
            countLess++;
        } else if(num == pivot) {
            countEqual++;
        }
       }

       int i = 0;           // < pivot
       int j = countLess;   // == pivot
       int k = countLess + countEqual; // > pivot
       int[] ans = new int[n];

        for(int num : nums) {
            if(num < pivot) {
                ans[i] = num;
                i++;
            } else if(num == pivot) {
                ans[j] = num;
                j++;
            } else {
                ans[k] = num;
                k++;
            }
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n) 
*/