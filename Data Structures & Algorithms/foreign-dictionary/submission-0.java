
public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // Adjacency list to represent the directed graph of characters
        Map<Character, Set<Character>> graph = new HashMap<>();
        // Map to keep track of the incoming edges (in-degrees) for each unique character
        Map<Character, Integer> inDegree = new HashMap<>();

        // Step 1: Initialize the graph and in-degree map with all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Step 2: Build relationships by comparing adjacent pairs of words
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // Edge Case: If the next word is a prefix of the current word but shorter (e.g., "abc" before "ab"),
            // this breaks the standard lexicographical rule. The dictionary is invalid.
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                return "";
            }

            int minLength = Math.min(currentWord.length(), nextWord.length());
            for (int j = 0; j < minLength; j++) {
                char parent = currentWord.charAt(j);
                char child = nextWord.charAt(j);

                // Find the first character mismatch to establish a dependency rule
                if (parent != child) {
                    // Only process if this relationship hasn't been added yet
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    // Characters after the first mismatch do not give ordering information
                    break; 
                }
            }
        }

        // Step 3: Kahn's Algorithm for Topological Sort (BFS)
        Queue<Character> queue = new LinkedList<>();
        // Add all characters that have no dependencies (in-degree == 0) to the processing queue
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder orderedAlphabet = new StringBuilder();
        while (!queue.isEmpty()) {
            char currentCharacter = queue.poll();
            orderedAlphabet.append(currentCharacter);

            // Decrease the dependency count for all neighbors
            for (char neighbor : graph.get(currentCharacter)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                // If a neighbor has no more remaining dependencies, it's ready to be sorted
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check for cycles or completeness
        // If the processed string doesn't contain all unique characters, a cycle exists (e.g., a -> b -> a)
        if (orderedAlphabet.length() < inDegree.size()) {
            return "";
        }

        return orderedAlphabet.toString();
    }
}