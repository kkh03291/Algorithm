class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return ;
        }

        int writePointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[writePointer] != 0){
                writePointer++;
                continue;
            }
            if (nums[i] != 0) {
                nums[writePointer] = nums[i];
                nums[i] = 0;
                writePointer++;
            }
        }

    }
}