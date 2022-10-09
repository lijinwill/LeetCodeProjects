package Bit_Operation;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-08$ $
 */
public class T338 {
    public static void main(String[] args) {
        int n = 100000;
        T338 test = new T338();
        System.out.println(test.countBits(n));
    }

    /*思路：令 x = x & (x−1)，该运算将x的二进制表示的最后一个1变成0。
            因此，对x重复该操作，直到x变成0，则操作次数即为x的「一比特数」。
    */
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;

        for(int i=1; i<n+1; i++){
            int count = 0;
            int j = i;
            while(j>0){
                j = j&(j-1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }


    //思路：暴力统计
//    public int[] countBits(int n) {
//        int[] result = new int[n+1];
//        result[0] = 0;
//        for(int i=1; i<=n; i++){
//            String str = Integer.toBinaryString(i);
//            int count = 0;
//            for(int j=0; j<str.length(); j++){
//                if(str.charAt(j) == '1'){
//                    count++;
//                }
//            }
//            result[i] = count;
//        }
//        return result;
//    }
}
