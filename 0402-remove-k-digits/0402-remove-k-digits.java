class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> st=new Stack<>();
        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && st.peek()>ch && k>0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-->0) st.pop();

        StringBuilder sb=new StringBuilder();

        for(char ch : st) sb.append(ch);

        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);

        return sb.toString();
    }
}