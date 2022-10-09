/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/1/16 23:35
 */
public class T14 {
    public static void main(String[] args) {
        T14 test = new T14();
        String[] strs1 = new String[] {"cir", "car"};
        String[] strs2 = new String[] {"flower","flow","flight"};
        String[] strs3 = new String[] {"dog","racecar","car"};
        String publicStr = test.longestCommonPrefix(strs1);

        System.out.println(publicStr);
    }

    /**
     *
     * @description 我写的方法
     * @author Will Li
     * @version
     * @date 2020年11月8日下午1:07:49
     * @param strs
     * @return
     */
//    public String longestCommonPrefix(String[] strs) {
//    	if(strs.length == 0) {
//    		return "";
//    	}
//
//    	//找出字符串数组中长度最小的字符串长度
//    	int minLength = strs[0].length();//记录最小长度
//    	for (int i = 0; i < strs.length; i++) {
//    		if(minLength > strs[i].length()) {
//    			minLength = strs[i].length();
//
//    		}
//		}
//
//    	String publicStr = "";
//
//    	for (int i = 0; i < minLength; i++) {
//    		int j;
//    		for (j = 0; j < strs.length-1; j++) {
//    			if( strs[j].charAt(i) == strs[j+1].charAt(i) ) {
//    				continue;
//    			}else {
//    				break;
//    			}
//			}
//    		j--;//这里j--是因为出了for后j++了一次
//    		if(j == strs.length-2) {
//    			publicStr = publicStr + strs[0].charAt(i);
//
//    		}else {
//    			break;
//    		}
//		}
//
//    	return publicStr;
//    }

    /**
     *
     * @description 用时19ms，内存38.7MB，比我一开始写的还要烂
     * 慢的原因是我写的compareCommon算法用了太多字符串拼接
     * 可以采用找公共下标，再一次性取子串的方法提高性能
     * @author Will Li
     * @version
     * @date 2020年11月8日下午1:29:41
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        String common = compareCommon(strs[0], strs[1]);

        for (int i = 2; i < strs.length; i++) {
            common = compareCommon(common, strs[i]);
        }

        return common;
    }

    public String compareCommon(String A, String B) {
        int minLength = Math.min( A.length(), B.length() );
        String common = "";
        for (int i = 0; i < minLength; i++) {
            if( A.charAt(i) == B.charAt(i)) {
                common = common + A.charAt(i);
            }else {
                return common;
            }
        }
        return common;
    }


}

