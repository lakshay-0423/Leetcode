class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n=b.length();
        int m=a.length();
        int repeat=(int)Math.ceil((double)n/m);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<repeat;i++){
            sb.append(a);
        }
        String repeated=sb.toString();
        if(kmp(repeated,b)) return repeat;
        sb.append(a);
        repeat++;
        repeated=sb.toString();
        if(kmp(repeated,b)) return repeat;
        return -1;
    }
    public void constructlps(int[] lps,String b){
        int n=b.length();
        int i=1;
        int len=0;
        while(i<n){
            if(b.charAt(len)==b.charAt(i)){
                len++;
                lps[i++]=len;
            }
            else{
                if(len==0) lps[i++]=0;
                else{
                    len=lps[len-1];
                }
            }
        }
    }
    public boolean kmp(String a,String b){
        int n=b.length();
        int m=a.length();
        int[] lps=new int[n];
        constructlps(lps,b);
        int i=0,j=0;
        while(i<m){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
                if(j==n){
                    return true;
                }
            }
            else{
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        return false;
    }
}