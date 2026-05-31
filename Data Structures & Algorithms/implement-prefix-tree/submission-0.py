from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1, n2 = len(s1), len(s2)
        
        if n1 > n2:
            return False
        
        s1_count = Counter(s1)
        window_count = Counter(s2[:n1])  # Initialize with the first window
        
        if s1_count == window_count:
            return True
            
        # Slide the window across s2
        for i in range(n1, n2):
            # Add the character entering the window
            window_count[s2[i]] += 1
            
            # Remove the character leaving the window
            left_char = s2[i - n1]
            window_count[left_char] -= 1
            if window_count[left_char] == 0:
                del window_count[left_char]  # Clean up keys to ensure exact matching
                
            # Compare current window count with s1 count
            if s1_count == window_count:
                return True
                
        return False