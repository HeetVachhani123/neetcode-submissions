import heapq
from collections import defaultdict

class Solution:
    def maxProbability(self, n: int, edges: list[list[int]], succProb: list[float], start: int, end: int) -> float:
        # 1. Build the adjacency list graph
        graph = defaultdict(list)
        for i, (u, v) in enumerate(edges):
            prob = succProb[i]
            graph[u].append((v, prob))
            graph[v].append((u, prob))
        
        # 2. Array to store the maximum probability to reach each node
        max_prob = [0.0] * n
        max_prob[start] = 1.0
        
        # 3. Max-Heap (stored as negative values because Python heapq is a min-heap)
        # Element format: (-probability, node)
        pq = [(-1.0, start)]
        
        while pq:
            curr_prob, curr_node = heapq.heappop(pq)
            curr_prob = -curr_prob  # Convert back to positive
            
            # If we reached the destination, this is the optimal path
            if curr_node == end:
                return curr_prob
            
            # If we found a larger probability path to curr_node already, skip this stale record
            if curr_prob < max_prob[curr_node]:
                continue
                
            # 4. Explore neighbors
            for neighbor, edge_prob in graph[curr_node]:
                new_prob = curr_prob * edge_prob
                
                # If the new path yields a higher probability, update and push to heap
                if new_prob > max_prob[neighbor]:
                    max_prob[neighbor] = new_prob
                    heapq.heappush(pq, (-new_prob, neighbor))
                    
        # If the end node is unreachable
        return 0.0