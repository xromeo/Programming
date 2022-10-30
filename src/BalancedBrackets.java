/*
 * Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.

Example: 

Input: exp = “[()]{}{[()()]()}” 
Output: Balanced
Explanation: all the brackets are well-formed

Input: exp = “[(])” 
Output: Not Balanced 
Explanation: 1 and 4 brackets are not balanced because 
there is a closing ‘]’ before the closing ‘(‘
 */

import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {                
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty()) {
                return "NO";
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return "NO";
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return "NO";
                    }
                    break;

                case ']':
                    check = stack.pop(); {
                    if (check == '(' || check == '{')
                        return "NO";
                }
                    break;
            }
        }

        return stack.isEmpty() ? "YES" : "NO";

    }

    public static void main(String[] args) {
        System.out.println(BalancedBrackets.isBalanced("{[()]}"));
        System.out.println(BalancedBrackets.isBalanced("{[(])}"));
        System.out.println(BalancedBrackets.isBalanced("{{[[(())]]}}"));
    }
}
