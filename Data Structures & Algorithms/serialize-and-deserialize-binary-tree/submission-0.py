# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res = []
        
        def dfs(node):
            if not node:
                res.append("N")
                return
            res.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
            
        dfs(root)
        # For Example 1, this turns into: "1,2,N,N,3,4,N,N,5,N,N"
        return ",".join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        vals = data.split(",")
        self.i = 0 # Pointer to track our current position in the array
        
        def dfs():
            if vals[self.i] == "N":
                self.i += 1
                return None
            
            # Create node with the current value
            node = TreeNode(int(vals[self.i]))
            self.i += 1
            
            # Recursively build the left and right subtrees
            node.left = dfs()
            node.right = dfs()
            
            return node
            
        return dfs()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))