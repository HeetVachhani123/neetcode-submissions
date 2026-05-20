/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index);
 * public int length();
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak index
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // We are on the increasing slope, peak is to the right
                left = mid + 1; 
            } else {
                // We are on the decreasing slope (or at the peak), peak is left or here
                right = mid;    
            }
        }
        int peak = left;
        
        // Step 2: Search the ascending part (0 to peak)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index; // Found on the left, this guarantees the minimum index
        }
        
        // Step 3: Search the descending part (peak + 1 to n - 1)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    // Helper function for Binary Search
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (ascending) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // Logic reversed for the descending side of the mountain
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }
}