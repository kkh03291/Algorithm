class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int lastIndex = nums.length - 1;
        for (i = 0; i <= lastIndex; i++) {
            if (nums[i] == val) {
                nums[i] = nums[lastIndex];
                nums[lastIndex] = val;
                i--;
                lastIndex--;
            }
        }
        return i;
    }
}