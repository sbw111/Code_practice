class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    public Trie buildTree(String words[]) {
        Trie root = new Trie();
        for (String s : words) {
            Trie p = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new Trie();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }

    public void dfs(char[][] board, List<String> ans, int i, int j, Trie root) {
        char c = board[i][j];
        if (board[i][j] == '.' || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        board[i][j] = '.';
        if (i > 0) dfs(board, ans, i - 1, j, root);
        if (j > 0) dfs(board, ans, i, j - 1, root);
        if (i < board.length - 1) dfs(board, ans, i + 1, j, root);
        if (j < board[i].length - 1) dfs(board, ans, i, j + 1, root);
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Trie root = buildTree(words);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                dfs(board, ans, i, j, root);
        return ans;
    }
}