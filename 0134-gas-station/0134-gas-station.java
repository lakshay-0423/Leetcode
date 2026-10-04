class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0;
        int totalCost=0;
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost) return -1;
        int start=0;
        totalGas=0;
        totalCost=0;
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
            if(totalGas<totalCost){
                start=i+1;
                totalGas=0;
                totalCost=0;
            }
        }
        return start;
    }
}