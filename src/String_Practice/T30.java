package String_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        T30 test = new T30();
        List<Integer> result = test.findSubstring(s, words);
        System.out.println("hello");
    }
    //思路：遍历一个HashMap，key是words中的每一个字符串，value是s中单词在出现的次数
    //     双指针遍历s，一个指向单词开头，一个指向末尾，每次取该单词去hashmap中寻找
    //     若找出该单词，则左指针成为新单词的开头，右指针继续右移，hashmap中该单词访问次数+1
    //     若没有找出该单词，则右指针右移，直到截取的单词长度大于words中单词的最大长度，结束这一层的循环
    //     用count记录hashmap中添加元素的次数，如果最终次数等于words中单词个数且每个value都是1，则成功找出
    //     否则视为未找出，继续下一轮循环
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> hashmap = new HashMap<>();
        //初始化hashmap，并统计words中单词的最小长度与最大长度
        int maxLen = words[0].length(), minLen = words[0].length(), wordLen = 0;

        for (int k=0; k<words.length; k++){
            String word = words[k];
            if (hashmap.containsKey(word)){
                hashmap.put(word, hashmap.get(word)+1);
            }else{
                hashmap.put(word,1);
            }
            wordLen+= word.length();
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        for (int i=0; i<=s.length()-wordLen; i++){
            //重置hashmap
            hashmap = new HashMap<>();
            for (int k=0; k<words.length; k++) {
                String word = words[k];
                if (hashmap.containsKey(word)) {
                    hashmap.put(word, hashmap.get(word) + 1);
                } else {
                    hashmap.put(word, 1);
                }
            }
            for (int left=i, right=i+minLen; left<i+wordLen && right<=left+maxLen; ){
                String temp = s.substring(left,right);
                if (hashmap.containsKey(temp) && hashmap.get(temp)>1){
                    hashmap.put(temp, hashmap.get(temp)-1);
                    left = right;
                    right = left + minLen;
                }else if(hashmap.containsKey(temp) && hashmap.get(temp)==1){
                    hashmap.remove(temp);
                    left = right;
                    right = left + minLen;
                }else{
                    right++;
                }
            }
            if (hashmap.isEmpty()){
                result.add(i);
            }
        }
        return result;
    }
}
