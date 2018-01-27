//DFS + HashMap
class Solution {
    public List<List<String>> partition(String s) {
        return dfs(s, new HashMap<String, List<List<String>>>());
    }

    public boolean isVaild(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }

    public List<List<String>> dfs(String s, Map<String, List<List<String>>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<List<String>> ans = new LinkedList<List<String>>();
        if (s.length() == 0) {
            ans.add(new LinkedList<String>());
            return ans;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isVaild(s.substring(0, i))) {
                List<List<String>> res = dfs(s.substring(i), map);
                for (List<String> l : res) {
                    l.add(0, s.substring(0, i));
                    ans.add(new LinkedList<String>(l));
                    l.remove(0);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}