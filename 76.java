// move end to find a vaild substring, move start to find a smaller window
class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[128];
        for (char c : t.toCharArray()) m[c]++;
        int end = 0, start = 0, count = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (m[s.charAt(end)] > 0) count++;
            m[s.charAt(end)]--;
            end++;
            while (count == t.length()) { //find vaild substring
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }
                ++m[s.charAt(start)];
                if (m[s.charAt(start)] > 0) count--;
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        else return s.substring(minStart, minStart + minLen);
    }
}