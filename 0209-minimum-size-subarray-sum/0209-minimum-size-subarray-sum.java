class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size=0,sum=0,minsize=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0,j=0;i<n;i++){
            sum+=nums[i];
            size++;
            while(sum>=target){
                minsize=Math.min(size,minsize);
                sum-=nums[j++];
                size--;
            }
        }
        if(minsize==Integer.MAX_VALUE) return 0;
        return minsize;
    }
}