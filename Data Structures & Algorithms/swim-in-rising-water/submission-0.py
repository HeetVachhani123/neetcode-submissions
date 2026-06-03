from collections import deque

class Solution:
    def swimInWater(self, grid: list[list[int]]) -> int:
        n = len(grid)
        low = grid[0][0]
        high = n * n - 1
        result = high
        
        # Helper function to check if a path exists when water level is capped at 't'
        def has_valid_path(t: int) -> bool:
            if grid[0][0] > t:
                return False
            
            queue = deque([(0, 0)])
            visited = [[False] * n for _ in range(n)]
            visited[0][0] = True
            
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            
            while queue:
                r, c = queue.popleft()
                
                if r == n - 1 and c == n - 1:
                    return True
                
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    
                    # Move only if inside boundaries, unvisited, and the elevation is <= t
                    if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] <= t:
                        visited[nr][nc] = True
                        queue.append((nr, nc))
                        
            return False

        # Binary search for the minimum viable time 't'
        while low <= high:
            mid = low + (high - low) // 2
            
            if has_valid_path(mid):
                result = mid      # 'mid' works, let's see if we can find a smaller time
                high = mid - 1
            else:
                low = mid + 1     # 'mid' is too low, we need more time
                
        return result