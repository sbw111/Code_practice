//binary search
class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        double l = 0, r = stations[n - 1] - stations[0];
        while (l + 1e-6 < r){
            double mid = (l + r)/2;
            int count = 0;
            for (int i = 0; i < n - 1; ++i)
                count += Math.ceil((stations[i + 1] - stations[i])/mid) - 1;
            if (count <= K) r = mid;
            else l = mid;
        }
        return r;
    }
}