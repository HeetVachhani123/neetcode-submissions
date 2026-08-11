class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int x : arr1)
            count[x]++;

        int k = 0;

        // Elements according to arr2
        for (int x : arr2) {
            while (count[x]-- > 0)
                arr1[k++] = x;
        }

        // Remaining elements in ascending order
        for (int x = 0; x <= 1000; x++) {
            while (count[x]-- > 0)
                arr1[k++] = x;
        }
        return arr1;
    }
}