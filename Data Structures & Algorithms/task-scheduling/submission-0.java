public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        int maxFreq = 0;
        
        // Count frequencies and track the maximum frequency
        for (char task : tasks) {
            frequencies[task - 'A']++;
            maxFreq = Math.max(maxFreq, frequencies[task - 'A']);
        }
        
        // Count how many tasks share the maximum frequency
        int maxFreqCount = 0;
        for (int freq : frequencies) {
            if (freq == maxFreq) {
                maxFreqCount++;
            }
        }
        
        // Calculate chunks and minimum intervals needed
        int chunks = maxFreq - 1;
        int chunkSize = n + 1;
        int totalSlotsNeeded = chunks * chunkSize + maxFreqCount;
        
        // If we have more tasks than slots, we won't need idles at all
        return Math.max(tasks.length, totalSlotsNeeded);
    }
}