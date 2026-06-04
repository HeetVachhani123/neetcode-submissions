public class Solution {
    // Helper class to couple timestamp and website together
    static class Visit {
        int timestamp;
        String website;
        
        Visit(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> userVisits = new HashMap<>();
        int n = username.length;
        
        // Step 1: Group visits by username
        for (int i = 0; i < n; i++) {
            userVisits.computeIfAbsent(username[i], k -> new ArrayList<>())
                      .add(new Visit(timestamp[i], website[i]));
        }
        
        // Global frequency map for patterns
        Map<List<String>, Integer> patternMap = new HashMap<>();
        
        // Step 2: Generate unique patterns of 3 websites per user
        for (String user : userVisits.keySet()) {
            List<Visit> visits = userVisits.get(user);
            
            // Sort this user's visits chronologically
            visits.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));
            
            Set<List<String>> uniquePatternsForUser = new HashSet<>();
            int size = visits.size();
            
            // Generate all combinations of 3 websites (Subsequences)
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        List<String> pattern = Arrays.asList(
                            visits.get(i).website, 
                            visits.get(j).website, 
                            visits.get(k).website
                        );
                        uniquePatternsForUser.add(pattern);
                    }
                }
            }
            
            // Update the global count with this user's unique patterns
            for (List<String> pattern : uniquePatternsForUser) {
                patternMap.put(pattern, patternMap.getOrDefault(pattern, 0) + 1);
            }
        }
        
        // Step 3: Find the pattern with the highest score & handle tie-breakers
        List<String> bestPattern = null;
        int maxScore = 0;
        
        for (Map.Entry<List<String>, Integer> entry : patternMap.entrySet()) {
            List<String> pattern = entry.getKey();
            int score = entry.getValue();
            
            if (score > maxScore) {
                maxScore = score;
                bestPattern = pattern;
            } else if (score == maxScore) {
                if (bestPattern == null || isLexicographicallySmaller(pattern, bestPattern)) {
                    bestPattern = pattern;
                }
            }
        }
        
        return bestPattern;
    }
    
    // Helper method to compare two 3-website lists lexicographically
    private boolean isLexicographicallySmaller(List<String> a, List<String> b) {
        for (int i = 0; i < 3; i++) {
            int comp = a.get(i).compareTo(b.get(i));
            if (comp != 0) {
                return comp < 0;
            }
        }
        return false;
    }
}