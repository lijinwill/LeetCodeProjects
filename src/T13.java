/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/1/16 23:35
 */
/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
*/

/**
 *
 * @description 算法思想：
 * 将每一个字符表示为数值，
 * 如果小数出现在大数左边，就让右边的大数减去小数，然后全部数值相加
 * 如果小数出现在大数右边，则直接全部数值相加
 * @author Will Li
 * @version
 * @date 2020年11月7日下午5:14:46
 *
 */

public class T13 {
    public static void main(String[] args) {
        T13 test = new T13();
        int number = test.romanToInt("MMMCCCXXXIII");
        System.out.println(number);
    }

    public int romanToInt(String s) {

        int sum = 0;
        int temp1, temp2;


        for (int i = 0; i < s.length(); i++) {


            temp1 = switchRtoI(s.charAt(i));

            if(i == s.length()-1) {//当扫描到最后一个时，直接加入sum，不用再算temp2
                sum = sum + temp1;
                break;
            }else {
                temp2 = switchRtoI(s.charAt(i+1));//未到最后一个，就需要算temp2
            }

            if(temp1 >= temp2) {//如果小数出现在大数右边，则直接全部数值相加
                sum = sum + temp1;
            }else {//如果小数出现在大数左边，就让右边的大数减去小数，然后全部数值相加
                sum = sum + temp2 - temp1;
                i++;
            }
        }

        return sum;
    }

    /**
     *
     * @description 输入一个罗马数字char，返回一个对应的数值
     * @author Will Li
     * @version
     * @date 2020年11月7日下午7:40:54
     * @param key
     * @return
     */
    public int switchRtoI(char key){
        int num = 0;
        switch (key) {
            case 'I': num = 1;
                break;
            case 'V': num = 5;
                break;
            case 'X': num = 10;
                break;
            case 'L': num = 50;
                break;
            case 'C': num = 100;
                break;
            case 'D': num = 500;
                break;
            case 'M': num = 1000;
                break;

        }
        return num;
    }
}

