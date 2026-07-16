class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int msum=0;
        for(int i=0;i<k;i++){
            msum+=nums[i];
        }
        int sum=msum;
        int i=0,j=k;
        while(j<nums.length){
            sum-=nums[i++];
            sum+=nums[j++];
            msum=Math.max(sum,msum);
        }
        return (double)msum/k;
    }
}