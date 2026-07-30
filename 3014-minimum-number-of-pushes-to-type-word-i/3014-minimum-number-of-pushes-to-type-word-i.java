class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int i=0;
        int sum=0;
        while(n>=8){
            i++;
            sum+=8*i;
            n-=8;
        }
        i++;
        if(n>0) sum+=n*i;
        return sum;
    }
}