class Solution {
    public int[] sortArray(int[] array) {
        int n=array.length;
        BuildMaxHeap(array,n);
        for(int i=n-1;i>=1;i--){
          int temp=array[0];
          array[0]=array[i];
          array[i]=temp;
          heapify(array,i,0);
        }
        return array;
    }
    static void heapify (int array[], int n, int i) {

      int left=2*i+1;
      int right=2*i+2;
      int largest=i;
      if((left<n) && (array[left]>array[largest])) largest=left;
      if((right<n) && (array[right]>array[largest])) largest=right;
      if(largest!=i){
          int temp=array[i];
          array[i]=array[largest];
          array[largest]=temp;
          heapify(array,n,largest);
      }
  }

    static void BuildMaxHeap(int array[],int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(array,n,i);
        }
    }
    
}