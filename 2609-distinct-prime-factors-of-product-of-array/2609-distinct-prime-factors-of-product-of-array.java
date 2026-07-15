class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int val : nums){
            prime(val,set);
        }
        return set.size();
    }
    public void prime(int val,HashSet<Integer> set){
        while(val%2==0){
            set.add(2);
            val=val/2;
        }
        for(int i=3;i*i<=val;i++){
            while(val%i==0){
                set.add(i);
                val/=i;
            }
        }
        if(val>2) set.add(val);
    }
}