class Solution {
    public int[] sumPrefixScores(String[] words) {
        Map<Integer,Integer> edges=new HashMap<>();List<Integer> counts=new ArrayList<>();counts.add(0);for(String word:words){int node=0;for(char c:word.toCharArray()){int key=node*26+c-'a';if(!edges.containsKey(key)){edges.put(key,counts.size());counts.add(0);}node=edges.get(key);counts.set(node,counts.get(node)+1);}}int[] answer=new int[words.length];for(int i=0;i<words.length;i++){int node=0;for(char c:words[i].toCharArray()){node=edges.get(node*26+c-'a');answer[i]+=counts.get(node);}}return answer;
    }
}
