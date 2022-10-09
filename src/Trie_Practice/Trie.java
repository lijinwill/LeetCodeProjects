package Trie_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-03$ $
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    //查找单词，必须在前缀树中完整的存在单词
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    //查找是否存在前缀，只需判断
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            //如果子树中该单词的其中一个字母位置为空，则直接返回null，表面不存在该前缀
            if (node.children[index] == null) {
                return null;
            }
            //当孩子节点存在单词对应的字母，就向树的下层遍历
            node = node.children[index];
        }
        return node;
    }
}
