class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum < target)
                continue;
            while (sum >= target) {
                sum -= nums[start++];
            }
            res= Math.min(res, end - start + 2);
        }

        return res == Integer.MAX_VALUE? 0 : res;
    }
}