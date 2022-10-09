package String_Practice;

/**
 * @Classname T541
 * @Description TODO
 * @Date 2022/7/7 15:41
 * @Created by Will
 */
public class T541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        T541 test = new T541();
        System.out.println(test.reverseStr(s,k));
    }
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] charArray = s.toCharArray();

        int start, end;//用于作为反转的左右指针
        for (int i=0; i<len; i+=2*k) {
            start = i;
            end = Math.min(len-1,i+k-1);
            while(start < end){
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }
}
