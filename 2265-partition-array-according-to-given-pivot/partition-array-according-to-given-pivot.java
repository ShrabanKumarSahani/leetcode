class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int n = nums.length;
       List<Integer> lessPivot = new ArrayList<>();
       List<Integer> equalPivot = new ArrayList<>();
       List<Integer> greaterPivot = new ArrayList<>();

       for(int num : nums) {
        if(num < pivot) {
            lessPivot.add(num);
        } else if(num == pivot) {
            equalPivot.add(num);
        } else {
            greaterPivot.add(num);
        }
       }

       List<Integer> ans = new ArrayList<>();
        ans.addAll(lessPivot);
        ans.addAll(equalPivot);
        ans.addAll(greaterPivot);

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
/**
TC = O(n)
SC = O(n) 
*/