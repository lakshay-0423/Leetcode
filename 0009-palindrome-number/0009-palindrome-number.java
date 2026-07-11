class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n=0;
        int temp=x;
        while(temp!=0){
            n=n*10 + temp%10;
            temp=temp/10;
        }
        return n==x;
    }
}