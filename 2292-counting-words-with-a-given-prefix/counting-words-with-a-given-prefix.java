class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        count = 0;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode pCrawl = root;
        for(char ch : word.toCharArray()) {
            int index = ch  - 'a';
            if(pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
            pCrawl.count++;
        }
        pCrawl.isEndOfWord = true;
    }

    int searchPrefixCount(String pref) {
        TrieNode pCrawl = root;
        for(char ch : pref.toCharArray()) {
            int index = ch - 'a';
            if(pCrawl.children[index] == null) {
                return 0;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.count;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        return trie.searchPrefixCount(pref);
    }
}
/**
TC = O(no of words ^ avg length of word + length of prefix)
SC = O(no of words ^ avg length of word)
 */