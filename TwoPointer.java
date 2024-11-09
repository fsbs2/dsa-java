public class TwoPointer {
    /*
    557. Reverse Words in a String II
    Given a string s, reverse the order of characters in
    each word within a sentence while still preserving whitespace
    and initial word order.

    Example 1:
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Example 2:
    Input: s = "Mr Ding"
    Output: "rM gniD"

    Constraints:

    1 <= s.length <= 5 * 104
    s contains printable ASCII characters.
    s does not contain any leading or trailing spaces.
    There is at least one word in s.
    All the words in s are separated by a single space.
    */

    public static void main(String[] args) {
        //my implementation
        String teste = "Gabriel Fernandes Silva";
        System.out.println(reverseWords(teste));

        System.out.println(reverseWordsOptimized(teste));
    }

    //by my own
    public static String reverseWords(String s) {
        StringBuilder resultado = new StringBuilder();
        if (s.length() == 1)
            return s;

        String[] words = s.split(" ");

        if(words.length == 1){
            return reverseWord(words[0]);
        }

        for (int w = 0; w < words.length; w++) {
            String rw = reverseWord(words[w]);
            words[w] = rw;

            if(w != words.length - 1){
                resultado.append(words[w]).append(" ");
            }else {
                resultado.append(words[w]);
            }
        }


        return resultado.toString();
    }

    //by my own
    public static String reverseWord(String w) {
        char[] result = new char[w.length()];
        char x;
        char y;
        int tail = w.length() - 1;


        for (int i = 0; i < w.length(); i++) {
            if (i == tail) {
                result[i] = w.charAt(i);
                return new String(result);
            }
            x = w.charAt(i);
            y = w.charAt(tail);

            result[i] = y;
            result[tail] = x;
            tail--;
        }
        return new String(result);
    }


   //Best Solution
    public static String reverseWordsOptimized(String s) {
        StringBuilder response = new StringBuilder();

        String[] words = s.split(" ");

        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            response.append(sb);

            if(words.length - 1 != i)
                response.append(" ");
        }

        return response.toString();
    }
}
