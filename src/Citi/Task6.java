package Citi;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/25 16:33
 */
public class Task6 {
    public static void main(String[] args) {
        String[] A = {"eva", "jqw", "tyn", "jan"};
        Task6 test = new Task6();
        System.out.println(test.solution(A));
    }
    public int solution(String[] A) {
        // write your code in Java SE 8
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                boolean concatable = allDifferent(A[i],A[j]);
                if(concatable == true){
                    result = Math.max(result, A[i].length()+A[j].length());
                }
            }
        }


        return result;
    }
    public boolean allDifferent(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
