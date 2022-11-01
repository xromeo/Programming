
/*
 * 
 * In this problem, your task is to implement a simple text editor. Initially, a file contains an empty string S. Your task is to perform Q operations consisting of the following 4 types:

append(W) – Appends the string W at the end of S.
erase(k) – Erase the last k character of S.
get(k) – Returns the kth character of S.
undo() – Undo the last not previously undone operation of type 1 or 2, so it reverts S to the state before that operation.

Constraints
1≤Q≤10^5
1≤k≤|S|
The sum of the lengths of all W in the input ≤106
All input characters are lowercase English letters.
It is guaranteed that the sequence of input operation is possible to perform.

Input Format

The first line contains Q, the number of operations.
Each of the following Q lines contains a single integer t, denoting the type of operation listed in the problem statement. Then, t is followed by the argument of the operation, if it has any, separated by a space.

For example, if t=1t=1 then a single string WW follows. If t=2or 3, a single integer k follows.

Output Format

For each operation of type 3, print a single line with the returned character of that operation.
Sample Input
9
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
Sample Output
c
y
a
Explanation
There are 9operations. Initially, S is empty.
In the first operation, we append 
abc to S.
Then, we print its 3rdcharacter, which is cc at this point.
Next, we erase its last 3 characters, 
abc.
After that, we append xyto S.
S becomes xy after these previous two modifications.
Then, we are asked to return the 2nd character of 
S, which is 
y.
After that, we have to undo the last update to 
S, so S becomes empty.
The next operation asks us to undo the update before that, so 
S becomes 
abc again.
Finally, we are asked to print its 1stcharacter, which is 
a at this point.
 */

import java.util.Scanner;
import java.util.Stack;

 public class SimpleTextEditor {

    public static void main(String[] args) {
        Stack<StringBuilder> undo = new Stack<>();

        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();        
        StringBuilder text = new StringBuilder("");
        
        for (int i = 0; i < Q; i++) {
            int option = scan.nextInt();
            switch (option) {
                case 1: {          
                    String argument = scan.next();      
                    undo.push(new StringBuilder(text));
                    text.append(argument);
                }
                    break;
                case 2: {
                    undo.push(new StringBuilder(text));
                    int argument = scan.nextInt();   
                    int end = text.length() - argument;                    
                    text = new StringBuilder(text.substring(0, end));
                }
                    break;
                case 3: {                    
                    int index = scan.nextInt(); 
                    if (index <= text.length()) {
                        System.out.println(text.charAt(index - 1));
                    }
                }
                    break;
                case 4: {
                    text = undo.pop();
                }
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }


}


