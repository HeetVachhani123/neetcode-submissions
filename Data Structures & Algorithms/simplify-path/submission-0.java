class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        
        // 1. Split the path by slashes
        String[] components = path.split("/");
        
        // 2. Process each component
        for (String dir : components) {
            // Ignore empty strings (from multiple slashes) and current directory '.'
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } 
            // Pop from stack if we encounter '..' and the stack isn't empty
            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); 
                }
            } 
            // Push valid directory names onto the stack
            else {
                stack.offerLast(dir);
            }
        }
        
        // 3. Reconstruct the simplified canonical path
        StringBuilder result = new StringBuilder();
        
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        
        // If the stack was empty, return root "/", otherwise return the built path
        return result.length() > 0 ? result.toString() : "/";
    }
}