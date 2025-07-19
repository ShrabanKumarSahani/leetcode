class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> res = new ArrayList<>();

        for (String currFolder : folder) {
            boolean isSubFolder = false;
            String tempFolder = currFolder;

            while (!currFolder.isEmpty()) {
                int pos = currFolder.lastIndexOf('/');
                if (pos == -1) // reached last string so break
                    break;
                currFolder = currFolder.substring(0, pos);
                if (folderSet.contains(currFolder)) { // check for parent folder exists in set
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) // if it's not subfolder then add it
                res.add(tempFolder);
        }

        return res;
    }
}
/**
 * TC = O(n*L^2)
 * SC = O(n)
 */