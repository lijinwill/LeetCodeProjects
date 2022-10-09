package String_Practice;

/**
 * @Classname T28_2
 * @Description TODO
 * @Date 2022/7/8 12:48
 * @Created by Will
 */
public class T28_2 {
    public int strStr(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();

        for (int i=0; i<lenH-lenN+1; i++){
            if (haystack.substring(i,i+lenN).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
