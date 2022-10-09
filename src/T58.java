/**
 * @author Will
 * @version 1.0
 * @description: 因为可能出现"Hello world   " 这种情况，则从后往前计算会简单的多
 * @date 2020/11/13 16:42
 */
public class T58 {
    public static void main(String[] args) {
        String s = "   ";
        T58 test = new T58();
        int length = test.lengthOfLastWord(s);
        System.out.println(length);
    }
    public int lengthOfLastWord(String s) {
        //如果不存在单词，返回 0
        if (s.length() == 0){
            return 0;
        }
        //如果全空，返回0
        String sTrim = s.trim();
        if(sTrim.equals("")){
            return 0;
        }

        int i = s.length() - 1;

        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int lastp = i;
        lastp++;


        while(i>0 && s.charAt(i) != ' '){
            i--;
        }

        int firstp = i;
        if(s.charAt(i) == ' '){
            firstp++;
        }

        String substring = s.substring(firstp,lastp);
        return substring.length();
    }
}
