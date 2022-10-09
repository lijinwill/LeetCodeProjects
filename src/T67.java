/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/14 14:57
 */
public class T67 {
    public static void main(String[] args) {
        String a = "101";
        String b = "110";
        T67 test = new T67();
        String result = test.addBinary(a,b);
        System.out.println(result);
    }


//    我写的方法，4mm,超过22%的人
//    public String addBinary(String a, String b) {
//
//        int a_len = a.length();
//        int b_len = b.length();
//        int max_len = Math.max(a_len, b_len);
//
//        if (a.charAt(0)=='0' && b.charAt(0)=='0'){
//            return "0";
//        }
//
//        //将短的那个字符串补0，使得两个字符串一样长
//        StringBuilder a_extend = new StringBuilder(a);
//        StringBuilder b_extend = new StringBuilder(b);
//        if (a_len < b_len){
//            int b_a = b_len - a_len;
//            while(b_a != 0){
//                a_extend.insert(0, '0');
//                b_a--;
//            }
//        }else{
//            int a_b = a_len - b_len;
//            while(a_b != 0){
//                b_extend.insert(0, '0');
//                a_b--;
//            }
//        }
//
//        int i = max_len - 1;
//        StringBuilder sum = new StringBuilder(max_len);
//        int plus = 0;
//
//        while( i >= 0){
//            if ( a_extend.charAt(i)=='0' && b_extend.charAt(i)=='0' ){
//                if (plus == 0){
//                    sum.insert(0, '0');
//                }else{
//                    sum.insert(0, '1');
//                    plus = 0;
//                }
//            }
//            if ( a_extend.charAt(i)=='0' && b_extend.charAt(i)=='1' ){
//                if (plus == 0){
//                    sum.insert(0, '1');
//                }else {
//                    sum.insert(0, '0');
//                    plus = 1;
//                }
//            }
//            if ( a_extend.charAt(i)=='1' && b_extend.charAt(i)=='0' ){
//                if (plus == 0){
//                    sum.insert(0, '1');
//                }else {
//                    sum.insert(0, '0');
//                    plus = 1;
//                }
//            }
//            if ( a_extend.charAt(i)=='1' && b_extend.charAt(i)=='1' ){
//                if (plus == 0){
//                    sum.insert(0, '0');
//                    plus = 1;
//                }else{
//                    sum.insert(0, '1');
//                    plus = 1;
//                }
//            }
//
//            i--;
//        }
//
//        if(plus==1){
//            sum.insert(0, '1');
//        }
//
//
//        return sum.toString();
//    }

    //别人写的，自叹不如
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }


}
