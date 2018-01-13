class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> a = new HashMap<Character, Integer>();
        int max = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (a.containsKey(s.charAt(i))) {
                max = Math.max(max, i - begin);
                begin = Math.max(begin, a.get(s.charAt(i)) + 1);
            }
            a.put(s.charAt(i), i);
        }
        max = Math.max(max, s.length() - begin);
        return max;
    }
}