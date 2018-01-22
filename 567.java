public class Solution {
    public boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) count1[c - 'a']++;
        if (s2.length() < s1.length()) return false;
        int i;
        int start = 0;
        for (i = 0; i < s1.length(); i++) count2[s2.charAt(i) - 'a']++;
        while (i < s2.length()) {
            if (check(count1, count2)) return true;
            count2[s2.charAt(start) - 'a']--;
            count2[s2.charAt(i) - 'a']++;
            i++; start++;
        }
        if (check(count1, count2)) return true;
        return false;
    }
}