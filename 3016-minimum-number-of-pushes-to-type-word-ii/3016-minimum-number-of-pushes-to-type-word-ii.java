class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<=8) return n;
        int[] freq=new int[26];
        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        int ans=0;
        int count=0;
        int push=1;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            ans+=freq[i]*push;
            count++;
            if(count==8){
                count=0;
                push++;
            }
        }
        return ans;
    }
}