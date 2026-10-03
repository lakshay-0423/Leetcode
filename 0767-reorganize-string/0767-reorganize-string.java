class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] freq=new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0) q.add(new int[]{i,freq[i]});
        }
        int[] prev=null;
        StringBuilder ans=new StringBuilder();
        while(!q.isEmpty()){
            int[] curr=q.remove();
            ans.append((char)(curr[0]+'a'));
            curr[1]--;
            if(prev!=null && prev[1]>0) q.add(prev);
            prev=curr;
        }
        String result=ans.toString();
        if(result.length()!=s.length()) return "";
        return result;
    }
}