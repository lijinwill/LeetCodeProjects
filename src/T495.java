/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/16 16:22
 */
public class T495 {
    public static void main(String[] args) {
        int[] timeSeries = new int[]{};
        int duration = 10000;
        System.out.println(T495.findPoisonedDuration(timeSeries, duration));

    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int len = timeSeries.length;
        if (len==0){
            return 0;
        }
        int time = 0;

        int i;
        for (i = 0; i < len-1; i++) {
            if (timeSeries[i]+duration <= timeSeries[i+1]){
                time = time + duration;
            }else{
                time = time+ timeSeries[i+1] - timeSeries[i];
            }
        }
        time = time + duration;

        return time;
    }
}
