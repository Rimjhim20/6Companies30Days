class Solution {
    public int maxRotateFunction(int[] A) {
       int sumA = 0; int prevRotationSum = 0;
       for (int i = 0; i < A.length; i++) {
           sumA += A[i];
           prevRotationSum += i * A[i];
       }
       int max = prevRotationSum;

       for (int i = A.length -1; i > 0; i--){
           prevRotationSum += sumA - A.length * A[i];
           max = Math.max(prevRotationSum, max);
       }
       return max;
   }
}