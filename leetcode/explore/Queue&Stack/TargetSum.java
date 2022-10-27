class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0 , 0);
    }

    public int find(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            return (target == sum) ? 1 : 0;
        }

        int result = 0;
        int value = nums[index];
        int plusSum = sum + value;
        int minusSum = sum - value;
        index++;
        result += find(nums, target, index, plusSum);
        result += find(nums, target, index, minusSum);
        return result;
    }
}