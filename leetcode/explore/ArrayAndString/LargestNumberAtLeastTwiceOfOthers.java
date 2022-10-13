class Solution {
    public int dominantIndex(int[] nums) {
        Integer first = null;
        Integer second = null;
        for (int i = 0; i < nums.length; i++) {
            if (first == null || nums[i] > nums[first]) {
                second = first;
                first = i;
            }else if (second == null || nums[i] > nums[second]) {
                second = i;
            }
        }
        return (nums[first] >= 2 * nums[second])? first : -1;
    }
}