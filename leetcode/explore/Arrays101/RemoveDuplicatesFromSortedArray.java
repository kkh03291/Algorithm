class Solution {
    public int removeDuplicates(int[] nums) {
        int lower = 1;
        for (int faster = 1; faster< nums.length; faster++){
            if (nums[faster - 1] != nums[faster]){
                nums[lower] = nums[faster];
                lower++;
            }
        }
        return lower;
    }
}