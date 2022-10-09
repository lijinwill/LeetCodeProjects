package Trie_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: 这个和 Trie 一样，只是这个是自己尝试写一遍，用TrieNode明显好理解很多
 * @date 2022-05-03$ $
 */
public class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
    //将单词插入前缀树，即生成一颗前缀树
    public void insert(String word) {
        TrieNode node = this;
        for(int i=0; i<word.length(); i++){
            int pos = word.charAt(i) - 'a';
            //这里的意思是一层中有字母的位置才有节点
            if (node.children[pos] == null){
                node.children[pos] = new TrieNode();
            }
            node = node.children[pos];
        }
        //有true的地方表明到这里过有个单词
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = this;
        for(int i=0; i<word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if(node.children[pos] != null){
                node = node.children[pos];
            }else{
                return false;
            }
        }
        if(node != null && node.isEnd){
            return true;
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this;
        for(int i=0; i<prefix.length(); i++){
            int pos = prefix.charAt(i) - 'a';
            if(node.children[pos] != null){
                node = node.children[pos];
            }else{
                return false;
            }
        }
        return true;
    }

    //这个函数用于查看前缀树中，一个单词是否存在其全部前缀以及自身
    public boolean checkAllPrefix(String word){
        TrieNode node = this;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int pos = ch - 'a';
            //当前缀树中不存在前缀的节点 或是 不存在这个前缀为单词的结尾，则不满足存在全部前缀
            if(node.children[pos] == null || node.children[pos].isEnd == false){
                return false;
            }
            node = node.children[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */