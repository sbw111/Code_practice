class Solution {
    public int find(int N, int K) {
        if (N == 1) return 0;
        else {
            int p = find(N - 1, K / 2);
            if (p == 0) {
                if (K % 2 == 0) return 0;
                else return 1;
            } else {
                if (K % 2 == 0) return 1;
                else return 0;
            }
        }
    }

    public int kthGrammar(int N, int K) {
        return find(N, K - 1);
    }
}