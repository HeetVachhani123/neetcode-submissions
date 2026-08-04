class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int ptr = 0;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[ptr - 2] = stack[ptr - 2] + stack[ptr - 1];
                    ptr--;
                    break;
                case "-":
                    stack[ptr - 2] = stack[ptr - 2] - stack[ptr - 1];
                    ptr--;
                    break;
                case "*":
                    stack[ptr - 2] = stack[ptr - 2] * stack[ptr - 1];
                    ptr--;
                    break;
                case "/":
                    stack[ptr - 2] = stack[ptr - 2] / stack[ptr - 1];
                    ptr--;
                    break;
                default:
                    stack[ptr++] = Integer.parseInt(token);
                    break;
            }
        }

        return stack[0];
    }
}