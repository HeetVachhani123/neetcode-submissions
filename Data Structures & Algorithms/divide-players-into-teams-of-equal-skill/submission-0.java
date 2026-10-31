class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length, target = skill[0] + skill[n - 1];
        long answer = 0;
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - 1 - i] != target)
                return -1;
            answer += (long) skill[i] * skill[n - 1 - i];
        }
        return answer;
    }
}
