class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int maxfreq=0;
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
            maxfreq=Math.max(maxfreq,freq[tasks[i]-'A']);
        }
        int ch=0;
        for(int i=0;i<26;i++){
            if(maxfreq==freq[i]) ch++;
        }
        return Math.max(tasks.length,(maxfreq-1)*(n+1)+ch);
    }
}