public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] == ratings[i + 1]) {
                continue;
            }
            if (ratings[i + 1] > ratings[i]) {
                arr[i + 1] = arr[i] + 1;
            } else if (arr[i] == arr[i + 1]) {
                arr[i + 1] = arr[i];
                arr[i]++;
                for (int j = i - 1; j >= 0; j--) {
                    if (ratings[j] > ratings[j + 1]) {
                        if (arr[j + 1] < arr[j]) {
                            break;
                        }
                        arr[j]++;
                    }
                }
            }
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}