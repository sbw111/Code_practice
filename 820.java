import java.lang.*;
import java.util.*;
import java.math.*;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return -1;
                else if (o1.length() > o2.length())
                    return 1;
                return o1.compareTo(o2);
            }
        });
        Collections.addAll(set, words);
        List<String> w = new ArrayList<>(set);
        int j = 0;
        for (int i = 0; i < w.size(); ) {
            String s = w.get(i);
            for (j = i + 1; j < w.size(); j++) {
                if (i == j) continue;
                if (w.get(j).endsWith(s)) {
                    w.remove(i);
                    break;
                }
            }
            if (j == w.size()) i++;
        }
        int ans = w.size();
        for (int i = 0; i < w.size(); i++) ans += w.get(i).length();
        return ans;
    }
}