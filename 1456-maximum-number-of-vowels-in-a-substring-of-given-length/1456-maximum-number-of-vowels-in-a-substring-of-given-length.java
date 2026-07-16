class Solution {
    public int maxVowels(String s, int k) {
        int freq=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') freq++;
        }
        int maxfreq=freq;
        int i=0,j=k;
        while(j<s.length()){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') freq--;
            if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || s.charAt(j)=='o' || s.charAt(j)=='u') freq++;
            i++;
            j++;
            maxfreq=Math.max(freq,maxfreq);
        }
        return maxfreq;
    }
}