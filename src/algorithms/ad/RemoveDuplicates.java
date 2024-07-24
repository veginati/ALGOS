package algorithms.ad;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int startIndex=0;
        int currIndex=0;
        int prevNum = -100000;
        int count=1;
        while(currIndex <nums.length){

            if(nums[currIndex] !=prevNum){
                count=1;
                prevNum = nums[currIndex];
            }else{
                count++;
            }

            if(count<3){
                nums[startIndex++]= nums[currIndex];
            }
            currIndex++;
        }

        return startIndex;
    }
}
