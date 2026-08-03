
public class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int delimiterIndex = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            i = delimiterIndex + 1;

            result.add(s.substring(i, i + length));
            i += length;
        }

        return result;
    }
}