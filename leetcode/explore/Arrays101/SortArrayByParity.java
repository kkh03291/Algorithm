class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int pointer = 0 , tmp = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[pointer] % 2 == 0){
                pointer++;
                continue;
            }
            if(nums[i] % 2 == 0) {
                tmp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = tmp;
                pointer++;
            }
        }
        return nums;
    }
}