package String_Practice;

/**
 * @Classname T459
 * @Description TODO
 * @Date 2022/7/8 12:58
 * @Created by Will
 */
public class T459 {
    public static void main(String[] args) {
        String s = "aabaaba";
        T459 test = new T459();
        System.out.println(test.repeatedSubstringPattern(s));
    }
    //思路：从一个字符遍历到一半长度的字符，且s的长度能被子串长度整除
    //     然后测试最终效果

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <=len/2; i++){
            String sub = s.substring(0, i);

            //这个部分用于判断子串是否可以重复构成s
            int left, right;
            for (left=0, right=i; right <= len; left+=i,right+=i){
                if (s.substring(left,right).compareTo(sub) != 0){
                    break;
                }
            }
            if (right == len+i){
                return true;
            }
        }
        return false;
    }
}
