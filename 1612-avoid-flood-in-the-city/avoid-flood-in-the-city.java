class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> mp = new HashMap<>();     // lake -> last day it got filled
        TreeSet<Integer> dryDays = new TreeSet<>();     // indices of dry days -> rain[i] == 0

        int[] ans = new int[n];
        Arrays.fill(ans, 1);        // defaulting all dry days to dry lake 1

        for(int i = 0; i < n; i++) {
            int lake = rains[i];
            if(lake == 0) {
                dryDays.add(i);
            } else {
                ans[i] = -1;    // raining day -> can't dry any lake
                if(mp.containsKey(lake)) {     // lake already filled previously
                    Integer dryDay = dryDays.higher(mp.get(lake));  // next dry day it was last filled
                    if(dryDay == null) {    // no dry day available to empty this lake before raining again -> flood
                        return new int[0];
                    }
                    ans[dryDay] = lake;     // use this dry day to dry the lake
                    dryDays.remove(dryDay);
                }
                mp.put(lake, i);            // record latest day this lake was filled
            }
        }
        return ans;
    }
}
/**
TC = O(nlogn)
SC = O(n) */