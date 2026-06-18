public class Solution {
    public int lastStoneWeight(int[] stones) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            
            if (y != x) {
                maxHeap.add(y - x);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}