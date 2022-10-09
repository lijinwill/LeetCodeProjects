package Heap;

import java.util.HashMap;
import java.util.Map;

public class T451 {
    public static void main(String[] args) {
        String s = "ewvsdvtrwreee";
        T451 test = new T451();
        System.out.println(test.frequencySort(s));
    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        //统计所有字符的出现次数
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char char_temp = s.charAt(i);
            if(map.containsKey(char_temp)){
                map.put(char_temp, map.get(char_temp)+1);
            }else{
                map.put(char_temp, 1);
            }
        }

        //找出最多出现的次数
        int max = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }

        //重新降序输出
        StringBuffer result = new StringBuffer();
        while(max > 0){
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    for(int k=0; k<entry.getValue(); k++){
                        result.append(entry.getKey());
                    }
                }
            }
            max--;
        }

        return result.toString();
    }

}
