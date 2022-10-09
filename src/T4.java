import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/20 21:55
 */
public class T4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        double Median = T4.findMedianSortedArrays(nums1,nums2);
        System.out.println(Median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1_Len = nums1.length;
        int n2_Len = nums2.length;

        int nTotalLen = n1_Len + n2_Len;
        int[] nTotal = new int[nTotalLen];

        System.arraycopy(nums1,0, nTotal,0, n1_Len);
        System.arraycopy(nums2,0, nTotal, n1_Len, n2_Len);

        Arrays.sort(nTotal);

        if (nTotalLen%2 == 0){
            int a = nTotalLen/2;
            int b = a-1;
            double result = (double)(nTotal[a] + nTotal[b])/2;
            return result;
        }else{
            double result = nTotal[nTotalLen/2];
            return result;
        }

    }
}
