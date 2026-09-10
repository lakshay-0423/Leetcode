class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=arr.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) dq.pollLast();
            dq.addLast(i);
        }
        for(int i=k;i<n;i++){
            res[i-k]=arr[dq.peekFirst()];
            while(!dq.isEmpty() && i-k>=dq.peekFirst()) dq.pollFirst();
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) dq.pollLast();
            dq.addLast(i);
        }
        res[n-k] = arr[dq.peekFirst()];
        return res;
    }
}