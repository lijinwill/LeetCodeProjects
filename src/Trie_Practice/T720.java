package Trie_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-04$ $
 */
public class T720 {
    public static void main(String[] args) {
        String[] words = {"wo","wor","worl", "world"};
        //String[] words = {"a","banana","app","appl","ap","apply","apple"};
        T720 test = new T720();
        System.out.println(test.longestWord(words));
    }
    //思路：就是考察前缀树，用前缀树解决即可，注意最长的单词其前缀也必须都存在
    public String longestWord(String[] words) {
        int maxLen = 0;
        String result = "";
        TrieNode node = new TrieNode();

        //先把全部单词插入前缀树
        for(int i=0; i<words.length; i++){
            node.insert(words[i]);
        }

        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(node.checkAllPrefix(word) == true && word.length() > maxLen){
                maxLen = word.length();
                result = word;
            }else if(node.checkAllPrefix(word) == true && word.length() == maxLen){
                //这个if解决的是像 apple 与 apply 这种情况，会选择apple
                if(word.compareTo(result) < 0){
                    maxLen = word.length();
                    result = word;
                }
            }
        }
        return result;
    }
}
