class Solution {
    boolean flag = false;
    final double p = 0.0001;

    public void dfs(List<Double> arr) {
        if (flag) return;
        if (arr.size() == 1) {
            flag = Math.abs(24 - arr.get(0)) < p;
            return;
        }
        for (int i = 0; i < arr.size() - 1; ++i)
            for (int j = i + 1; j < arr.size(); ++j) {
                double p1 = arr.get(i), p2 = arr.get(j);
                List<Double> next = new ArrayList<>(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                if (Math.abs(p2) > p) next.add(p1 / p2);
                if (Math.abs(p1) > p) next.add(p2 / p1);
                arr.remove(j);
                arr.remove(i);
                for (Double n : next) {
                    arr.add(n);
                    dfs(arr);
                    arr.remove(arr.size() - 1);
                }
                arr.add(i, p1);
                arr.add(j, p2);
            }
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new LinkedList<Double>();
        for (int n : nums) arr.add(Double.valueOf(n));
        dfs(arr);
        return flag;
    }
}