class Solution {
    private int nums1Length;
    private int nums2Length;
    private int[] firstSortedArr;
    private int[] secondSortedArr;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        nums1Length = nums1.length;
        nums2Length = nums2.length;
        this.firstSortedArr = nums1;
        this.secondSortedArr = nums2;

        int leftMedianElement = findKthSmallest(0, 0, (nums1Length + nums2Length + 1)/2);
        int rightMedianElement = findKthSmallest(0, 0, (nums1Length + nums2Length + 2)/2);
        return (leftMedianElement + rightMedianElement) / 2.0;
    }

    private int findKthSmallest(int firstArrStartIdx, int secondArrStartIndex, int k) {
        if(firstArrStartIdx >= nums1Length) {
            return secondSortedArr[secondArrStartIndex + k - 1];
        }
        if(secondArrStartIndex >= nums2Length) {
            return firstSortedArr[firstArrStartIdx + k - 1];
        }
        if(k == 1) {
            return Math.min(firstSortedArr[firstArrStartIdx], secondSortedArr[secondArrStartIndex]);
        }
        int halfK = k/2;

        int firstArrayMidValue = (firstArrStartIdx + halfK - 1 < nums1Length) ? firstSortedArr[firstArrStartIdx + halfK - 1] : Integer.MAX_VALUE;

        int secondArrayMidValue = (secondArrStartIndex + halfK - 1 < nums2Length) ? secondSortedArr[secondArrStartIndex + halfK - 1] : Integer.MAX_VALUE;

        if(firstArrayMidValue < secondArrayMidValue) {
            return findKthSmallest(firstArrStartIdx + halfK, secondArrStartIndex, k - halfK);
        } else {
            return findKthSmallest(firstArrStartIdx, secondArrStartIndex + halfK, k - halfK);
        } 

    }
}