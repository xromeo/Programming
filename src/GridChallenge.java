
/*
Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.

Example

The grid is illustrated below.

a b c
a d e
e f g
The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridChallenge {

    static String gridChallenge(List<String> grid) {
        List<List<String>> ordered = new ArrayList<>();
        int n = grid.size();
        int m = grid.get(0).length();
        for (String s : grid) {
            String[] row = s.split("");
            Arrays.sort(row);
            ordered.add(Arrays.asList(row));
        }

        for (int k = 0; k < m; k++) {
            for (int i = 1; i < n; i++) {
                char c = ordered.get(i).get(k).charAt(0);
                char cp = ordered.get(i-1).get(k).charAt(0);
                if(cp > c){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("mpxz", "abcd", "wlmf");
        System.out.println(GridChallenge.gridChallenge(lista));
        List<String> lista2 = Arrays.asList("abc", "hjk", "mpq", "rtv");
        System.out.println(GridChallenge.gridChallenge(lista2));
    }
}
