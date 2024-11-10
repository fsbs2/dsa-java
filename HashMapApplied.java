import java.util.HashMap;

public class HashMapApplied {
    /*
        387. First Unique Character in a String
        Given a string s,
        find the first non-repeating character in it and return its index.
        If it does not exist, return -1.

        Example 1:
        Input: s = "leetcode"
        Output: 0
        Explanation:
        The character 'l' at index 0 is the first character that does not occur at any other index.

        Example 2:
        Input: s = "loveleetcode"
        Output: 2

        Example 3:
        Input: s = "aabb"
        Output: -1

        Constraints:
        1 <= s.length <= 105
        s consists of only lowercase English letters.
        **/


    public static void main(String[] args) {
        String ex1 = "leetcode";

        String ex2 = "loveleetcode";

        String ex3 = "aabb";

        System.out.println(firstUniqChar(ex1));
        System.out.println(firstUniqChar(ex2));
        System.out.println(firstUniqChar(ex3));
    }

    //my solution
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }


    public static int bestFirstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c : chars) {
            System.out.println(c - 'a');
            count[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
