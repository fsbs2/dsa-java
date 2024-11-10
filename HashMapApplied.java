import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        //387. First Unique Character in a String
       /* String ex1 = "leetcode";
        String ex2 = "loveleetcode";
        String ex3 = "aabb";
        System.out.println(firstUniqChar(ex1));
        System.out.println(firstUniqChar(ex2));
        System.out.println(firstUniqChar(ex3));*/

        //1.Two Sum
        int[] numbers = {2,5,5,11};
        System.out.println(Arrays.toString(htTwoSum(numbers, 10)));

    }

    //my solution
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
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

    /*
      1. Two Sum
      Given an array of integers nums and an integer target,
      return indices of the two numbers such that they add up to target.
      You may assume that each input would have exactly one solution, and you may not use the same element twice.
      You can return the answer in any order.

      Example 1:
      Input: nums = [2,7,11,15], target = 9
      Output: [0,1]
      Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

      Example 2:
      Input: nums = [3,2,4], target = 6
      Output: [1,2]

      Example 3:
      Input: nums = [3,3], target = 6
      Output: [0,1]

     */

    //my own solution
    //Brute Force
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            result[0] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                result[1] = nums[j];
                if(result[0] + result[1] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }


    //Hash Table
    public static int[] htTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}
