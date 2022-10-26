import java.util.Arrays;
import java.util.List;

/**
 * MinimumBribes
 * 
 * It’s New Year’s Day and everyone’s in line for the Wonderland rollercoaster
 * ride! There are a number of people queued up, and each person wears a sticker
 * indicating their initial position in the queue. Initial positions increment
 * by 1 from 1 at the front of the line to at the back.
 * 
 * Any person in the queue can bribe the person directly in front of them to
 * swap positions. If two people swap positions, they still wear the same
 * sticker denoting their original places in line. One person can bribe at most
 * two others. For example, if n= 8 and Person 5 bribes Person 4 , the queue
 * will look like this: 1,2,3,5,4,6,7,8.
 * 
 * Fascinated by this chaotic queue, you decide you must know the minimum number
 * of bribes that took place to get the queue into its current state!
 * 
 * Function Description
 * 
 * Complete the function minimumBribes in the editor below. It must print an
 * integer representing the minimum number of bribes necessary, or Too chaotic
 * if the line configuration is not possible.
 * 
 * minimumBribes has the following parameter(s):
 * 
 * q: an array of integers
 * Input Format
 * 
 * The first line contains an integer , the number of test cases.
 * 
 * Each of the next pairs of lines are as follows:
 * - The first line contains an integer , the number of people in the queue
 * - The second line has space-separated integers describing the final state of
 * the queue.
 * 
 * Constraints
 * 
 * 1≤ t ≤10
 * 
 * 1≤ n ≤10⁵
 * 
 * Subtasks
 * 
 * For 60% score 1≤ n ≤10³
 * For 100% score 1≤ n ≤10⁵
 * 
 * Output Format
 * 
 * Print an integer denoting the minimum number of bribes needed to get the
 * queue into its final state. Print Too chaotic if the state is invalid, i.e.
 * it requires a person to have bribed more than people.
 * 
 * Sample Input
 * 
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * Sample Output
 * 
 * 3
 * Too chaotic
 * 
 */
public class MinimumBribes {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) == p1) {
                p1 = p2;
                p2 = p3;
                p3++;
            } else if (q.get(i) == p2) {
                // 2 1 3
                // 1 3 4
                bribes++;
                p2 = p3;
                p3++;
            } else if (q.get(i) == p3) {
                // 3 1 2
                // 1 2 4
                bribes += 2;
                p3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);
    }

    public static void minimumBribes2(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) != i + 1) {
                if ((i - 1) >= 0 && q.get(i - 1) == i + 1) {
                    bribes++;
                    swap(q, i, i - 1);
                } else if ((i - 2) >= 0 && q.get(i - 2) == i + 1) {
                    bribes += 2;
                    swap(q, i - 2, i - 1);
                    swap(q, i - 1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(bribes);
    }

    private static void swap(List<Integer> q, int i, int j) {
        Integer temp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, temp);

    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 3, 1, 6, 5, 4);
        MinimumBribes.minimumBribes2(array);
    }

}