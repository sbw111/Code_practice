import java.lang.*;
import java.util.*;
import java.math.*;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int res = 99999;
        Set<Integer> dou = new HashSet<Integer>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                dou.add(fronts[i]);
            }
        }
        for (int i = 0; i < fronts.length; i++) {
            if (!dou.contains(fronts[i]) && fronts[i] < res) res = fronts[i];
            if (!dou.contains(backs[i]) && backs[i] < res) res = backs[i];
        }
        if (res == 99999) return 0;
        return res;
    }
}