class Solution {
    public String add(String a, String b) {
        if(a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0) {

            int x = a.charAt(i) - '0';
            int y = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = x + y + carry;

            ans.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }
        if(carry > 0)
            ans.append(carry);

        return ans.reverse().toString();
    }

    public String multiplyOne(String num1, int digit, int zeroes) {

        StringBuilder ans = new StringBuilder();
        int carry = 0;

        for(int i = num1.length() - 1; i >= 0; i--) {

            int x = num1.charAt(i) - '0';

            int product = x * digit + carry;

            ans.append(product % 10);
            carry = product / 10;
        }
        if(carry > 0)
            ans.append(carry);

        ans.reverse();

        for(int i = 0; i < zeroes; i++)
            ans.append('0');

        return ans.toString();
    }

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        String res = "0";

        int zeroes = 0;

        for(int i = num2.length() - 1; i >= 0; i--) {

            int digit = num2.charAt(i) - '0';

            String current = multiplyOne(num1, digit, zeroes);

            res = add(res, current);

            zeroes++;
        }
        return res;
    }
}