class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int count=0;
        int i=0,j=n-1;
        while(i<j){
            if(people[j]+people[i]<=limit){
                i++;
                j--;
            }
            else j--;
            count++;
        }
        if(i==j) count++;
        return count;
    }
}