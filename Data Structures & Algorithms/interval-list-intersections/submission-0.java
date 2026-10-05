public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            int startA = firstList[i][0], endA = firstList[i][1];
            for (int j = 0; j < secondList.length; j++) {
                int startB = secondList[j][0], endB = secondList[j][1];
                if ((startA <= startB && startB <= endA) || (startB <= startA && startA <= endB)) {
                    res.add(new int[]{Math.max(startA, startB), Math.min(endA, endB)});
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}