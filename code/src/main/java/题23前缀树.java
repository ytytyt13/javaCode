import java.util.HashMap;

/**
 * @author yang
 * 2021年05月08日 18:35:00
 */
public class 题23前缀树 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] s = {"abc","efgh","abcd","abc"};
        for (int i = 0; i < s.length; i++) {
            trie.insert(s[i]);
        }
        System.out.println(trie.search("abcde"));
    }

    public static class TrieNode {
        public int path;
        public int end;
        public HashMap<Character,TrieNode> nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert (String word) {
            if (word == null) {
                return ;
            }
            char[] chars = word.toCharArray();
            TrieNode node  = root;
            for (int i = 0; i < chars.length; i++) {
                TrieNode curnode = node.nexts.get(chars[i]);
                if (curnode == null) {
                    node.nexts.put(chars[i],new TrieNode());
                }
                node  = node.nexts.get(chars[i]);
                node.path++;
            }
            node.end++;
        }

        public  int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                TrieNode curnode = node.nexts.get(chars[i]);
                if (curnode == null) {
                    return 0;
                }
                node  = node.nexts.get(chars[i]);
            }
            return node.end;
        }

    }
}
