class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocked=new HashSet<>();for(int[] p:obstacles)blocked.add(p[0]+","+p[1]);int[] dx={0,1,0,-1},dy={1,0,-1,0};int x=0,y=0,d=0,answer=0;for(int c:commands){if(c==-2)d=(d+3)%4;else if(c==-1)d=(d+1)%4;else for(int i=0;i<c;i++){int nx=x+dx[d],ny=y+dy[d];if(blocked.contains(nx+","+ny))break;x=nx;y=ny;answer=Math.max(answer,x*x+y*y);}}return answer;
    }
}
