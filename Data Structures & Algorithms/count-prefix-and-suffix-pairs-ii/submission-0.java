class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        Map<Integer, Integer> edges = new HashMap<>();
        List<Integer> ends = new ArrayList<>();
        ends.add(0);
        long answer = 0;
        for (String word : words) {
            int node = 0;
            for (int i = 0; i < word.length(); i++) {
                int key = node * 676 + (word.charAt(i) - 'a') * 26
                    + word.charAt(word.length() - 1 - i) - 'a';
                if (!edges.containsKey(key)) {
                    edges.put(key, ends.size());
                    ends.add(0);
                }
                node = edges.get(key);
                answer += ends.get(node);
            }
            ends.set(node, ends.get(node) + 1);
        }
        return answer;
    }
}
