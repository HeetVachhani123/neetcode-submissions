class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int lo = 0;
        int hi = n-1;
        int count = 0;
        while(lo<=hi){
            if(people[lo] + people[hi] <= limit){              
                lo++;
            }
            hi--;
            count++;
        }
        return count;
    }
}