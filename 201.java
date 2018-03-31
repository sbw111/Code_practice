class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int q = Integer.MAX_VALUE;
        while ((m & q) != (n & q)) q = q << 1;
        return (m & q);
    }
}