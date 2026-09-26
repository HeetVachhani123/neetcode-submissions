public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Set<String> folder_set = new HashSet<>(Arrays.asList(folder));

        for (String f : folder) {
            res.add(f);
            for (int i = 0; i < f.length(); i++) {
                if (f.charAt(i) == '/' && folder_set.contains(f.substring(0, i))) {
                    res.remove(res.size() - 1);
                    break;
                }
            }
        }
        return res;
    }
}