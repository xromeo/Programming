import java.util.regex.Pattern;

public class Vowels {
    public static void main(String[] args) {
        //int r = new Vowels().findingVowels("input");
        //int r = new Vowels().findingVowels2("input value");
        int r = new Vowels().findingVowels3("input value");
        System.out.println(r);    
    }

    int findingVowels(String input){
        int r = 0;
        for (int i = 0; i < input.length(); i++) {
            final char c = input.toLowerCase().charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                r++;
            }
        }

        return r;
    }

    int findingVowels2(String input){
        int r = 0;
        String vowels = "aeiou";
        char[] characters = input.toLowerCase().toCharArray();
        for (char c : characters){
            if(vowels.contains(Character.toString(c))){
                r++;
            }
        }

        return r;
    }

    int findingVowels3(String input){
        int r = 0;
        String regex = "[aeiou]";
        Pattern pattern = Pattern.compile(regex);
        String[] characters = input.toLowerCase().split("");
       
        for (String c : characters){
            if(pattern.matcher(c).matches()){
                r++;
            }
        }       

        return r;
    }
}
