package Trie;


public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("amman");
        trie.insert("shandle");
        trie.insert("abood");
        trie.insert("abdddde");
        trie.insert("lolo");
        
        System.out.println(trie.startsWith("m"));
    }
    
}
