import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/18 16:02
 */
public class T88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,7,9,0,0,0};
        int[] nums2 = new int[]{2,4,6};
        T88 test = new T88();
        test.merge(nums1,5,nums2, nums2.length);

        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

}
