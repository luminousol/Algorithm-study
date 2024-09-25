package juyeon.PGS.gillbut_re.dataStructure;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> child;
    int count = 0;

    TrieNode() {
        this.child = null;
    }

    public Map<Character, TrieNode> getChild() {
        if (child == null) child = new HashMap<>();
        return child;
    }
}

class Trie {
    TrieNode front = new TrieNode();
    TrieNode back = new TrieNode();

    void insert(String word) {
        TrieNode frontNode = front;
        for (int i = 0; i < word.length(); i++) {
            frontNode.count++;
            frontNode = frontNode.getChild().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        TrieNode backNode = back;
        for (int i = word.length() - 1; i >= 0; i--) {
            backNode.count++;
            backNode = backNode.getChild().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
    }

    int getCount(String query) {
        return (query.charAt(0) == '?') ? getCountFrom(back, query, false) : getCountFrom(front, query, true);
    }

    private int getCountFrom(TrieNode node, String query, boolean isFront) {
        int start = isFront ? 0 : query.length() - 1;
        int step = isFront ? 1 : -1;

        for (int i = start; i < query.length(); i += step) {
            if (query.charAt(i) == '?') break;
            if (!node.child.containsKey(query.charAt(i))) return 0;
            node = node.getChild().get(query.charAt(i));
        }

        return node.count;
    }
}

public class P55_가사_검색_2 {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> tries = new HashMap<>();

        for (String word : words) {
            int len = word.length();

            tries.computeIfAbsent(len, k -> new Trie()).insert(word);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();

            if (!tries.containsKey(len)) answer[i] = 0;
            else answer[i] = tries.get(len).getCount(queries[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        P55_가사_검색_2 p55 = new P55_가사_검색_2();

        System.out.println(Arrays.toString(p55.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))); // 3, 2, 4, 1, 0
    }
}
