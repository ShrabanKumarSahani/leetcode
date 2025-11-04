class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            if(j-i+1 == k) {
                ans.add(findTopXSum(mp, x));
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);   
                }
                i++;
            }
            j++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int findTopXSum(Map<Integer, Integer> mp, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] == b[0]) ? a[1] - b[1]: a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();

            pq.offer(new int[]{freq, val});

            if(pq.size() > x) {
                pq.poll();
            }
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += pair[0] * pair[1];
        }

        return sum;
    }
}