class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String,Long> counts=new HashMap<>();long answer=0;for(int[] p:rectangles){int a=p[0],b=p[1];while(b!=0){int t=a%b;a=b;b=t;}String key=(p[0]/a)+","+(p[1]/a);long count=counts.getOrDefault(key,0L);answer+=count;counts.put(key,count+1);}return answer;
    }
}
