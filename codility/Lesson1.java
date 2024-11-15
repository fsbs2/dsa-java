package codility;

public class Lesson1 {
    /*
    *A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
    * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
    * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
    * The number 20 has binary representation 10100 and contains one binary gap of length 1.
    * The number 15 has binary representation 1111 and has no binary gaps.
    * The number 32 has binary representation 100000 and has no binary gaps.
    *
    * Write a function:
    * class Solution { public int solution(int N); }
    * That, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
    *
    * For example, given N = 1041 the function should return 5,
    * because N has binary representation 10000010001 and so its longest binary gap is of length 5.
    * Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
    Write an efficient algorithm for the following assumptions:
        N is an integer within the range [1..2,147,483,647].
    *
    * */

    public static void main(String[] args) {
        System.out.println(solution2(20));
    }

    //Dave Kirkwood solution
    public static int solution(int n) {

        char[] l = Integer.toBinaryString(n).toCharArray();

        int counter = 0;
        int maxCount = 0;
        boolean started = false;
        for(int i=0; i< l.length; i++){
            if(l[i] == '1'){
                if(started){
                    if(counter > maxCount) maxCount = counter;
                }
                counter = 0;
                started = true;
            }else{
                counter++;
            }
        }
        return maxCount;
    }

    //r9software solution
    public static int solution2(int n) {
        int finalGap = 0;
        //1 is  0
        if (n == 1) {
            return 0;
        }
        //use the shortest way to convert to a binary representation
        char[] binaryRep = Integer.toBinaryString(n).toCharArray();
        int tempGap=0;
        //the binary representation must start with 1 we continue counting the 0 while
        // we found a new one, and then return the longest binary gap
        // the binary numbers ending on 0 cant be counted because it should be 1 0000..1
        // to be a valid gap
        for (int x = 0; x < binaryRep.length; x++) {
            if(binaryRep[x]=='0'){
                tempGap++;
                continue;
            }else if(binaryRep[x]=='1'){
                if(tempGap>finalGap)
                    finalGap=tempGap;
                tempGap=0;
            }

        }
        return finalGap;
    }

}
