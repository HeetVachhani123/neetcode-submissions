class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        class Builder {
            TreeNode build(int[] pre, int[] post) {
                if (pre.length == 0)
                    return null;
                TreeNode node = new TreeNode(pre[0]);
                if (pre.length > 1) {
                    int size = 1;
                    while (post[size - 1] != pre[1]) size++;
                    node.left = build(
                        Arrays.copyOfRange(pre, 1, size + 1), Arrays.copyOfRange(post, 0, size));
                    node.right = build(Arrays.copyOfRange(pre, size + 1, pre.length),
                        Arrays.copyOfRange(post, size, post.length - 1));
                }
                return node;
            }
        }
        return new Builder().build(preorder, postorder);
    }
}
