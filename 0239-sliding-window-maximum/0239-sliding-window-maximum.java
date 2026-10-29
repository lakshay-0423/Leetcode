class Pair{
    int val;
    int idx;
    Pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Pair> heap=new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
        int n=arr.length;
        int[] result=new int[n-k+1];
        for(int i=0;i<k;i++){
            heap.add(new Pair(arr[i],i));
        }
        result[0]=heap.peek().val;
        int j=1;
        for(int i=k;i<n;i++){
            heap.add(new Pair(arr[i],i));
            while(!heap.isEmpty() && heap.peek().idx<i-k+1) heap.poll();
            result[j++]=heap.peek().val;
        }
        return result;
    }
}