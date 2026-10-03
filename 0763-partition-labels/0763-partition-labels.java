class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int[] ch=new int[26];
        for(int i=0;i<n;i++){
            ch[s.charAt(i)-'a']=i;
        }
        int end=ch[s.charAt(0)-'a'];
        int start=0;
        for(int i=0;i<n;i++){
            end=Math.max(end,ch[s.charAt(i)-'a']);
            if(end==i) {
                ans.add(end-start+1);
                start=i+1;
            }
        }
        return ans;
    }
}