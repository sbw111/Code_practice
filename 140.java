//DFS + HashMap
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return find(s, wordDict, map);
    }

    public List<String> find(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> ans = new ArrayList<String>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> cur = find(s.substring(word.length()), wordDict, map);
                for (String newStr : cur) {
                    ans.add(word + (newStr.isEmpty() ? "" : " ") + newStr);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}