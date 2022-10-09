package A_Coding_Test.Oppo;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/2 21:35
 */
public class Main3 {
    long count = 0;
    public long tourismRoutePlanning (int scenicspot) {
        // write code here
        //回溯

        Help(scenicspot);

        return count;
    }

    public void Help(int n){
        if (n == 0){
            count++;
            return;
        }

        if (n-1 >= 0) {
            Help(n - 1);
        }
        if (n-2 >= 0){
            Help(n-2);
        }
    }
}
