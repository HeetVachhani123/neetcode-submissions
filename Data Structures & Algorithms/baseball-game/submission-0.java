
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            switch (op) {
                case "+":
                    int last = stack.pop();
                    int secondLast = stack.peek();
                    int newScore = last + secondLast;
                    stack.push(last); // Put back the last score
                    stack.push(newScore); // Push the sum
                    break;
                    
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                    
                case "C":
                    stack.pop();
                    break;
                    
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        
        int totalSum = 0;
        for (int score : stack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}