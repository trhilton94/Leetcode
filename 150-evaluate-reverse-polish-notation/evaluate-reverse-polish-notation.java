class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;

        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.valueOf(s));
                continue;
            } // if

            num2 = stack.pop();
            num1 = stack.pop();

            switch (s) {
                case "+": stack.push(num1 + num2);
                          break;
                case "-": stack.push(num1 - num2);
                          break;
                case "*": stack.push(num1 * num2);
                          break;
                case "/": stack.push(num1 / num2);
                          break;
            } // switch
        } // for

        return stack.pop();
    } // evalRPN

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } // try/catch
    } // isNumber

} // Solution