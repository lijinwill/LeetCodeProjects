package Citi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/25 16:52
 */
public class Task6_2 {
    public static void main(String[] args) {
        String[] A = {"eva", "jqw", "tyn", "jan"};
        Task6_2 test = new Task6_2();
        System.out.println(test.solution(A));
    }

    ArrayList<ArrayList<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public int solution(String[] A) {
        int answer = 0;

        subsetHelper(A, 0);

        for (int i = 0; i < result.size(); i++) {
            StringBuilder temp = new StringBuilder();
            for (String s : result.get(i)) {
                temp.append(s);
            }
            if(isdifferent(temp.toString()) == true){
                answer = Math.max(answer, temp.length());
            }
        }

        return answer;
    }

    public void subsetHelper(String[] A, int startIndex){
        result.add(new ArrayList<>(path));
        if(startIndex >= A.length){
            return;
        }

        for (int i = startIndex; i<A.length; i++){
            path.add(A[i]);
            subsetHelper(A, i+1);
            path.removeLast();
        }
    }
    public boolean isdifferent(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
