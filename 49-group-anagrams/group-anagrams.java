class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGps = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);                       // sorting to get unique key
            String sortedKey = String.valueOf(arr); // making new unique key

            // checking if unique key exists -> if exist then add or create new
            anagramGps.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);  
        } 
        return new ArrayList<>(anagramGps.values());
    }
}
/**
TC = O(nklogk)
SC = O(nk) 
*/