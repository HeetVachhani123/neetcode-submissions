class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        // 1. Extract starts and ends from the List<Interval>
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        // 2. Sort both arrays independently
        Arrays.sort(starts);
        Arrays.sort(ends);

        int startPointer = 0;
        int endPointer = 0;
        int usedRooms = 0;

        // 3. Compare start and end times step-by-step
        while (startPointer < n) {
            // Check intersection logic:
            // Does the next meeting start BEFORE the earliest active meeting ends?
            if (starts[startPointer] < ends[endPointer]) {
                usedRooms++; // Conflict! We need a new room
            } else {
                // No conflict! An old meeting finished, so a room freed up
                endPointer++; // Look at the next meeting's end time
            }
            startPointer++; // Move to check the next meeting
        }
        return usedRooms;
    }
}