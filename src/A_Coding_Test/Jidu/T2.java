package A_Coding_Test.Jidu;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/13 18:39
 */
public class T2 {

    public boolean isEquals (String str1, String str2) {
        // write code here
        if (str1.length() != str2.length()) return false;

        int[] str1Count = new int[26];
        int[] str2Count = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            int pos1 = str1.charAt(i) - 'a';
            str1Count[pos1]++;
            int pos2 = str2.charAt(i) - 'a';
            str2Count[pos2]++;
        }

        for (int i = 0; i < 26; i++) {
            if (str1Count[i] != str2Count[i]){
                return false;
            }
        }
        return true;
    }
}
