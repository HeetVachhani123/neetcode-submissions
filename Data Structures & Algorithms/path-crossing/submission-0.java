
class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();
        
        // Add the initial starting point
        visited.add(x + "," + y);
        
        for (char direction : path.toCharArray()) {
            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            }
            
            String currentPos = x + "," + y;
            
            // If the set already contains this coordinate string, we crossed paths
            if (visited.contains(currentPos)) {
                return true;
            }
            
            visited.add(currentPos);
        }
        
        return false;
    }
}