class Solution {
    public double minmaxGasDist(int[] stations, int K) {

        double start = 0, end = 1e8;

        while (start + 1e-6 < end) {
            double mid = (start + end) / 2;

            if (valid(mid, stations, K)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;

    }

    private boolean valid(double D, int[] stations, int K) {

        int used = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            used += (int) ((stations[i + 1] - stations[i]) / D);
        }
        return used <= K;
    }
}
