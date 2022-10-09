package String_Practice;

/**
 * @Classname Toffer05
 * @Description TODO
 * @Date 2022/7/8 10:15
 * @Created by Will
 */
public class T_offer05 {
    public String replaceSpace(String s) {
        StringBuffer strB = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if (temp != ' '){
                strB.append(temp);
            }else{
                strB.append("%20");
            }
        }
        return strB.toString();
    }
}
