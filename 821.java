import java.lang.*;
import java.util.*;
import java.math.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] answer = new int[n];
        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            answer[i] = n + 1;
            if (S.charAt(i) == C) {
                index.add(i);
                answer[i] = 0;
            }
        }
        for (int i = 0; i < index.size(); ++i) {
            int count = 0;
            int l = index.get(i);
            int r = index.get(i);
            while (l >= 0 && answer[l] >= count) {
                answer[l] = count;
                l--;
                count++;
            }
            count = 0;
            while (r < n && answer[r] >= count) {
                answer[r] = count;
                r++;
                count++;
            }
        }
        return answer;
    }
}