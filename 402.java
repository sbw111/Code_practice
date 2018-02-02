class Solution {
    public String removeKdigits(String num, int k) {
        StringBuffer s = new StringBuffer(num);
        while (k > 0) {
            while (s.length() > 1 && s.charAt(0) == '0') s.deleteCharAt(0);
            int j = 0;
            while (j < s.length() - 1 && s.charAt(j) <= s.charAt(j + 1)) ++j;
            s.deleteCharAt(j);
            if (s.length() == 0) return "0";
            k--;
        }
        while (s.length() > 1 && s.charAt(0) == '0') s.deleteCharAt(0);
        return new String(s);
    }
}