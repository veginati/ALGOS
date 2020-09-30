package algorithms.greedy;

public class Jump {

    public static boolean canJump(int[] nums) {

        if(nums.length==1){
            return true;
        }

        int maxIndexReached = nums[0];

        for(int i=1;i<=maxIndexReached;i++){

            if(maxIndexReached>=nums.length-1){
                return true;
            }
            maxIndexReached = Math.max(maxIndexReached, i+nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }


}
