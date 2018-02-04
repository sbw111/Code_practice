class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        int j = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) != 'X') {
                while (end.charAt(j) == 'X') j++;
                if (start.charAt(i) == 'L') {
                    if (i < j) return false;
                } else if (i > j) return false;
                j++;
            }
        }
        return true;
    }
}