package A_Coding_Test.Microsoft_8_19;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/19 19:46
 */
public class T2 {
    public static void main(String[] args) {
        String S = "89988";
        T2 test = new T2();
        System.out.println(test.solution(S));
    }
    //思路，先用int[][]统计每个数字及其出现的频率
    //  将出现频率最大的数，置于两端，直到所有数字出现频率降为奇数
    //  然后将其中最大的数放置在中间，并返回字符串
    public String solution(String S) {

        //统计频率
        int[] numFreq = new int[10];

        for (int i=0; i<S.length(); i++){
            //temp表明S的一个数字
            int temp = (int)S.charAt(i) - (int)('0');
            numFreq[temp]++;
        }

        StringBuffer sbLeft = new StringBuffer();
        StringBuffer sbRight = new StringBuffer();
        //将成双出现的数字解决掉
        for (int i = 9; i >=0 ; i--) {
            //如果是全0的情况
            if (i == 0 && sbLeft.length() == 0) break;
            for (int j=numFreq[i]; j>1; j=j-2){
                sbLeft.append(i);
                sbRight.append(i);
                numFreq[i] = numFreq[i] - 2;
            }
        }
        //将单个数字解决掉
        for (int i=9; i>=0; i--){
            if (numFreq[i] == 1){
                sbLeft.append(i);
                break;
            }
            if (numFreq[0] > 0){
                return "0";
            }
        }
        sbRight.reverse();
        sbLeft.append(sbRight);
        return sbLeft.toString();
    }
}
