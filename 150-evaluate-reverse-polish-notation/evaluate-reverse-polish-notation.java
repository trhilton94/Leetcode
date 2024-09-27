class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int num1 = 0;
        int num2 = 0;

        while (index < tokens.length) {
            if (isNumber(tokens[index])) {
                stack.push(Integer.parseInt(tokens[index]));
                index++;
                continue;
            } // if

            num2 = stack.peek();
            stack.pop();
            num1 = stack.peek();
            stack.pop();

            switch (tokens[index]) {
                case "+": stack.push(num1 + num2);
                          break;
                case "-": stack.push(num1 - num2);
                          break;
                case "*": stack.push(num1 * num2);
                          break;
                case "/": stack.push(num1 / num2);
                          break;
            } // switch
            index++;
        } // while

        return stack.peek();
    } // evalRPN

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);  // or Double.parseDouble(str) for decimals
            return true;
        } catch (NumberFormatException e) {
            return false;
        } // try/catch
    } // isNumber

} // Solution