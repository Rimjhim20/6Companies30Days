class Solution {
    public double new21Game(int N, int K, int W) {
        if(K == 0)
            return 1.0;
        double[] preSum = new double[K+1];
        double currProb = 0.0;
        for(int i = K-1; i >= 0; --i) {
            int tmp = W - K +1 +i;
            double subtractVal = 0.0;
            if(tmp < 0){
                subtractVal = preSum[K+tmp];
                tmp = 0;
            }
            currProb = preSum[i+1]/W + ((double)Math.min(N-K+1, tmp))/W - subtractVal/W;
            preSum[i] = currProb + preSum[i+1];
        }
        return currProb;
    }
}