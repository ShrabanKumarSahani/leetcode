class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int minElement = Integer.MAX_VALUE;

        // adding data in mp to find min element from basket1
        for(int num : basket1) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            minElement = Math.min(minElement, num);
        }

        // updating the map with elements from basket2
        for(int x : basket2) {
            mp.put(x, mp.getOrDefault(x, 0) - 1);
            minElement = Math.min(minElement, x);
        }

        ArrayList<Integer> finalList = new ArrayList<>();
        // processing the map to create finalist
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int cost = entry.getKey();
            int count = entry.getValue();

            if(count == 0) {
                continue;
            }

            if(count % 2 != 0) {
                return -1;          // counts are not even
            }

            // adding half of count to finalist
            for(int c = 1; c <= Math.abs(count)/2; c++) {
                finalList.add(cost);
            }
        }

        // find the min of elements
        Collections.sort(finalList);
        long ans = 0;


        // calculating the min cost by using least costs
        for(int i = 0; i < finalList.size()/2; i++) {
            ans += Math.min(finalList.get(i), minElement * 2);
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n)
*/