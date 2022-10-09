package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/10 9:26
 * @date 2022/05/16
 */
public class T860 {
    public static void main(String[] args) {
        int[] bills = new int[]{};
        T860 test = new T860();
        System.out.println(test.lemonadeChange(bills));
    }

    /**思路：记录5的个数与10的个数，遇到5直接count5++；
     *      遇到10，如果count5>0，count5--，count10++;
     *      遇到20，必须count5>0 && count10>0；如果不满足，直接返回false，
     *      满足则count5--，count10--；
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i=0; i< bills.length; i++){
            if (bills[i] == 5){
                count5++;
            } else if (bills[i] == 10) {
                if(count5 > 0){
                    count5--;
                    count10++;
                }else{
                    return false;
                }
            } else if (bills[i] == 20){
                if(count5>0 && count10>0){
                    count5--;
                    count10--;
                }else if (count5>=3){
                    count5 -= 3;
                } else{
                    return false;
                }
            }
        }
        return true;
    }



//    public static boolean lemonadeChange(int[] bills) {
//        int len = bills.length;
//
//        int five = 0;
//        int ten = 0;
//
//        for (int i=0; i< bills.length; i++){
//            if (bills[i]==5){
//                five++;
//            }else if (bills[i]==10){
//                if (five>0){
//                    ten++;
//                    five--;
//                }else{
//                    return false;
//                }
//            }else{
//                if (ten>0 && five>0){
//                    ten--;
//                    five--;
//                }else if (ten==0 && five>=3){
//                    five = five - 3;
//                }else{
//                    return false;
//                }
//            }
//        }
//
//
//        return true;
//    }
}
