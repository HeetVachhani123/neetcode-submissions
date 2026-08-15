class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int count = 0;
        for(int i=0;i<n-1;i++){
            if(people[i] == limit){
                count ++;
            }
            for(int j=1;j<n;j++){
                if(people[i] + people[j] == limit){
                    count++;
                }
            }
        }
        return count;
    }
}