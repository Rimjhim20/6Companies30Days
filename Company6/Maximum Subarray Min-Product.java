class Solution {
    public int maxSumMinProduct(int[] nums) {
      long res=0;
      Stack<long[]> stk=new Stack<>();
      for(int i=0;i<nums.length;i++) {
          long sum=0;
          while(!stk.isEmpty()&&stk.peek()[0]>nums[i]) {
              long[] cur=stk.pop();
              res=Math.max(res, cur[0]*(cur[1]+sum));
              sum+=cur[1];
          }
          stk.push(new long[]{nums[i], sum+nums[i]});
      }
      long sum=0;
      while(!stk.isEmpty()) {
          long[] cur=stk.pop();
          res=Math.max(res, cur[0]*(cur[1]+sum));
          sum+=cur[1];
      }
      return (int)(res%1000000007);
  }
}