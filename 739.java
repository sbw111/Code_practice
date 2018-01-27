public class Solution {
    public class temp {
        int index;
        int t;

        public temp(int index, int t) {
            this.index = index;
            this.t = t;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<temp> p = new Stack<temp>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!p.isEmpty() && temperatures[i] > p.peek().t) {
                temp cur = p.pop();
                ans[cur.index] = (i - cur.index);
            }
            p.push(new temp(i, temperatures[i]));
        }
        return ans;
    }
}