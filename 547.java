class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        Set<Integer> student = new HashSet<Integer>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (student.contains(i)) continue;
            List<Integer> l = new ArrayList<Integer>();
            l.add(i);
            ans++;
            int j = 0;
            while (j < l.size()) {
                for (int k = 0; k < n; k++) {
                    if (M[l.get(j)][k] == 1 && !student.contains(k)) {
                        student.add(k);
                        l.add(k);
                    }
                }
                j++;
            }
        }
        return ans;
    }
}