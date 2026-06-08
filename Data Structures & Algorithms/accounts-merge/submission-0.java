
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        
        // Step 1: Build the graph and email-to-name mapping
        for (List<String> account : accounts) {
            String name = account.get(0);
            // The problem guarantees at least one email is present
            String firstEmail = account.get(1); 
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                
                // Create undirected edges between the first email and the rest
                graph.computeIfAbsent(firstEmail, k -> new ArrayList<>()).add(email);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(firstEmail);
                
                // Map the email to the user's name
                emailToName.put(email, name);
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        // Step 2: Traverse the graph to find connected components
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(graph, email, visited, component);
                
                // Step 3: Sort the connected emails and prepend the name
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                mergedAccounts.add(component);
            }
        }
        
        return mergedAccounts;
    }
    
    // Helper method to perform DFS
    private void dfs(Map<String, List<String>> graph, String email, Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);
        
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }
}