//greedy
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] a = s.toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < a.length; i++) {
            last[a[i] - '0'] = i;
        }
        for (int i = 0; i < a.length; i++)
            for (int j = 9; j > a[i] - '0'; j--) {
                if (last[j] > i) {
                    char tmp = a[i];
                    a[i] = a[last[j]];
                    a[last[j]] = tmp;
                    return Integer.valueOf(new String(a));
                }
            }
        return num;
    }
}