package A_Coding_Test.YouKa;

import java.util.LinkedList;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/6 20:13
 */
public class test3 {
    public String removeDuplicates (String s, int k) {
        // write code here
        StringBuffer sb = new StringBuffer();
        LinkedList<Character> list = new LinkedList<>();
        char ch;
        boolean flag = true;
        while(flag){
            sb.delete(0,sb.length());
            flag = false;
            list.clear();
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (list.isEmpty()){
                    list.add(ch);
                } else if (ch != list.peek()) {
                    if (list.size()>k){
                        list.clear();
                        flag =true;
                    }else{
                        while(!list.isEmpty()){
                            sb.append(list.poll());
                        }

                    }
                    list.add(ch);
                }else{
                    list.add(ch);

                }
            }
            if (!list.isEmpty()){
                for (Character c : list) {
                    sb.append(c);
                }
            }
            s = sb.toString();
        }
        return sb.toString();
    }
}
