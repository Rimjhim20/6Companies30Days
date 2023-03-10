class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if((sum%k)!=0)
            return false;
        boolean[]visited=new boolean[nums.length];
        Arrays.fill(visited,false);
        Arrays.sort(nums);
        int target=sum/k;
        return dfs(nums,0,k,target,0,visited);
    }
    private boolean dfs(int[]nums,int index,int k,int target,int subsetsum,boolean[]visited)
    {
        if(k==0)
            return true;
        if(subsetsum==target)
            return dfs(nums,0,k-1,target,0,visited);
        for(int i=index;i<nums.length;i++)
        {
            if(subsetsum+nums[i]>target)
                return false;
            if(visited[i])
                continue;
            
            visited[i]=true;
            if(dfs(nums,i+1,k,target,subsetsum+nums[i],visited))
                return true;
            visited[i]=false;
        }
        return false;
    }
}