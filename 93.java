class Solution {
    public boolean isVaild(String s) {
        if (((s.charAt(0) == '0') && (s.length() > 1)) || Integer.valueOf(s) > 255) return false;
        else return true;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        for (int a = 1; a < 4; a++)
            for (int b = 1; b < 4; b++)
                for (int c = 1; c < 4; c++)
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            String s1 = s.substring(0, a);
                            String s2 = s.substring(a, a + b);
                            String s3 = s.substring(a + b, a + b + c);
                            String s4 = s.substring(a + b + c, a + b + c + d);
                            if (isVaild(s1) && isVaild(s2) && isVaild(s3) && isVaild(s4))
                                ans.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                        }
                    }
        return ans;
    }
}