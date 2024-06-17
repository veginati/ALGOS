//LC-713 Subarray Product Less Than K
class SubArrayProductK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int total=0;
        int curr=1;
        int startIdx=0;
        for(int i=0;i<nums.length;i++){
            curr*=nums[i];
            while(curr>=k && startIdx<=i){
                curr=curr/nums[startIdx++];
            }
            total+=(i-startIdx+1);
        }
        
        return total;
    }
}
