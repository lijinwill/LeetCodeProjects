package Hash_Practice;

import java.util.HashMap;

/**
 * @Classname T383
 * @Description TODO
 * @Date 2022/7/7 13:39
 * @Created by Will
 */
public class T383 {
    //思路：遍历magazine，建立hashmap<Character,Integer>，然后遍历ransomNote即可
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            if (!hashmap.containsKey(c)){
                hashmap.put(c,1);
            }else{
                hashmap.put(c,hashmap.get(c) + 1);
            }
        }
        for (int i=0; i<ransomNote.length(); i++){
            char c2 = ransomNote.charAt(i);
            if (hashmap.containsKey(c2)){
                hashmap.put(c2,hashmap.get(c2)-1);
                if (hashmap.get(c2) < 0) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
