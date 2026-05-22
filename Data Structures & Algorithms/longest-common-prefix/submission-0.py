class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""
            
        # Sort the strings lexicographically
        strs.sort()
        
        first = strs[0]
        last = strs[-1]
        res = ""
        
        # Compare characters of the first and last strings
        for i in range(min(len(first), len(last))):
            if first[i] != last[i]:
                break
            res += first[i]
            
        return res