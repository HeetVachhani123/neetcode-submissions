class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        for (int num : nums) {
            freq[num + 1000]++;
        }

        int[] countsPerFreq = new int[nums.length + 1];
        for (int f : freq) {
            if (f > 0) {
                countsPerFreq[f]++;
            }
        }

        int[][] buckets = new int[nums.length + 1][];
        for (int i = 0; i <= nums.length; i++) {
            if (countsPerFreq[i] > 0) {
                buckets[i] = new int[countsPerFreq[i]];
            }
        }

        int[] index = new int[nums.length + 1];
        for (int i = 0; i < 2001; i++) {
            if (freq[i] > 0) {
                int f = freq[i];
                buckets[f][index[f]++] = i - 1000;
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    res[idx++] = val;
                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}