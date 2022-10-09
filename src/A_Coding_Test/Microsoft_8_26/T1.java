package A_Coding_Test.Microsoft_8_26;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/26 18:35
 */
public class T1 {
    public static void main(String[] args) {
        String S = "bdaaadadb";
        T1 test = new T1();
        System.out.println(test.solution(S));
    }
    //思路：统计每个字符出现的次数，一个hashmap统计字符出现的次数，另一个hashmap统计字符出现的左位置，右位置
    //
    public int solution(String S) {
        // write your code in Java 11 (Java SE 11)
        int result = 0;

        int len = S.length();
        for (int i=0; i<len; i++){
            for (int j = i+2; j <= len; j=j+2) {
                int[] count = new int[26];
                String temp = S.substring(i,j);

                boolean flag = true;
                for (int k=0; k<temp.length(); k++){
                    int pos = temp.charAt(k)-'a';
                    count[pos]++;
                }
                for (int k=0; k<26; k++){
                    if (count[k]%2 != 0){
                        flag = false;
                        break;
                    }
                }
                if (flag == true){
                    result = Math.max(result, temp.length());
                }
            }
        }
        return result;

    }
}
